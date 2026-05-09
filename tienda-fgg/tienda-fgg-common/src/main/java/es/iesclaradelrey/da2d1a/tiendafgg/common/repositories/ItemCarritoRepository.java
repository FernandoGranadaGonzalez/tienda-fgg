package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la gestión de persistencia de los ítems del carrito.
 * <p>
 * Combina métodos derivados por nombre de Spring Data JPA con consultas
 * JPQL complejas para el cálculo de totales y operaciones de borrado masivo.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {

    /** Recupera todos los artículos del carrito de un usuario específico. */
    List<ItemCarrito> findByUsuarioId(Long usuarioId);

    /** Busca un producto concreto dentro del carrito de un usuario. */
    Optional<ItemCarrito> findByUsuarioIdAndVideojuegoId(Long usuarioId, Long videojuegoId);

    /** Comprueba la existencia de un producto en el carrito. */
    boolean existsByUsuarioIdAndVideojuegoId(Long usuarioId, Long videojuegoId);

    /**
     * Elimina un producto específico del carrito del usuario.
     * Requiere @Modifying por ser una operación de escritura personalizada.
     */
    @Modifying
    @Query("DELETE FROM ItemCarrito i WHERE i.usuario.id = :usuarioId AND i.videojuego.id = :videojuegoId")
    void deleteByUsuarioIdAndVideojuegoId(@Param("usuarioId") Long usuarioId,
                                          @Param("videojuegoId") Long videojuegoId);

    /** Vacía completamente el carrito de un usuario. */
    @Modifying
    @Query("DELETE FROM ItemCarrito i WHERE i.usuario.id = :usuarioId")
    void deleteByUsuarioId(@Param("usuarioId") Long usuarioId);

    // ── Consultas personalizadas JPQL para los totales del carrito ────────

    /** Cuenta cuántos videojuegos diferentes tiene el usuario en su cesta. */
    @Query("SELECT COUNT(DISTINCT i.videojuego.id) FROM ItemCarrito i WHERE i.usuario.id = :usuarioId")
    Long countProductosDistintos(@Param("usuarioId") Long usuarioId);

    /** Suma el número total de unidades (cantidad física de productos). */
    @Query("SELECT COALESCE(SUM(i.unidades), 0) FROM ItemCarrito i WHERE i.usuario.id = :usuarioId")
    Long sumUnidades(@Param("usuarioId") Long usuarioId);

    /**
     * Calcula el importe total del carrito aplicando el descuento de cada videojuego.
     * <p>
     * La fórmula financiera se ejecuta en el motor de base de datos para
     * garantizar la máxima precisión y rendimiento.
     * </p>
     */
    @Query("""
        SELECT COALESCE(
            SUM(i.unidades * i.videojuego.precio * (1.0 - i.videojuego.descuento / 100.0)),
            0.0)
        FROM ItemCarrito i
        WHERE i.usuario.id = :usuarioId
        """)
    Double calcularImporteTotal(@Param("usuarioId") Long usuarioId);
}