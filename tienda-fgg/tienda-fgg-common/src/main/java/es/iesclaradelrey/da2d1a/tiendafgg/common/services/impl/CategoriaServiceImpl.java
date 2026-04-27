package es.iesclaradelrey.da2d1a.tiendafgg.common.services.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de la capa de servicio para la gestión de categorías.
 * <p>
 * Esta clase contiene la lógica de negocio y actúa como puente entre la capa de
 * presentación (controladores) y la capa de persistencia (repositorios).
 * Al estar anotada con {@code @Service}, Spring la registra como un componente
 * de negocio gestionado.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    /**
     * Repositorio de categorías inyectado mediante constructor.
     * Es de tipo {@code final} para asegurar la inmutabilidad y fomentar
     * buenas prácticas de inyección de dependencias.
     */
    private final CategoriaRepository categoryRepository;

    /**
     * Constructor para la inyección de dependencias de Spring.
     * <p>
     * Al utilizar inyección por constructor en lugar de {@code @Autowired} en el campo,
     * facilitamos las pruebas unitarias y garantizamos que el servicio siempre tenga
     * un repositorio válido.
     * </p>
     * * @param categoriaRepository La implementación del repositorio a inyectar.
     */
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoryRepository = categoriaRepository;
    }

    /**
     * Recupera todas las categorías registradas en el sistema.
     * * @return Una lista con todas las {@link Categoria} existentes.
     */
    @Override
    public List<Categoria> obtenerTodos() {
        return categoryRepository.obtenerTodos();
    }

    /**
     * Busca una categoría por su identificador único.
     * * @param id El identificador de la categoría.
     * @return Un {@link Optional} que puede contener la categoría si existe.
     */
    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoryRepository.buscarPorId(id);
    }

    /**
     * Persiste una nueva categoría o actualiza una existente.
     * * @param categoria El objeto categoría a guardar.
     */
    @Override
    public void guardar(Categoria categoria) {
        categoryRepository.guardar(categoria);
    }
}