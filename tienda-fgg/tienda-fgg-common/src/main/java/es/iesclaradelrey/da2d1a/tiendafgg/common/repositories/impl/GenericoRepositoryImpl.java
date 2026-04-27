package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.GenericoRepository;
import java.util.*;

/**
 * Implementación base abstracta para repositorios que gestionan entidades en memoria.
 * <p>
 * Esta clase proporciona una infraestructura común utilizando un {@link HashMap} para
 * simular el almacenamiento de una base de datos. Al ser genérica, permite reutilizar
 * la lógica de acceso a datos para cualquier tipo de entidad.
 * </p>
 * * @param <T> El tipo de la entidad (ej. Categoria, Videojuego).
 * @param <K> El tipo del identificador único de la entidad (ej. Long, String).
 * * @author TuNombre
 * @version 1.0
 */
public abstract class GenericoRepositoryImpl<T, K> implements GenericoRepository<T, K> {

    /**
     * Mapa interno que actúa como almacenamiento persistente temporal.
     * <p>
     * Se declara como {@code protected} para que las clases hijas puedan acceder
     * directamente al mapa y realizar operaciones específicas (como el "seeding"
     * de datos en los constructores).
     * </p>
     */
    protected Map<K, T> entidades = new HashMap<>();

    /**
     * Recupera todas las entidades almacenadas en el repositorio.
     * <p>
     * Crea una nueva lista a partir de los valores del mapa para evitar que cambios
     * externos en la lista afecten a la estructura interna del repositorio.
     * </p>
     * * @return Una {@link List} con todas las entidades de tipo {@code T}.
     */
    @Override
    public List<T> obtenerTodos() {
        return new ArrayList<>(entidades.values());
    }

    /**
     * Busca una entidad por su clave primaria.
     * * @param id El identificador único de tipo {@code K}.
     * @return Un {@link Optional} que envuelve la entidad si existe, o vacío si no.
     */
    @Override
    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable(entidades.get(id));
    }
}