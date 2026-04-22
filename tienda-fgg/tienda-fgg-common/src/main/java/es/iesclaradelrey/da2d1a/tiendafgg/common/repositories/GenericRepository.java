package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, K> {
    List<T> obtenerTodos();
    Optional<T> buscarPorId(K id);
    void guardar(T entidad);
}