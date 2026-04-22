package es.iesclaradelrey.da2d1a.tiendafgg.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Game;
import java.util.List;

public interface GameRepository {
    List<Game> obtenerTodos();
    List<Game> buscarPorCategoria(Long categoriaId);
}