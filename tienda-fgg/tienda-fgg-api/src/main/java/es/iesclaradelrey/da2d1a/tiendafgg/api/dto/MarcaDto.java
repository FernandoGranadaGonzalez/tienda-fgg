package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO para la representación de marcas o fabricantes en la API.
 * <p>
 * Se utiliza para mostrar la información básica del fabricante asociado
 * a un videojuego, facilitando el filtrado y la visualización en el frontend.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class MarcaDto {
    /**
     * Identificador único de la marca.
     */
    private Long   id;

    /**
     * Nombre comercial de la marca (ej: "Nintendo", "Sony", "Microsoft").
     */
    private String nombre;
}