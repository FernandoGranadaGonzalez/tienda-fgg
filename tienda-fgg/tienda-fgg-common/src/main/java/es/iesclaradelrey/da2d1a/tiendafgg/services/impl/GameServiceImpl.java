package es.iesclaradelrey.da2d1a.tiendafgg.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Game;
import es.iesclaradelrey.da2d1a.tiendafgg.repositories.GameRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.services.GameService;
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
}