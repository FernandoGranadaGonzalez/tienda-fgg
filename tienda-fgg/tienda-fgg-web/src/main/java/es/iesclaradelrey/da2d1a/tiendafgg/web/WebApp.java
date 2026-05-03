package es.iesclaradelrey.da2d1a.tiendafgg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal de configuración y arranque de la aplicación Spring Boot.
 * <p>
 * Esta clase inicializa el contexto de Spring, activa la autoconfiguración
 * y coordina el escaneo de entidades, repositorios y servicios distribuidos
 * entre los paquetes del proyecto.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@SpringBootApplication
@EntityScan("es.iesclaradelrey.da2d1a.tiendafgg.common.entities")
@EnableJpaRepositories("es.iesclaradelrey.da2d1a.tiendafgg.common.repositories")
@ComponentScan({"es.iesclaradelrey.da2d1a.tiendafgg.web", "es.iesclaradelrey.da2d1a.tiendafgg.common"})
public class WebApp {

    /**
     * Punto de entrada principal del programa.
     * <p>
     * Lanza la aplicación utilizando {@link SpringApplication#run}, lo que levanta
     * el servidor embebido (Tomcat por defecto) y despliega la tienda virtual.
     * </p>
     *
     * @param args Argumentos de línea de comandos pasados al inicio de la ejecución.
     */
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}