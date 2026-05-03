package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa una categoría de videojuegos en el sistema.
 * <p>
 * Esta clase está mapeada a la tabla "categorias" en la base de datos.
 * Utiliza anotaciones de Lombok para la generación automática de código boilerplate
 * y JPA para la persistencia de datos.
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
@Table(name = "categorias")
public class Categoria {

    /**
     * Identificador único de la categoría.
     * Se genera automáticamente mediante una estrategia de identidad (autoincremental).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría (ej. Acción, RPG, Aventuras).
     * Es un campo obligatorio, único en la base de datos y con una longitud máxima de 100 caracteres.
     */
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    /**
     * Lista de videojuegos que pertenecen a esta categoría.
     * <p>
     * Establece una relación muchos a muchos (ManyToMany). El atributo "mappedBy"
     * indica que la relación es propiedad de la entidad {@code Videojuego},
     * específicamente del campo "categorias" en dicha clase.
     * </p>
     * Se excluye de {@code toString()} para evitar bucles infinitos de recursividad
     * al imprimir la entidad si la relación es bidireccional.
     */
    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    private List<Videojuego> videojuegos = new ArrayList<>();

    /**
     * Descripción detallada de lo que engloba la categoría.
     * Longitud máxima de 2000 caracteres.
     */
    @Column(length = 2000)
    private String descripcion;

    /**
     * Ruta o nombre del archivo de imagen que representa a la categoría.
     * Por defecto se asigna "no-image.png".
     */
    @Builder.Default
    @Column(length = 500)
    private String imagen = "no-image.png";

    /**
     * Constructor personalizado para inicializar una categoría con sus datos básicos.
     * Útil cuando no se requiere la lista de videojuegos o el builder completo.
     *
     * @param id Identificador de la categoría.
     * @param nombre Nombre descriptivo.
     * @param descripcion Explicación de la categoría.
     */
    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = "no-image.png";
    }
}