package es.iesclaradelrey.da2d1a.tiendafgg.web.config;

import es.iesclaradelrey.da2d1a.tiendafgg.security.audit.AuditLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

/**
 * Configuración maestra de seguridad perimetral.
 * <p>
 * Define la cadena de filtros (SecurityFilterChain) que protege los recursos
 * de la TiendaFGG, gestionando el ciclo de vida de la sesión, la política
 * de acceso por roles y la integración de la auditoría.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.1
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /** Handler de auditoría: se registra en el proceso de logout. */
    private final AuditLogoutHandler auditLogoutHandler;

    public SecurityConfig(AuditLogoutHandler auditLogoutHandler) {
        this.auditLogoutHandler = auditLogoutHandler;
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/imagenes/**", "/about-us.html").permitAll()
                        .requestMatchers("/login", "/error", "/acceso-denegado").permitAll()
                        .requestMatchers("/register").anonymous()
                        .requestMatchers("/", "/index", "/sobre-nosotros", "/condiciones").permitAll()
                        .requestMatchers("/productos", "/productos/**").permitAll()
                        .requestMatchers("/categorias", "/categorias/**").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/users/profile", "/users/profile/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .addLogoutHandler(auditLogoutHandler)
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