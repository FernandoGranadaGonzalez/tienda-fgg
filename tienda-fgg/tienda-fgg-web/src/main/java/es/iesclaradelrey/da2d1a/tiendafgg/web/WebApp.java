package es.iesclaradelrey.da2d1a.tiendafgg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal de entrada para la aplicación TiendaFGG.
 * <p>
 * Centraliza la configuración de escaneo de componentes, entidades y repositorios,
 * permitiendo una arquitectura modular y desacoplada a lo largo de toda la raíz
 * del proyecto.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a.tiendafgg")
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a.tiendafgg")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a.tiendafgg")
public class WebApp {

    /**
     * Punto de inicio del proceso de ejecución de Spring Boot.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}