package es.iesclaradelrey.da2d1a.tiendafgg.api.config;

import es.iesclaradelrey.da2d1a.tiendafgg.api.jwt.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

/**
 * Configuración de seguridad principal para la API del proyecto.
 *
 * <p>Esta clase define la cadena de filtros de seguridad, estableciendo una política
 * de sesión sin estado (stateless) y configurando los puntos de acceso públicos y privados.</p>
 *
 * <p>Usa {@code @Order(1)} para asegurar que esta configuración se evalúe antes que
 * otras posibles configuraciones de seguridad en la aplicación.</p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig {

    /** Filtro personalizado para la interceptación y validación de tokens JWT. */
    private final JwtAuthFilter jwtAuthFilter;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param jwtAuthFilter El filtro de autenticación JWT que se insertará en la cadena de seguridad.
     */
    public ApiSecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    /**
     * Define la jerarquía de filtros y reglas de acceso HTTP.
     *
     * <p>Configuraciones clave:
     * <ul>
     *   <li>Desactivación de CSRF (no necesario en APIs stateless).</li>
     *   <li>Desactivación de formularios de login y HTTP Basic por defecto.</li>
     *   <li>Política de creación de sesión {@code STATELESS}.</li>
     *   <li>Permitir acceso libre a rutas de autenticación mediante Regex y a la consola H2.</li>
     *   <li>Exigir autenticación para cualquier otra petición.</li>
     * </ul>
     * </p>
     *
     * @param http Objeto {@link HttpSecurity} para configurar la seguridad a nivel de red.
     * @return La cadena de filtros configurada ({@link SecurityFilterChain}).
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())
                .logout(logout -> logout.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new RegexRequestMatcher("/api/v\\d+/auth.*", null)).permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Expone el {@link AuthenticationManager} como un Bean de Spring.
     *
     * <p>Este gestor es fundamental para procesar las solicitudes de autenticación
     * (por ejemplo, en el controlador de login) comparando las credenciales proporcionadas
     * con el almacén de datos configurado.</p>
     *
     * @param config Configuración de autenticación de Spring Security.
     * @return El gestor de autenticación configurado.
     * @throws Exception Si hay errores al obtener el gestor.
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}