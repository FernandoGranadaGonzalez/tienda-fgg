package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.VideojuegoRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de los servicios de negocio para la entidad {@link Videojuego}.
 * <p>
 * Esta clase centraliza las operaciones del catálogo, permitiendo no solo el CRUD
 * básico, sino también la filtración avanzada por categorías y términos de búsqueda.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    /**
     * Repositorio de videojuegos inyectado para el acceso a datos.
     */
    private final VideojuegoRepository videojuegoRepository;

    /**
     * Constructor para la inyección de dependencias de Spring.
     *
     * @param videojuegoRepository Repositorio que gestiona la persistencia de videojuegos.
     */
    public VideojuegoServiceImpl(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    /**
     * Obtiene la lista completa de videojuegos registrados.
     *
     * @return Lista con todos los objetos {@link Videojuego}.
     */
    @Override
    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    /**
     * Localiza un videojuego por su identificador único.
     *
     * @param id Identificador del juego.
     * @return Un {@link Optional} que contiene el juego si se encuentra.
     */
    @Override
    public Optional<Videojuego> buscarPorId(Long id) {
        return videojuegoRepository.findById(id);
    }

    /**
     * Guarda un nuevo videojuego o actualiza la información de uno existente.
     *
     * @param videojuego Entidad a persistir.
     */
    @Override
    public void guardar(Videojuego videojuego) {
        videojuegoRepository.save(videojuego);
    }

    /**
     * Recupera todos los videojuegos asociados a una categoría específica.
     *
     * @param categoriaId Identificador de la categoría por la que filtrar.
     * @return Lista de videojuegos que pertenecen a dicha categoría.
     */
    @Override
    public List<Videojuego> obtenerJuegosDeCategoria(Long categoriaId) {
        return videojuegoRepository.findByCategorias_Id(categoriaId);
    }

    /**
     * Busca videojuegos cuyo título coincida parcial o totalmente con el texto indicado.
     * <p>
     * La búsqueda es insensible a mayúsculas y minúsculas.
     * </p>
     *
     * @param query Texto de búsqueda (nombre o parte del nombre).
     * @return Lista de videojuegos que encajan con el criterio.
     */
    @Override
    public List<Videojuego> buscarPorNombre(String query) {
        return videojuegoRepository.findByTituloContainingIgnoreCase(query);
    }

    /**
     * Elimina un videojuego del catálogo mediante su ID.
     *
     * @param id Identificador del videojuego a borrar.
     */
    @Override
    public void eliminar(Long id) {
        videojuegoRepository.deleteById(id);
    }
}