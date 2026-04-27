package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación de la capa de servicio para la gestión de videojuegos.
 * <p>
 * Este servicio centraliza la lógica de acceso a los datos de videojuegos,
 * delegando las consultas específicas al {@link VideojuegoRepository}.
 * Actúa como intermediario para asegurar que el controlador no acceda directamente
 * a la capa de datos.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    /**
     * Instancia del repositorio de videojuegos inyectada por constructor.
     */
    private final VideojuegoRepository repositorioJuegos;

    /**
     * Constructor para la inyección de dependencias de Spring.
     *
     * @param repositorioJuegos El componente de persistencia de videojuegos.
     */
    public VideojuegoServiceImpl(VideojuegoRepository repositorioJuegos) {
        this.repositorioJuegos = repositorioJuegos;
    }

    /**
     * Recupera todos los videojuegos que pertenecen a una categoría determinada.
     *
     * @param categoriaId El identificador de la categoría a consultar.
     * @return Una lista de {@link Videojuego} asociados a la categoría.
     */
    @Override
    public List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId) {
        return repositorioJuegos.buscarPorCategoria(categoriaId);
    }

    /**
     * Realiza una búsqueda de videojuegos por título.
     *
     * @param query El término de búsqueda que debe coincidir con el título del juego.
     * @return Una lista de {@link Videojuego} cuyo título contiene el término de búsqueda.
     */
    @Override
    public List<Videojuego> buscarPorNombre(String query) {
        return repositorioJuegos.buscarPorNombre(query);
    }
}