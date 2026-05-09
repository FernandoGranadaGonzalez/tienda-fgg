package es.iesclaradelrey.da2d1a.tiendafgg.api.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.VideojuegoDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.mapper.VideojuegoMapper;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión y consulta de productos (Videojuegos).
 * <p>
 * Proporciona endpoints para recuperar el catálogo completo o filtrado por categoría,
 * asegurando siempre una presentación ordenada de los datos mediante el uso
 * de la infraestructura de Spring Data.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class ProductoApiController {

    private final VideojuegoRepository videojuegoRepository;
    private final VideojuegoMapper     videojuegoMapper;

    /**
     * Inyección de dependencias necesaria para la persistencia y mapeo de productos.
     */
    public ProductoApiController(VideojuegoRepository videojuegoRepository,
                                 VideojuegoMapper videojuegoMapper) {
        this.videojuegoRepository = videojuegoRepository;
        this.videojuegoMapper     = videojuegoMapper;
    }

    /**
     * Recupera el listado global de productos.
     * <p>
     * Se aplica una ordenación alfabética ascendente por el campo 'titulo'.
     * Utiliza el método {@code findAll(Sort)} heredado de {@code PagingAndSortingRepository}.
     * </p>
     *
     * @return {@link ResponseEntity} con la lista de {@link VideojuegoDto}.
     */
    @GetMapping("/products")
    public ResponseEntity<List<VideojuegoDto>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "titulo");
        List<Videojuego> productos = videojuegoRepository.findAll(sort);
        return ResponseEntity.ok(videojuegoMapper.toDtoList(productos));
    }

    /**
     * Recupera los productos pertenecientes a una categoría específica.
     * <p>
     * Este endpoint sigue las convenciones de rutas REST para recursos anidados.
     * Utiliza una consulta derivada en el repositorio que acepta un objeto {@link Sort},
     * permitiendo una ordenación dinámica sin necesidad de nombres de métodos excesivamente largos.
     * </p>
     *
     * @param categoryId Identificador único de la categoría.
     * @return {@link ResponseEntity} con la lista de productos filtrados y ordenados.
     */
    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<VideojuegoDto>> getByCategoryId(
            @PathVariable Long categoryId) {

        Sort sort = Sort.by(Sort.Direction.ASC, "titulo");
        List<Videojuego> productos =
                videojuegoRepository.findByCategoriasId(categoryId, sort);

        return ResponseEntity.ok(videojuegoMapper.toDtoList(productos));
    }
}