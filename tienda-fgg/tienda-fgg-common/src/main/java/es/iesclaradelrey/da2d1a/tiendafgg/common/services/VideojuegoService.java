package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import java.util.List;
import java.util.Optional;

public interface VideojuegoService {

    List<Videojuego> obtenerTodos();

    List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId);

    List<Videojuego> buscarPorNombre(String query);

    Optional<Videojuego> buscarPorId(Long id);
}