package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa una categoría de productos en el sistema.
 * <p>
 * Esta clase utiliza Lombok para reducir el código repetitivo, generando automáticamente
 * los métodos getter, setter, equals, hashCode y toString, así como los constructores
 * y el patrón Builder.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

    /**
     * Identificador único de la categoría en la base de datos.
     */
    private Long id;

    /**
     * Nombre de la categoría (ej. "Electrónica", "Ropa").
     */
    private String nombre;

    /**
     * Breve descripción de los productos que engloba esta categoría.
     */
    private String descripcion;

    /**
     * Ruta o URL de la imagen representativa de la categoría.
     */
    private String imagen;

    /**
     * Constructor especializado para crear una categoría sin especificar una imagen.
     * <p>
     * Se asigna automáticamente una imagen por defecto ("default-category.jpg")
     * para asegurar que la entidad siempre tenga un recurso visual básico.
     * </p>
     *
     * @param id          El identificador único.
     * @param nombre      El nombre de la categoría.
     * @param descripcion La descripción de la categoría.
     */
    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = "default-category.jpg";
    }
}