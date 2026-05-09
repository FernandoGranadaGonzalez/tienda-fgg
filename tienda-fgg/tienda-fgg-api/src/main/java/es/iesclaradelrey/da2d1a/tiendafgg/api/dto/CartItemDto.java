package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO que representa una línea detallada del carrito de la compra.
 * <p>
 * Proporciona al cliente toda la información visual y económica de un producto
 * específico dentro del carrito, incluyendo el desglose de precios y descuentos
 * ya calculados en el servidor.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class CartItemDto {
    /**
     * Título comercial del videojuego.
     */
    private String  titulo;

    /**
     * Precio original de venta por unidad (PVP).
     */
    private Double  precioUnitario;

    /**
     * Porcentaje de descuento aplicado (0-100).
     */
    private Integer descuento;

    /**
     * Precio por unidad tras aplicar el descuento.
     * <p>
     * Fórmula: {@code precioUnitario * (1 - descuento/100)}
     * </p>
     */
    private Double  precioConDescuento;

    /**
     * Cantidad de ejemplares de este producto en el carrito.
     */
    private Integer unidades;

    /**
     * Importe total de la línea (subtotal).
     * <p>
     * Fórmula: {@code precioConDescuento * unidades}
     * </p>
     */
    private Double  precioTotal;
}