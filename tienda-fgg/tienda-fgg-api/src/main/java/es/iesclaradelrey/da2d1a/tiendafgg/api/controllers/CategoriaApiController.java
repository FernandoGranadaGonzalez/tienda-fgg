package es.iesclaradelrey.da2d1a.tiendafgg.api.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendafgg.api.mapper.CategoriaMapper;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la exposición de categorías de productos.
 * <p>
 * Proporciona un punto de acceso público para obtener el catálogo de categorías,
 * aplicando criterios de ordenación directamente en la consulta a la base de datos.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoriaApiController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper     categoriaMapper;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param categoriaRepository Repositorio para el acceso a datos de categorías.
     * @param categoriaMapper Mapper para transformar entidades en DTOs.
     */
    public CategoriaApiController(CategoriaRepository categoriaRepository,
                                  CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper     = categoriaMapper;
    }

    /**
     * Recupera el listado completo de categorías.
     * <p>
     * Implementa el requisito de ordenación alfabética ascendente mediante el uso
     * del objeto {@link Sort}, delegando la responsabilidad del orden al motor
     * de la base de datos (SQL ORDER BY).
     * </p>
     *
     * @return {@link ResponseEntity} que contiene la lista de {@link CategoriaDto}.
     */
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");

        List<Categoria> categorias = categoriaRepository.findAll(sort);

        return ResponseEntity.ok(categoriaMapper.toDtoList(categorias));
    }
}