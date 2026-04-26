package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    private final VideojuegoRepository repositorioJuegos;

    public VideojuegoServiceImpl(VideojuegoRepository repositorioJuegos) {
        this.repositorioJuegos = repositorioJuegos;
    }

    @Override
    public List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId) {
        return repositorioJuegos.buscarPorCategoria(categoriaId);
    }

    @Override
    public List<Videojuego> buscarPorNombre(String query) {
        return repositorioJuegos.buscarPorNombre(query);
    }
}