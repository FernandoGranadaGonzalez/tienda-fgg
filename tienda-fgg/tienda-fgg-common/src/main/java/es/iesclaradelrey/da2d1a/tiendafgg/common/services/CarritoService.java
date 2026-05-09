package es.iesclaradelrey.da2d1a.tiendafgg.common.services;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.ItemCarrito;
import java.util.List;

/**
 * Contrato de servicios para la gestión de la cesta de la compra.
 * <p>
 * Define las operaciones permitidas sobre los ítems del carrito,
 * abstrayendo la complejidad de la persistencia y las reglas de
 * actualización de cantidades.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface CarritoService {

    /**
     * Recupera la lista completa de artículos asociados al carrito de un usuario.
     *
     * @param usuarioId Identificador único del cliente.
     * @return Lista de {@link ItemCarrito} con productos y cantidades.
     */
    List<ItemCarrito> getItems(Long usuarioId);

    /**
     * Gestiona la adición de productos al carrito mediante lógica "Upsert".
     * <p>
     * Si el videojuego ya existe en el carrito del usuario, se deben
     * sumar las nuevas unidades a las ya existentes. En caso contrario,
     * se debe crear un nuevo registro.
     * </p>
     *
     * @param usuarioId    Identificador del cliente.
     * @param videojuegoId Identificador del producto a añadir.
     * @param unidades     Cantidad de unidades a incrementar/añadir.
     * @return El ítem del carrito creado o actualizado.
     */
    ItemCarrito addOrUpdateItem(Long usuarioId, Long videojuegoId, Integer unidades);

    /**
     * Elimina una línea específica (producto) del carrito del usuario.
     *
     * @param usuarioId    Identificador del cliente.
     * @param videojuegoId Identificador del producto a remover.
     */
    void removeItem(Long usuarioId, Long videojuegoId);

    /**
     * Elimina todos los registros del carrito para un usuario determinado.
     * Útil tras la confirmación de un pedido o por solicitud de limpieza del usuario.
     *
     * @param usuarioId Identificador del cliente.
     */
    void clearCart(Long usuarioId);
}