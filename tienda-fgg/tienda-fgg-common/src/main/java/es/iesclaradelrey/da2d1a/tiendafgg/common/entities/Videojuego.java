package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Videojuego {
    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private Long categoriaId;

    @Builder.Default
    private String imagen = "no-image.jpg";
}