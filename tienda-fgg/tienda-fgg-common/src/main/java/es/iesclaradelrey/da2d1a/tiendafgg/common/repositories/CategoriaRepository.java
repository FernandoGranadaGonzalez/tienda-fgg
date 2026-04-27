package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato para las operaciones de persistencia de {@link Categoria}.
 * <p>
 * Al extender de {@link GenericoRepository}, hereda las operaciones básicas de gestión,
 * especializándose en el manejo de entidades de tipo Categoria con claves de tipo Long.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
public interface CategoriaRepository extends GenericoRepository<Categoria, Long> {

    /**
     * Recupera el listado completo de categorías existentes en el sistema.
     * * @return Una {@link List} con todas las {@link Categoria}.
     * Si no existen registros, devuelve una lista vacía.
     */
    List<Categoria> obtenerTodos();

    /**
     * Realiza una búsqueda de una categoría específica por su identificador único.
     * * @param id El identificador (Long) de la categoría buscada.
     * @return Un {@link Optional} que contiene la {@link Categoria} si se encuentra,
     * o un {@link Optional#empty()} si el ID no corresponde a ninguna entidad.
     */
    Optional<Categoria> buscarPorId(Long id);
}