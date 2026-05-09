package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO de transición para la importación masiva desde XML.
 * <p>
 * Actúa como un contenedor temporal (Buffer) durante el procesamiento con SAX.
 * Permite almacenar tanto los identificadores como los nombres de marcas y categorías
 * para que el servicio de importación pueda decidir si asociar elementos existentes
 * o crear nuevos registros.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class XmlProductoDto {
    /** Código EAN extraído del atributo o etiqueta XML. */
    private String  ean;

    /** Título del videojuego. */
    private String  titulo;

    /** Descripción detallada del producto. */
    private String  descripcion;

    /** Precio base sin procesar. */
    private Double  precio;

    /** Porcentaje de descuento. */
    private Integer descuento;

    /** Nivel de existencias inicial para la importación. */
    private Integer stock;

    /** Nombre del fichero o URL de la imagen. */
    private String  imagen;

    // --- Datos de Relación (Desnormalizados para el parseo) ---

    /** ID sugerido de la marca (opcional en el XML). */
    private Long    marcaId;

    /** Nombre de la marca para búsqueda por texto. */
    private String  marcaNombre;

    /**
     * Lista de IDs de categorías asociadas.
     * Inicializada para evitar NullPointerException durante el parseo.
     */
    private List<Long>   categoriaIds     = new ArrayList<>();

    /** Lista de nombres de categorías para creación dinámica. */
    private List<String> categoriaNombres = new ArrayList<>();
}