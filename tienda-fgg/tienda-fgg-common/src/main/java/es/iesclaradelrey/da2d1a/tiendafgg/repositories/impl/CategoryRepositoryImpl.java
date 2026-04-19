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
                .nombreImagen("https://img.icons8.com/papercut/1200/adventure.jpg")
                .build());

        listaCategorias.add(Category.builder()
                .id(2L)
                .nombre("Shooter")
                .descripcion("Juegos de disparos")
                .nombreImagen("https://cdn-icons-png.flaticon.com/512/1620/1620460.png")
                .build());

        listaCategorias.add(Category.builder()
                .id(3L)
                .nombre("Estrategia")
                .descripcion("Juegos de estrategia")
                .nombreImagen("https://cdn-icons-png.flaticon.com/512/9968/9968200.png")
                .build());

        listaCategorias.add(Category.builder()
                .id(4L)
                .nombre("RPG")
                .descripcion("Juegos de rol por turnos.")
                .nombreImagen("https://cdn-icons-png.flaticon.com/512/2619/2619285.png")
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