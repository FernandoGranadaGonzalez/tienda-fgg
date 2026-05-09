package es.iesclaradelrey.da2d1a.tiendafgg.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración de componentes de infraestructura de seguridad.
 * <p>
 * Define los Beans necesarios para el tratamiento de datos sensibles,
 * asegurando que las contraseñas nunca se procesen ni almacenen en texto plano.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Configuration
public class SecurityBeansConfig {

    /**
     * Define el algoritmo de hashing para las contraseñas del sistema.
     * <p>
     * Se utiliza BCrypt, un algoritmo que incorpora 'salt' de forma nativa
     * y permite ajustar el coste computacional. Un factor de 12 ofrece una
     * excelente resistencia ante ataques de diccionarios y computación paralela.
     * </p>
     *
     * @return Implementación de BCryptPasswordEncoder con fuerza 12.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}