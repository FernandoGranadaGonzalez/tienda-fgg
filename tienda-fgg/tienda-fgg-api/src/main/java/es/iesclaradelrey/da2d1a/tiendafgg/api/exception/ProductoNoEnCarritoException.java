package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de negocio para inconsistencias en la gestión del carrito.
 * <p>
 * Se dispara cuando se solicita una operación de actualización o borrado
 * sobre un producto que no existe en la sesión actual del carrito del usuario.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class ProductoNoEnCarritoException extends RuntimeException {

    /**
     * Construye la excepción indicando qué producto ha causado el conflicto.
     *
     * @param productoId ID del producto que se intentó manipular erróneamente.
     */
    public ProductoNoEnCarritoException(Long productoId) {
        super("El producto con id " + productoId + " no está en el carrito.");
    }
}