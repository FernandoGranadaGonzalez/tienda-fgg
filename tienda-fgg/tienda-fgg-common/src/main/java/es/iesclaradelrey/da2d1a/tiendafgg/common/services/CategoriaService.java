package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones de negocio para la gestión de {@link Categoria}.
 * <p>
 * Este servicio actúa como la capa de abstracción entre la lógica de la aplicación
 * y los mecanismos de persistencia. Cualquier implementación de esta interfaz
 * debe encargarse de coordinar las reglas de negocio necesarias para estas operaciones.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
public interface CategoriaService {

    /**
     * Recupera todas las categorías registradas en el sistema.
     * * @return Una {@link List} con todas las categorías disponibles.
     */
    List<Categoria> obtenerTodos();

    /**
     * Busca una categoría específica por su identificador único.
     * * @param id El identificador de la categoría.
     * @return Un {@link Optional} que contiene la categoría si se encuentra,
     * o {@link Optional#empty()} en caso contrario.
     */
    Optional<Categoria> buscarPorId(Long id);

    /**
     * Realiza el proceso de persistencia de una categoría.
     * <p>
     * Este método puede ser utilizado tanto para registrar una nueva categoría
     * como para actualizar los datos de una existente.
     * </p>
     * * @param categoria La instancia de la categoría a procesar.
     */
    void guardar(Categoria categoria);
}