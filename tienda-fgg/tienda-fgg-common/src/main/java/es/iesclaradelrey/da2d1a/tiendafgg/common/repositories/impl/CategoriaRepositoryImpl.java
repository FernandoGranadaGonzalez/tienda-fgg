package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryImpl extends GenericoRepositoryImpl<Categoria, Long> implements CategoriaRepository {

    public CategoriaRepositoryImpl() {
        this.guardar(new Categoria(1L, "Aventura", "Explora mundos épicos", "aventura.jpg"));
        this.guardar(new Categoria(2L, "Shooter", "Acción frenética en primera persona", "shooter.png"));
        this.guardar(new Categoria(3L, "Estrategia", "Planifica tu victoria", "estrategia.png"));
        this.guardar(new Categoria(4L, "RPG", "Juegos de rol y fantasía", null));
    }

    @Override
    public void guardar(Categoria categoria) {
        entidades.put(categoria.getId(), categoria);
    }

    @Override
    public List<Categoria> obtenerTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return Optional.ofNullable(entidades.get(id));
    }
}