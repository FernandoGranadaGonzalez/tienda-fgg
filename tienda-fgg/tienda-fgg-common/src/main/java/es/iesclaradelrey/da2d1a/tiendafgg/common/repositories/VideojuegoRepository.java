package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;

public interface VideojuegoRepository {
    List<Videojuego> obtenerTodos();
    List<Videojuego> buscarPorCategoria(Long categoriaId);
    List<Videojuego> buscarPorNombre(String query);
}