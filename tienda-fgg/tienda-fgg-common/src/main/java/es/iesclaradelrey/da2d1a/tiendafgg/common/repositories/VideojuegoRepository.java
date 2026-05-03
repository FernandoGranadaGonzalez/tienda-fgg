package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Videojuego}.
 * <p>
 * Proporciona métodos para realizar consultas avanzadas sobre el catálogo de juegos,
 * incluyendo filtros por categorías y búsquedas textuales por título.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

    /**
     * Recupera una lista de videojuegos que pertenecen a una categoría específica.
     * <p>
     * Este método realiza un "join" implícito con la tabla de categorías.
     * El uso del guion bajo ({@code _}) en el nombre del método ayuda a Spring
     * a interpretar que debe navegar desde la entidad {@code Videojuego}
     * hacia la propiedad {@code id} de su lista de {@code categorias}.
     * </p>
     *
     * @param categoriaId Identificador único de la categoría.
     * @return Lista de videojuegos asociados a dicha categoría.
     */
    List<Videojuego> findByCategorias_Id(Long categoriaId);

    /**
     * Realiza una búsqueda de videojuegos cuyo título contenga una cadena de texto.
     * <p>
     * La búsqueda es insensible a mayúsculas y minúsculas ({@code IgnoreCase})
     * y busca coincidencias parciales en cualquier posición del título ({@code Containing}).
     * </p>
     *
     * @param query Cadena de texto a buscar en los títulos.
     * @return Lista de videojuegos que cumplen con el criterio de búsqueda.
     */
    List<Videojuego> findByTituloContainingIgnoreCase(String query);
}