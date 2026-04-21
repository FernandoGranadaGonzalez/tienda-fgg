package es.iesclaradelrey.da2d1a.tiendafgg.repositories.impl;

import es.iesclaradelrey.da2d1a.tiendafgg.entities.Game;
import es.iesclaradelrey.da2d1a.tiendafgg.repositories.GenericRepository;
import net.datafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class GameRepositoryImpl {

    private final List<Game> listaJuegos = new ArrayList<>();

    public GameRepositoryImpl() {
        Faker faker = new Faker(new Locale("es"));

        for (int i = 1; i <= 20; i++) {
            listaJuegos.add(Game.builder()
                    .id((long) i)
                    .titulo(faker.videoGame().title())
                    .descripcion("Un increíble juego de " + faker.videoGame().genre())
                    .precio(faker.number().randomDouble(2, 10, 70))
                    .categoriaId((long) faker.number().numberBetween(1, 5))
                    .build());
        }
    }

    public List<Game> obtenerTodos() {
        return new ArrayList<>(listaJuegos);
    }

    public List<Game> buscarPorCategoria(Long categoriaId) {
        return listaJuegos.stream()
                .filter(j -> j.getCategoriaId().equals(categoriaId))
                .toList();
    }
}