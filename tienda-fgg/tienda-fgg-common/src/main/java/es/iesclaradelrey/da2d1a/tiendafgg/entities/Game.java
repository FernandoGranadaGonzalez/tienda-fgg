package es.iesclaradelrey.da2d1a.tiendafgg.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private Long categoriaId;
}