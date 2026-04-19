package es.iesclaradelrey.da2d1a.tiendafgg.services;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> obtenerTodas();
    Optional<Category> buscarPorId(Long id);
}