package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de negocio lanzada cuando un Videojuego solicitado no existe.
 * <p>
 * Es la excepción más común en la API de catálogo y se utiliza en:
 * <ul>
 *     <li>Consulta de detalle de producto por ID.</li>
 *     <li>Validación previa antes de añadir un ítem al carrito.</li>
 *     <li>Procesos de actualización o borrado de productos desde el panel de administración.</li>
 * </ul>
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class ProductoNotFoundException extends RuntimeException {

    /** ID del producto que no se ha encontrado. */
    private final Long productoId;

    /**
     * Construye la excepción con el ID específico para facilitar la auditoría.
     *
     * @param productoId Identificador del producto inexistente.
     */
    public ProductoNotFoundException(Long productoId) {
        super("Producto no encontrado con id: " + productoId);
        this.productoId = productoId;
    }

    /**
     * @return El ID del producto que falló, útil para logs de servidor.
     */
    public Long getProductoId() { return productoId; }
}