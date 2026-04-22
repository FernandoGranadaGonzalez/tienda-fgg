package es.iesclaradelrey.da2d1a.tiendafgg.services;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Game;
import java.util.List;

public interface GameService {
    List<Game> obtenerJuegosDeCategoria(Long categoriaId);
}