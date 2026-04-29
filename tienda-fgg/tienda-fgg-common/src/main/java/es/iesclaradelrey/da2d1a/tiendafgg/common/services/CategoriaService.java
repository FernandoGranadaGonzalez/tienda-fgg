package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> obtenerTodos();

    Optional<Categoria> buscarPorId(Long id);

    void guardar(Categoria categoria);
}