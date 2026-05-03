package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la gestión de persistencia de la entidad {@link Categoria}.
 * <p>
 * Al extender de {@link JpaRepository}, esta interfaz hereda automáticamente
 * todos los métodos CRUD básicos (save, findAll, delete, etc.) y la capacidad
 * de paginación y ordenación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     * Busca categorías cuyo nombre coincida exactamente con la cadena proporcionada.
     * <p>
     * Este método utiliza "Query Creation" de Spring Data JPA, donde la consulta
     * SQL se genera automáticamente a partir del nombre del método.
     * </p>
     *
     * @param query El nombre de la categoría a buscar.
     * @return Una lista de {@link Categoria} que coinciden con el nombre buscado.
     */
    List<Categoria> findByNombre(String query);
}