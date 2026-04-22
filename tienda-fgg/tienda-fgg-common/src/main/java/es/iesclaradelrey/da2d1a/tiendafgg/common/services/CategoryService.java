package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> obtenerTodos();

    Optional<Category> buscarPorId(Long id);

    void guardar(Category categoria);
}