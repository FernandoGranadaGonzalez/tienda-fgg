package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción técnica lanzada durante el proceso de importación masiva de datos.
 * <p>
 * Actúa como un envoltorio (wrapper) para errores relacionados con:
 * <ul>
 *     <li>Ficheros XML mal formados o corruptos.</li>
 *     <li>Violaciones de esquema o etiquetas inesperadas durante el parseo SAX.</li>
 *     <li>Errores de E/S (I/O) al acceder al recurso XML.</li>
 * </ul>
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class XmlImportException extends RuntimeException {

    /**
     * Construye la excepción con un mensaje descriptivo personalizado.
     *
     * @param message Detalle del error ocurrido durante la importación.
     */
    public XmlImportException(String message) {
        super(message);
    }

    /**
     * Construye la excepción encadenando la causa original del fallo.
     * <p>
     * Fundamental para capturar y no perder la traza de {@code SAXException}
     * o {@code IOException} producidas por librerías externas.
     * </p>
     *
     * @param message Mensaje de contexto de la aplicación.
     * @param cause El error original (Throwable) que provocó el fallo.
     */
    public XmlImportException(String message, Throwable cause) {
        super(message, cause);
    }
}