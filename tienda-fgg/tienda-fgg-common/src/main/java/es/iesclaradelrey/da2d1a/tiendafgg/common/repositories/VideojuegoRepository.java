package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la gestión de persistencia de la entidad Videojuego.
 * <p>
 * Implementa capacidades de filtrado dinámico y búsqueda textual. Al extender
 * JpaRepository, hereda automáticamente operaciones de paginación y ordenación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

    /**
     * Filtra el catálogo por identificador de categoría.
     * <p>
     * Utiliza la navegación de propiedades de Spring Data para realizar un join
     * con la tabla intermedia de categorías.
     * </p>
     *
     * @param categoriaId ID de la categoría (ej: 1 para "RPG").
     * @return Colección de videojuegos pertenecientes a la categoría.
     */
    List<Videojuego> findByCategorias_Id(Long categoriaId);

    /**
     * Buscador textual para el catálogo.
     * <p>
     * Implementa una búsqueda flexible mediante el operador SQL 'LIKE %query%'
     * ignorando la distinción entre mayúsculas y minúsculas.
     * </p>
     *
     * @param query Término de búsqueda proporcionado por el usuario.
     * @return Lista de coincidencias encontradas en el título.
     */
    List<Videojuego> findByTituloContainingIgnoreCase(String query);

    /**
     * Recupera videojuegos por categoría permitiendo ordenación dinámica.
     * <p>
     * Ideal para funcionalidades como "Ordenar por precio ascendente/descendente"
     * dentro de una categoría específica.
     * </p>
     *
     * @param categoryId ID de la categoría.
     * @param sort Parámetros de ordenación (campo y dirección).
     * @return Lista ordenada de videojuegos.
     */
    List<Videojuego> findByCategoriasId(Long categoryId, Sort sort);
}