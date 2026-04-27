package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad {@link Videojuego}.
 * <p>
 * Proporciona métodos especializados para la búsqueda y filtrado de videojuegos dentro
 * del catálogo, permitiendo consultar por categorías o mediante búsquedas de texto libre
 * sobre los títulos.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
public interface VideojuegoRepository {

    /**
     * Recupera el listado completo de videojuegos disponibles en la tienda.
     * * @return Una {@link List} conteniendo todos los objetos {@link Videojuego}.
     */
    List<Videojuego> obtenerTodos();

    /**
     * Filtra los videojuegos que pertenecen a una categoría específica.
     * * @param categoriaId El identificador único de la categoría a consultar.
     * @return Una {@link List} de videojuegos asociados a la categoría dada.
     * Si no se encuentran resultados, devuelve una lista vacía.
     */
    List<Videojuego> buscarPorCategoria(Long categoriaId);

    /**
     * Realiza una búsqueda de videojuegos cuyo título coincida total o parcialmente
     * con la cadena de texto proporcionada.
     * <p>
     * La implementación debe ser insensible a mayúsculas y minúsculas (case-insensitive).
     * </p>
     * * @param query La cadena de texto a buscar en los títulos de los juegos.
     * @return Una {@link List} de videojuegos que cumplen el criterio de búsqueda.
     */
    List<Videojuego> buscarPorNombre(String query);
}