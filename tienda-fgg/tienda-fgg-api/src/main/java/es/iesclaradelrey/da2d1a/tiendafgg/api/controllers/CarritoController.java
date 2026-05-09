package es.iesclaradelrey.da2d1a.tiendafgg.api.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.AddToCartRequestDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.CartResponseDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.exception.*;
import es.iesclaradelrey.da2d1a.tiendafgg.api.mapper.CarritoMapper;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.ItemCarrito;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.ItemCarritoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CarritoService;
import es.iesclaradelrey.da2d1a.tiendafgg.security.UsuarioDetalles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestión del carrito de la compra.
 * <p>
 * Proporciona endpoints para consultar, añadir, eliminar y vaciar productos
 * del carrito de un usuario autenticado. Implementa validaciones críticas
 * de stock y existencia de productos.
 * </p>
 * * @author Fernando Granada
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/cart")
public class CarritoController {

    private final CarritoService         carritoService;
    private final ItemCarritoRepository  carritoRepository;
    private final VideojuegoRepository   videojuegoRepository;
    private final CarritoMapper          carritoMapper;

    /**
     * Constructor con inyección de dependencias para servicios, repositorios y mappers.
     */
    public CarritoController(CarritoService carritoService,
                             ItemCarritoRepository carritoRepository,
                             VideojuegoRepository videojuegoRepository,
                             CarritoMapper carritoMapper) {
        this.carritoService      = carritoService;
        this.carritoRepository   = carritoRepository;
        this.videojuegoRepository = videojuegoRepository;
        this.carritoMapper       = carritoMapper;
    }

    /**
     * Recupera el estado actual del carrito del usuario autenticado.
     * * @param userDetails Usuario obtenido del contexto de seguridad JWT.
     * @return {@link CartResponseDto} con los productos y totales calculados.
     */
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<CartResponseDto> getCarrito(
            @AuthenticationPrincipal UsuarioDetalles userDetails) {
        Long usuarioId = userDetails.getUsuario().getId();
        return ResponseEntity.ok(buildCartResponse(usuarioId));
    }

    /**
     * Añade o actualiza la cantidad de un producto en el carrito.
     * <p>
     * Realiza comprobaciones de:
     * 1. Existencia del videojuego.
     * 2. Validez de unidades solicitadas.
     * 3. Disponibilidad de stock real comparando con lo que ya hay en el carrito.
     * </p>
     * * @param dto Información del producto y unidades a añadir.
     * @param userDetails Usuario autenticado.
     * @return Estado 201 (Created) y el carrito actualizado.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<CartResponseDto> addToCarrito(
            @RequestBody AddToCartRequestDto dto,
            @AuthenticationPrincipal UsuarioDetalles userDetails) {

        Long usuarioId = userDetails.getUsuario().getId();

        Videojuego videojuego = videojuegoRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new ProductoNotFoundException(dto.getProductoId()));

        if (dto.getUnidades() == null || dto.getUnidades() <= 0) {
            throw new UnidadesInvalidasException();
        }

        int yaEnCarrito = carritoRepository
                .findByUsuarioIdAndVideojuegoId(usuarioId, dto.getProductoId())
                .map(ItemCarrito::getUnidades)
                .orElse(0);

        if (videojuego.getStock() < yaEnCarrito + dto.getUnidades()) {
            throw new StockInsuficienteException(
                    dto.getProductoId(), videojuego.getStock(), yaEnCarrito + dto.getUnidades());
        }

        carritoService.addOrUpdateItem(usuarioId, dto.getProductoId(), dto.getUnidades());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(buildCartResponse(usuarioId));
    }

    /**
     * Elimina un producto específico del carrito del usuario.
     */
    @DeleteMapping("/{productId}")
    @Transactional
    public ResponseEntity<CartResponseDto> removeFromCarrito(
            @PathVariable Long productId,
            @AuthenticationPrincipal UsuarioDetalles userDetails) {

        Long usuarioId = userDetails.getUsuario().getId();

        if (!videojuegoRepository.existsById(productId)) {
            throw new ProductoNotFoundException(productId);
        }

        if (!carritoRepository.existsByUsuarioIdAndVideojuegoId(usuarioId, productId)) {
            throw new ProductoNoEnCarritoException(productId);
        }

        carritoService.removeItem(usuarioId, productId);

        return ResponseEntity.ok(buildCartResponse(usuarioId));
    }

    /**
     * Vacía completamente el carrito del usuario autenticado.
     */
    @DeleteMapping
    @Transactional
    public ResponseEntity<CartResponseDto> vaciarCarrito(
            @AuthenticationPrincipal UsuarioDetalles userDetails) {
        Long usuarioId = userDetails.getUsuario().getId();
        carritoService.clearCart(usuarioId);
        return ResponseEntity.ok(buildCartResponse(usuarioId));
    }

    /**
     * Método privado de soporte para encapsular la lógica de construcción de la respuesta.
     * Agrega los cálculos de totales procedentes del repositorio.
     */
    private CartResponseDto buildCartResponse(Long usuarioId) {
        List<ItemCarrito> items = carritoService.getItems(usuarioId);
        return new CartResponseDto(
                carritoMapper.toDtoList(items),
                carritoRepository.countProductosDistintos(usuarioId),
                carritoRepository.sumUnidades(usuarioId),
                carritoRepository.calcularImporteTotal(usuarioId)
        );
    }
}