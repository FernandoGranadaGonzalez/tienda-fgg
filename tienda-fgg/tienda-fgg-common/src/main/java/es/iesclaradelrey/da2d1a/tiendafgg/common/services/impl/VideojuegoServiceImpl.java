package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository; // Importación necesaria
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    private final VideojuegoRepository videojuegoRepository;

    public VideojuegoServiceImpl(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    @Override
    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    @Override
    public Optional<Videojuego> buscarPorId(Long id) {
        return videojuegoRepository.findById(id);
    }

    @Override
    public void guardar(Videojuego videojuego) {
        videojuegoRepository.save(videojuego);
    }

    @Override
    public List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId) {
        return videojuegoRepository.findByCategorias_Id(categoriaId);
    }

    @Override
    public List<Videojuego> buscarPorNombre(String query) {
        return videojuegoRepository.findByTituloContainingIgnoreCase(query);
    }

    @Override
    public void eliminar(Long id) {
        videojuegoRepository.deleteById(id);
    }
}