package es.iesclaradelrey.da2d1a.tiendafgg.common.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que define los niveles de autoridad o perfiles de acceso en el sistema.
 * <p>
 * Se utiliza una clave primaria natural (String) para facilitar la lectura de
 * la base de datos y la integración con las GrantedAuthorities de Spring Security.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Rol {

    /**
     * Identificador único del rol (ej: "USER", "ADMIN").
     * Máximo de 6 caracteres para optimizar el almacenamiento y los índices.
     */
    @Id
    @Column(length = 6)
    private String id;

    /**
     * Explicación detallada de los permisos asociados al rol.
     */
    @Column(length = 100)
    private String descripcion;
}