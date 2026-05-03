package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa la marca o fabricante de un videojuego (ej. Nintendo, Sega, Sony).
 * <p>
 * Esta clase se mapea con la tabla "marcas" en la base de datos.
 * Utiliza Lombok para reducir el código repetitivo y JPA para la gestión de persistencia.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "marcas")
public class Marca {

    /**
     * Identificador único de la marca.
     * Generado automáticamente por la base de datos (Identity).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre comercial de la marca.
     * Es un campo obligatorio (not null) y no puede haber dos marcas con el mismo nombre en la tabla.
     */
    @Column(nullable = false, unique = true)
    private String nombre;

    /**
     * Relación de uno a muchos con la entidad {@link Videojuego}.
     * <p>
     * Una marca puede tener asociados múltiples videojuegos.
     * El atributo {@code mappedBy = "marca"} indica que la clave ajena (FK)
     * está gestionada por el campo "marca" en la clase {@code Videojuego}.
     * </p>
     * <p>
     * {@code cascade = CascadeType.ALL}: Significa que cualquier operación realizada
     * sobre la Marca (guardar, borrar, actualizar) se propagará automáticamente
     * a todos sus videojuegos asociados.
     * </p>
     */
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Videojuego> videojuegos = new ArrayList<>();

    /**
     * Constructor simplificado para crear una marca solo con su nombre.
     * Útil para instanciaciones rápidas donde el ID se generará en la base de datos.
     *
     * @param nombre Nombre de la marca a crear.
     */
    public Marca(String nombre) {
        this.nombre = nombre;
    }
}