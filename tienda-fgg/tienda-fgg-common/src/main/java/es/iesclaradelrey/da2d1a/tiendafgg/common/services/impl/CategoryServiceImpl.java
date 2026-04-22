package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoryRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> obtenerTodos() {
        return categoryRepository.obtenerTodos();
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return categoryRepository.buscarPorId(id);
    }

    @Override
    public void guardar(Category categoria) {
        categoryRepository.guardar(categoria);
    }
}