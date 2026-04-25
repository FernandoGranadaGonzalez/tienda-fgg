package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Game;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.GameRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.GameService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repositorioJuegos;

    public GameServiceImpl(GameRepository repositorioJuegos) {
        this.repositorioJuegos = repositorioJuegos;
    }

    @Override
    public List<Game> obtenerJuegosDeCategoria(Long categoriaId) {
        return repositorioJuegos.buscarPorCategoria(categoriaId);
    }

    @Override
    public List<Game> buscarPorNombre(String query) {
        return repositorioJuegos.buscarPorNombre(query);
    }
}