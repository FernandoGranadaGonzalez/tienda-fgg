package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de negocio lanzada cuando una operación requiere una Marca inexistente.
 * <p>
 * Es fundamental durante los procesos de:
 * <ul>
 *     <li>Filtrado de productos por fabricante.</li>
 *     <li>Actualización de videojuegos (cambio de marca).</li>
 *     <li>Importación de datos donde se referencia un ID de marca huérfano.</li>
 * </ul>
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class MarcaNotFoundException extends RuntimeException {

    /** Identificador de la marca que originó el error. */
    private final Long marcaId;

    /**
     * Crea la excepción almacenando el ID para depuración.
     *
     * @param marcaId Identificador que no ha podido ser localizado.
     */
    public MarcaNotFoundException(Long marcaId) {
        super("Marca no encontrada con id: " + marcaId);
        this.marcaId = marcaId;
    }

    /**
     * @return El ID de la marca para que el Handler pueda registrarlo en los logs.
     */
    public Long getMarcaId() {
        return marcaId;
    }
}