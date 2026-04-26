package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;

public interface VideojuegoService {
    List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId);
    List<Videojuego> buscarPorNombre(String query);
}