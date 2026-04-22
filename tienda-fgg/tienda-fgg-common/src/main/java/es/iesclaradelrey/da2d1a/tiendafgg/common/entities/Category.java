package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
}