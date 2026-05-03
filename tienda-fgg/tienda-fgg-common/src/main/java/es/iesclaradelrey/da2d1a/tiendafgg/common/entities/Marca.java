package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Videojuego> videojuegos = new ArrayList<>();

    public Marca(String nombre) {
        this.nombre = nombre;
    }
}