package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends GenericRepository<Category, Long> {
    List<Category> obtenerTodos();
    Optional<Category> buscarPorId(Long id);
}