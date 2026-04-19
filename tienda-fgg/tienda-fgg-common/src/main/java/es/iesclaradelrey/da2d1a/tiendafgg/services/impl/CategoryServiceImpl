package es.iesclaradelrey.da2d1a.tiendafgg.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.repositories.CategoryRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repositorioCategorias;
    
    public CategoryServiceImpl(CategoryRepository repositorioCategorias) {
        this.repositorioCategorias = repositorioCategorias;
    }

    @Override
    public List<Category> obtenerTodas() {
        return repositorioCategorias.obtenerTodos();
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return repositorioCategorias.buscarPorId(id);
    }
}