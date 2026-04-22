package es.iesclaradelrey.da2d1a.tiendafgg.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {

    List<T> obtenerTodos();

    Optional<T> buscarPorId(ID id);
}