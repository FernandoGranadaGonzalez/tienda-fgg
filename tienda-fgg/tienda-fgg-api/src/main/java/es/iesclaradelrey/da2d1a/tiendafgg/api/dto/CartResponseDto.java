package es.iesclaradelrey.da2d1a.tiendafgg.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * DTO de respuesta global para el estado del carrito.
 * <p>
 * Centraliza la lista de productos detallados y los resúmenes estadísticos
 * y económicos calculados en el servidor para evitar discrepancias de datos.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
    /**
     * Lista detallada de cada producto en el carrito.
     */
    private List<CartItemDto> items;

    /**
     * Número de tipos de productos diferentes (ej: 3 juegos distintos).
     */
    private Long   totalProductosDistintos;

    /**
     * Suma total de unidades de todos los productos (ej: 10 unidades en total).
     */
    private Long   totalUnidades;

    /**
     * Importe monetario total del carrito tras aplicar descuentos.
     */
    private Double importeTotal;
}