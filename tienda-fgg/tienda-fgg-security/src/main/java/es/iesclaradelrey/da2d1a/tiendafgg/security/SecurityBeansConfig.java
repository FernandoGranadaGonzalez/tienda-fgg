package es.iesclaradelrey.da2d1a.tiendafgg.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración de los componentes (Beans) relacionados con la seguridad.
 * <p>
 * Centraliza la definición de algoritmos de cifrado y otros componentes 
 * compartidos por la infraestructura de seguridad de la aplicación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Configuration
public class SecurityBeansConfig {

    /**
     * Define el algoritmo de hashing para las contraseñas.
     * <p>
     * Se utiliza {@link BCryptPasswordEncoder}, que es el estándar de la industria.
     * Implementa un sistema de "sal" (salt) automático para protegerse contra
     * ataques de tablas arcoíris (rainbow tables).
     * </p>
     *
     * @return Una instancia de BCryptPasswordEncoder con fuerza de hash 12.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}