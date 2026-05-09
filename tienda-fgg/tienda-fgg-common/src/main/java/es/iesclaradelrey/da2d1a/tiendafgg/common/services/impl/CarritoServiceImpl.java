package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.ItemCarrito;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Usuario;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.ItemCarritoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.UsuarioRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CarritoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de carrito de compra.
 * <p>
 * Coordina la persistencia de ítems individuales vinculándolos a usuarios y productos.
 * Utiliza proxies de Hibernate para optimizar las inserciones y transaccionalidad
 * para asegurar la consistencia de las operaciones de modificación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class CarritoServiceImpl implements CarritoService {

    private final ItemCarritoRepository carritoRepository;
    private final UsuarioRepository     usuarioRepository;
    private final VideojuegoRepository  videojuegoRepository;

    public CarritoServiceImpl(ItemCarritoRepository carritoRepository,
                              UsuarioRepository usuarioRepository,
                              VideojuegoRepository videojuegoRepository) {
        this.carritoRepository   = carritoRepository;
        this.usuarioRepository   = usuarioRepository;
        this.videojuegoRepository = videojuegoRepository;
    }

    /**
     * Recupera el contenido actual del carrito de un usuario.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ItemCarrito> getItems(Long usuarioId) {
        return carritoRepository.findByUsuarioId(usuarioId);
    }

    /**
     * Añade un producto al carrito o incrementa su cantidad si ya existía.
     * <p>
     * Optimización: Utiliza {@code getReferenceById} para evitar consultas SELECT
     * innecesarias a las entidades relacionadas durante la creación de un nuevo ítem.
     * </p>
     */
    @Override
    @Transactional
    public ItemCarrito addOrUpdateItem(Long usuarioId, Long videojuegoId, Integer unidades) {
        Optional<ItemCarrito> existing =
                carritoRepository.findByUsuarioIdAndVideojuegoId(usuarioId, videojuegoId);

        if (existing.isPresent()) {
            ItemCarrito item = existing.get();
            item.setUnidades(item.getUnidades() + unidades);
            return carritoRepository.save(item);
        }

        Usuario    usuario    = usuarioRepository.getReferenceById(usuarioId);
        Videojuego videojuego = videojuegoRepository.getReferenceById(videojuegoId);

        ItemCarrito nuevo = ItemCarrito.builder()
                .usuario(usuario)
                .videojuego(videojuego)
                .unidades(unidades)
                .build();
        return carritoRepository.save(nuevo);
    }

    /**
     * Elimina una línea específica del carrito.
     */
    @Override
    @Transactional
    public void removeItem(Long usuarioId, Long videojuegoId) {
        carritoRepository.deleteByUsuarioIdAndVideojuegoId(usuarioId, videojuegoId);
    }

    /**
     * Vacía completamente el carrito del usuario (ej: tras confirmar pedido).
     */
    @Override
    @Transactional
    public void clearCart(Long usuarioId) {
        carritoRepository.deleteByUsuarioId(usuarioId);
    }
}