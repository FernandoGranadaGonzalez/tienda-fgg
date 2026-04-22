package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Game;
import java.util.List;

public interface GameService {
    List<Game> obtenerJuegosDeCategoria(Long categoriaId);
}