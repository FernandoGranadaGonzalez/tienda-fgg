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
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    private List<Videojuego> videojuegos = new ArrayList<>();

    @Column(length = 2000)
    private String descripcion;

    @Builder.Default
    @Column(length = 500)
    private String imagen = "no-image.png";

    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = "no-image.png";
    }
}