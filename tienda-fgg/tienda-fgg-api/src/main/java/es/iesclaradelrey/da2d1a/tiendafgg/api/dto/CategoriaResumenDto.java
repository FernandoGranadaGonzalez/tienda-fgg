package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO simplificado de categoría diseñado para ser embebido en otros objetos.
 * <p>
 * Su propósito es proporcionar la información mínima necesaria para identificar
 * y mostrar una categoría cuando esta actúa como metadato de un producto,
 * evitando la redundancia de datos en respuestas masivas.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class CategoriaResumenDto {
    /**
     * Identificador único de la categoría para permitir navegación (links).
     */
    private Long   id;

    /**
     * Nombre de la categoría para visualización en UI (etiquetas/badges).
     */
    private String nombre;
}