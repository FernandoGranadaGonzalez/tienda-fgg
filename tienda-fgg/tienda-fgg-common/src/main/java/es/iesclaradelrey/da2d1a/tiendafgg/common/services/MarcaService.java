package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones de negocio para la gestión de {@link Marca}.
 * <p>
 * Proporciona una capa de abstracción sobre la persistencia de marcas,
 * permitiendo listar, buscar, crear, actualizar y eliminar fabricantes
 * dentro del sistema.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface MarcaService {

    /**
     * Recupera el listado completo de marcas almacenadas.
     *
     * @return Una {@link List} que contiene todas las instancias de {@link Marca}.
     */
    List<Marca> obtenerTodos();

    /**
     * Busca una marca específica utilizando su identificador único.
     *
     * @param id El identificador de la marca deseada.
     * @return Un {@link Optional} que envuelve la {@link Marca} si se encuentra,
     *         o un opcional vacío si no existe.
     */
    Optional<Marca> buscarPorId(Long id);

    /**
     * Registra una marca en el sistema o actualiza una ya existente.
     *
     * @param marca La entidad con los datos de la marca a persistir.
     */
    void guardar(Marca marca);

    /**
     * Elimina de la base de datos la marca identificada por el ID proporcionado.
     *
     * @param id El identificador de la marca que se desea suprimir.
     */
    void eliminar(Long id);
}