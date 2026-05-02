package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> obtenerTodos();

    Optional<Marca> buscarPorId(Long id);

    void guardar(Marca marca);

    void eliminar(Long id);
}