package es.iesclaradelrey.da2d1a.tiendafgg.api.mapper;

import es.iesclaradelrey.da2d1a.tiendafgg.api.dto.CartItemDto;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.ItemCarrito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper para la transformación de ítems del carrito de la base de datos a la API.
 * <p>
 * Utiliza MapStruct para gestionar la proyección de datos desde la entidad
 * {@link ItemCarrito} hacia el DTO {@link CartItemDto}, realizando cálculos
 * financieros en tiempo de mapeo.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CarritoMapper {

    /**
     * Transforma un ítem de persistencia en un objeto de vista para el cliente.
     * <p>
     * Se aplican mapeos personalizados para "aplanar" la relación con Videojuego
     * y calcular los precios derivados del descuento actual.
     * </p>
     */
    @Mapping(target = "titulo",            source = "videojuego.titulo")
    @Mapping(target = "precioUnitario",    source = "videojuego.precio")
    @Mapping(target = "descuento",         source = "videojuego.descuento")
    @Mapping(target = "precioConDescuento",
            expression = "java(calcPrecioConDescuento(item.getVideojuego().getPrecio(), item.getVideojuego().getDescuento()))")
    @Mapping(target = "precioTotal",
            expression = "java(calcPrecioConDescuento(item.getVideojuego().getPrecio(), item.getVideojuego().getDescuento()) * item.getUnidades())")
    CartItemDto toDto(ItemCarrito item);

    /**
     * Mapeo masivo para listas de ítems (útil para recuperar el carrito completo).
     */
    List<CartItemDto> toDtoList(List<ItemCarrito> items);

    /**
     * Lógica auxiliar para el cálculo de descuentos.
     *
     * @param precio Precio base del producto.
     * @param descuento Porcentaje de rebaja (0-100).
     * @return El precio neto tras aplicar el descuento.
     */
    default Double calcPrecioConDescuento(Double precio, Integer descuento) {
        if (precio == null) return 0.0;
        if (descuento == null || descuento == 0) return precio;
        return precio * (1.0 - descuento / 100.0);
    }
}