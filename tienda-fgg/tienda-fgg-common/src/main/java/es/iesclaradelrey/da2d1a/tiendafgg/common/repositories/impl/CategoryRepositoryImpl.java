package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category, Long> implements CategoryRepository {

    public CategoryRepositoryImpl() {
        this.guardar(new Category(1L, "Aventura", "Explora mundos épicos", "aventura.jpg"));
        this.guardar(new Category(2L, "Shooter", "Acción frenética en primera persona", "shooter.png"));
        this.guardar(new Category(3L, "Estrategia", "Planifica tu victoria", "estrategia.png"));
        this.guardar(new Category(4L, "RPG", "Juegos de rol y fantasía", null));
    }

    @Override
    public void guardar(Category categoria) {
        entidades.put(categoria.getId(), categoria);
    }

    @Override
    public List<Category> obtenerTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return Optional.ofNullable(entidades.get(id));
    }
}