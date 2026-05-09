package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.Data;

/**
 * DTO para la solicitud de adición de productos al carrito.
 * <p>
 * Representa la carga útil (payload) que el cliente debe enviar al endpoint
 * POST /api/v1/cart. Contiene la información mínima necesaria para
 * identificar el producto y la cantidad deseada.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
public class AddToCartRequestDto {
    /**
     * Identificador único del videojuego en la base de datos.
     */
    private Long    productoId;

    /**
     * Cantidad de unidades que el usuario desea añadir o actualizar.
     * Debe ser un número entero positivo.
     */
    private Integer unidades;
}