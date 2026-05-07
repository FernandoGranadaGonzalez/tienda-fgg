package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa los roles o perfiles de autoridad dentro del sistema.
 * <p>
 * Los roles definen los permisos que tiene un usuario (ej: ADMIN, USER, EDITOR).
 * Se utiliza una cadena de texto corta como identificador para facilitar la
 * integración con los esquemas de seguridad de Spring Security.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {

    /**
     * Identificador único del rol.
     * <p>
     * Se recomienda usar códigos cortos en mayúsculas (ej: 'ADMIN', 'USER').
     * Tiene una longitud máxima de 6 caracteres según la definición de la columna.
     * </p>
     */
    @Id
    @Column(length = 6)
    private String id;

    /**
     * Descripción detallada de las funciones o permisos asociados al rol.
     * <p>
     * Ejemplo: "Administrador con acceso total", "Usuario final registrado".
     * </p>
     */
    @Column(nullable = false, length = 100)
    private String descripcion;
}