package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.MarcaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> obtenerTodos() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> buscarPorId(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public void guardar(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public void eliminar(Long id) {
        marcaRepository.deleteById(id);
    }
}