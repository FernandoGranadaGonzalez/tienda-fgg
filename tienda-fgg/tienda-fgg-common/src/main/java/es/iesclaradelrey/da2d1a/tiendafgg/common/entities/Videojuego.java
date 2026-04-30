package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13)
    private String codigoEan;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 50)
    private String marca;

    @Column(nullable = false, length = 4000)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer descuento;

    @Column(name = "categoria_id")
    private Long categoriaId;

    @Builder.Default
    @Column(length = 500)
    private String imagen = "no-image.jpg";
}