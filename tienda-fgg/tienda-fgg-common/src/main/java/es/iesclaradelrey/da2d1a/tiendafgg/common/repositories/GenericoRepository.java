package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz base para operaciones CRUD (Create, Read, Update, Delete) genéricas.
 * <p>
 * Define el contrato estándar para cualquier repositorio del sistema, permitiendo
 * gestionar entidades de tipo {@code T} identificadas por claves de tipo {@code K}.
 * Esto promueve la reutilización de código y la coherencia en la capa de persistencia.
 * </p>
 * * @param <T> El tipo de la entidad que gestiona el repositorio.
 * @param <K> El tipo del identificador único (ID) de la entidad.
 * @author TuNombre
 * @version 1.0
 */
public interface GenericoRepository<T, K> {

    /**
     * Recupera todos los elementos almacenados en el repositorio.
     * * @return Una {@link List} con todas las entidades. Si no existen registros,
     * se devuelve una lista vacía.
     */
    List<T> obtenerTodos();

    /**
     * Busca una entidad por su identificador único.
     * * @param id La clave identificadora de tipo {@code K}.
     * @return Un {@link Optional} conteniendo la entidad si existe, o
     * {@link Optional#empty()} en caso contrario.
     */
    Optional<T> buscarPorId(K id);

    /**
     * Persiste una entidad en el repositorio.
     * <p>
     * Dependiendo de la implementación, este método puede crear un nuevo registro
     * o actualizar uno existente basado en su identificador.
     * </p>
     * * @param entidad El objeto de tipo {@code T} a persistir.
     */
    void guardar(T entidad);
}