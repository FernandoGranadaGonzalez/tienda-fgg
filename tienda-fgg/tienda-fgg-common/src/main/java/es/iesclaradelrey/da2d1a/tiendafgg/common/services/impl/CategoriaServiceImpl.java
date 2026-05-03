package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de la interfaz {@link CategoriaService}.
 * <p>
 * Esta clase gestiona la lógica de negocio relacionada con las categorías de la tienda.
 * Se encarga de coordinar las llamadas al repositorio {@link CategoriaRepository}
 * para realizar operaciones de lectura y escritura.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    /**
     * Repositorio de categorías inyectado mediante constructor.
     * Se marca como {@code final} para asegurar la inmutabilidad y fomentar la inyección de dependencias.
     */
    private final CategoriaRepository categoryRepository;

    /**
     * Constructor para la inyección de dependencias.
     * Spring detecta automáticamente este constructor para suministrar el repositorio necesario.
     *
     * @param categoriaRepository Repositorio de categorías a utilizar.
     */
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoryRepository = categoriaRepository;
    }

    /**
     * Recupera todas las categorías registradas en el sistema.
     *
     * @return Una lista con todas las instancias de {@link Categoria}.
     */
    @Override
    public List<Categoria> obtenerTodos() {
        return categoryRepository.findAll();
    }

    /**
     * Busca una categoría específica mediante su identificador único.
     *
     * @param id El identificador de la categoría.
     * @return Un {@link Optional} que contiene la categoría si se encuentra, o vacío si no.
     */
    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Persiste una nueva categoría o actualiza una existente en la base de datos.
     *
     * @param categoria Objeto categoría con los datos a guardar.
     */
    @Override
    public void guardar(Categoria categoria) {
        categoryRepository.save(categoria);
    }

    /**
     * Elimina una categoría del sistema basándose en su ID.
     *
     * @param id El identificador de la categoría a borrar.
     */
    @Override
    public void eliminar(Long id) {
        categoryRepository.deleteById(id);
    }
}