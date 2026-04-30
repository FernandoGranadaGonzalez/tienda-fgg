package es.iesclaradelrey.da2d1a.tiendafgg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("es.iesclaradelrey.da2d1a.tiendafgg.common.entities")
@EnableJpaRepositories("es.iesclaradelrey.da2d1a.tiendafgg.common.repositories")
@ComponentScan({"es.iesclaradelrey.da2d1a.tiendafgg.web", "es.iesclaradelrey.da2d1a.tiendafgg.common"})
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}