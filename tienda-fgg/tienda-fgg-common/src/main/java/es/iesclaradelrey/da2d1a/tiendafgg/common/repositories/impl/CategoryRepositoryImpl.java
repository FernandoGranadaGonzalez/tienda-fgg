package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.common.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category, Long> implements CategoryRepository {

    @Override
    public void guardar(Category categoria) {
        entidades.put(categoria.getId(), categoria);
    }
}