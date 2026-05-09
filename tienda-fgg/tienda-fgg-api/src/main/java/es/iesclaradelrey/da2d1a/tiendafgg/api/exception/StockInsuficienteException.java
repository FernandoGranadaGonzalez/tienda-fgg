package es.iesclaradelrey.da2d1a.tiendafgg.api.exception;

/**
 * Excepción de regla de negocio lanzada durante el proceso de compra o gestión de carrito.
 * <p>
 * Se dispara cuando la cantidad de unidades solicitada por un cliente supera
 * el stock físico disponible en el almacén para un producto específico.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public class StockInsuficienteException extends RuntimeException {

    /**
     * Construye la excepción detallando la discrepancia de inventario.
     *
     * @param productoId Identificador del videojuego afectado.
     * @param disponible Cantidad actual en la base de datos.
     * @param solicitado Cantidad que el usuario intentó añadir al carrito.
     */
    public StockInsuficienteException(Long productoId, Integer disponible, Integer solicitado) {
        super(String.format(
                "Stock insuficiente para el producto %d. Disponible: %d, Solicitado: %d",
                productoId, disponible, solicitado));
    }
}