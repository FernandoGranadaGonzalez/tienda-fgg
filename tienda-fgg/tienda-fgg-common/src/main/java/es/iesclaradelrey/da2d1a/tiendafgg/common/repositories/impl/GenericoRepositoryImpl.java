package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.GenericoRepository;
import java.util.*;

public abstract class GenericoRepositoryImpl<T, K> implements GenericoRepository<T, K> {
    protected Map<K, T> entidades = new HashMap<>();

    @Override
    public List<T> obtenerTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable(entidades.get(id));
    }
}