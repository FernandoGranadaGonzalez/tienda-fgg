package es.iesclaradelrey.da2d1a.tiendafgg.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.repositories.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final List<Category> listaCategorias = new ArrayList<>();

    public CategoryRepositoryImpl() {
        listaCategorias.add(Category.builder()
                .id(1L)
                .nombre("Aventura")
                .descripcion("Juegos de aventuras")
                .nombreImagen("aventura.jpg")
                .build());

        listaCategorias.add(Category.builder()
                .id(2L)
                .nombre("Shooter")
                .descripcion("Juegos de disparos")
                .nombreImagen("shooter.png")
                .build());

        listaCategorias.add(Category.builder()
                .id(3L)
                .nombre("Estrategia")
                .descripcion("Juegos de estrategia")
                .nombreImagen("estrategia.png")
                .build());

        listaCategorias.add(Category.builder()
                .id(4L)
                .nombre("RPG")
                .descripcion("Juegos de rol por turnos.")
                .nombreImagen("rpg.png")
                .build());
    }

    @Override
    public List<Category> obtenerTodos() {
        return new ArrayList<>(listaCategorias);
    }

    @Override
    public Optional<Category> buscarPorId(Long id) {
        return listaCategorias.stream()
                .filter(cat -> cat.getId().equals(id))
                .findFirst();
    }
}