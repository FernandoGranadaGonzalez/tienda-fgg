package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los servicios de negocio para la gestión de {@link Videojuego}.
 * <p>
 * Expone las capacidades necesarias para administrar el catálogo de productos,
 * permitiendo búsquedas avanzadas por criterios específicos y operaciones CRUD.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface VideojuegoService {

    /**
     * Recupera el catálogo completo de videojuegos.
     *
     * @return Una {@link List} con todos los videojuegos registrados.
     */
    List<Videojuego> obtenerTodos();

    /**
     * Filtra y recupera los videojuegos que pertenecen a una categoría determinada.
     *
     * @param categoriaId Identificador único de la categoría.
     * @return Lista de videojuegos asociados a la categoría indicada.
     */
    List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId);

    /**
     * Realiza una búsqueda de videojuegos basada en un término de búsqueda.
     * <p>
     * El servicio debe procesar la búsqueda para encontrar coincidencias en el título.
     * </p>
     *
     * @param query Cadena de texto con el nombre o parte del nombre del videojuego.
     * @return Lista de videojuegos que coinciden con el criterio de búsqueda.
     */
    List<Videojuego> buscarPorNombre(String query);

    /**
     * Busca un videojuego específico por su identificador.
     *
     * @param id Identificador único del videojuego.
     * @return Un {@link Optional} que contiene el videojuego si existe.
     */
    Optional<Videojuego> buscarPorId(Long id);

    /**
     * Registra un nuevo videojuego o actualiza los datos de uno existente.
     *
     * @param videojuego La entidad videojuego con la información a persistir.
     */
    void guardar(Videojuego videojuego);

    /**
     * Elimina un videojuego del sistema de forma permanente.
     *
     * @param id Identificador del videojuego a eliminar.
     */
    void eliminar(Long id);
}