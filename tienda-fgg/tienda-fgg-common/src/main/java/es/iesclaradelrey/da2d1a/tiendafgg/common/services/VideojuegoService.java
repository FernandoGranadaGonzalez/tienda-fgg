package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión y consulta de {@link Videojuego}.
 * <p>
 * Esta capa de servicio abstrae los detalles de la búsqueda y el filtrado del catálogo,
 * permitiendo que las capas superiores (controladores) interactúen con la lógica
 * de la aplicación sin conocer los detalles de la persistencia subyacente.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
public interface VideojuegoService {

    /**
     * Obtiene el listado de videojuegos asociados a una categoría específica.
     * * @param categoriaId El identificador único de la categoría a consultar.
     * @return Una {@link List} de {@link Videojuego} que pertenecen a la categoría indicada.
     */
    List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId);

    /**
     * Realiza una búsqueda de videojuegos mediante un criterio de texto.
     * <p>
     * Este método filtra los videojuegos cuyo título coincida total o parcialmente
     * con la consulta proporcionada.
     * </p>
     * * @param query La cadena de texto utilizada para la búsqueda.
     * @return Una {@link List} de {@link Videojuego} que coinciden con el criterio.
     */
    List<Videojuego> buscarPorNombre(String query);
}