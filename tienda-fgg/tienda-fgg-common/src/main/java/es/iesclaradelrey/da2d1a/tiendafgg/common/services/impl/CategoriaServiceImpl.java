package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoryRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoryRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> obtenerTodos() {
        return categoryRepository.obtenerTodos();
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoryRepository.buscarPorId(id);
    }

    @Override
    public void guardar(Categoria categoria) {
        categoryRepository.guardar(categoria);
    }
}