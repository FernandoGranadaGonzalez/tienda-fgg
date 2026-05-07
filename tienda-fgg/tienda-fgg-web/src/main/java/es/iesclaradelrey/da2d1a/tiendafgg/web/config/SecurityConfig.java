package es.iesclaradelrey.da2d1a.tiendafgg.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

/**
 * Configuración central de la seguridad de la aplicación.
 * <p>
 * Define las reglas de acceso a las rutas (URL), la configuración del formulario
 * de inicio de sesión personalizado, la gestión de logout y la seguridad 
 * de la base de datos H2 integrada.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * Dialecto para integrar Spring Security con Thymeleaf.
     * Permite usar atributos como sec:authorize en las plantillas HTML.
     */
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    /**
     * Define la cadena de filtros de seguridad que interceptarán las peticiones HTTP.
     *
     * @param http Configuración de seguridad HTTP.
     * @return El filtro de seguridad configurado.
     * @throws Exception Si ocurre un error durante la configuración.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/imagenes/**", "/favicon.ico").permitAll()
                        .requestMatchers("/login", "/error", "/acceso-denegado").permitAll()
                        
                        .requestMatchers("/register").anonymous()
                        
                        .requestMatchers("/", "/index", "/sobre-nosotros", "/condiciones").permitAll()
                        .requestMatchers("/productos/**", "/categorias/**").permitAll()
                        
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        
                        .requestMatchers("/users/profile/**").authenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                )
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/acceso-denegado")
                );

        return http.build();
    }
}