package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO (Data Transfer Object) para la exposición de categorías en la API REST.
 * <p>
 * Esta clase actúa como una vista plana de la entidad Categoria, diseñada
 * para optimizar las respuestas de catálogo donde solo se requiere la
 * información básica de la sección sin cargar los productos asociados.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class CategoriaDto {
    /**
     * Identificador único de la categoría.
     */
    private Long   id;

    /**
     * Nombre descriptivo (ej: "RPG", "Aventura", "Deportes").
     */
    private String nombre;

    /**
     * Breve explicación de qué tipo de juegos contiene esta categoría.
     */
    private String descripcion;

    /**
     * Ruta o URL de la imagen representativa de la categoría.
     */
    private String imagen;
}