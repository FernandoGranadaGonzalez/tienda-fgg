package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato para los servicios de gestión de {@link Categoria}.
 * <p>
 * Define las operaciones de negocio permitidas para las categorías, abstrayendo
 * la implementación concreta de la persistencia o la lógica interna.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface CategoriaService {

    /**
     * Obtiene una lista con todas las categorías disponibles en el sistema.
     *
     * @return Lista de objetos {@link Categoria}.
     */
    List<Categoria> obtenerTodos();

    /**
     * Busca una categoría por su identificador único.
     *
     * @param id Identificador de la categoría.
     * @return Un {@link Optional} que contiene la categoría si se encuentra, o vacío en caso contrario.
     */
    Optional<Categoria> buscarPorId(Long id);

    /**
     * Guarda una categoría en el sistema.
     * Si la categoría ya existe (tiene un ID conocido), actualiza sus datos;
     * de lo contrario, crea una nueva entrada.
     *
     * @param categoria La entidad categoría a procesar.
     */
    void guardar(Categoria categoria);

    /**
     * Elimina del sistema la categoría asociada al identificador proporcionado.
     *
     * @param id Identificador de la categoría a eliminar.
     */
    void eliminar(Long id);
}