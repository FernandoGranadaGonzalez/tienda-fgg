package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa un videojuego dentro del catálogo de la tienda.
 * <p>
 * Contiene la información comercial y técnica de cada título, incluyendo su
 * vinculación con una categoría específica mediante su identificador.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Videojuego {

    /**
     * Identificador único del videojuego en el sistema.
     */
    private Long id;

    /**
     * Título o nombre comercial del videojuego.
     */
    private String titulo;

    /**
     * Resumen o detalles del contenido del juego.
     */
    private String descripcion;

    /**
     * Precio de venta al público (PVP).
     */
    private Double precio;

    /**
     * Identificador de la categoría a la que pertenece este videojuego.
     * Actúa como clave foránea (FK) a nivel de lógica de negocio.
     */
    private Long categoriaId;

    /**
     * Nombre del archivo o URL de la carátula del videojuego.
     * <p>
     * Se inicializa por defecto con "no-image.jpg" si no se proporciona una.
     * La anotación {@code @Builder.Default} garantiza que este valor se mantenga
     * incluso si se instancia el objeto mediante el patrón Builder.
     * </p>
     */
    @Builder.Default
    private String imagen = "no-image.jpg";
}