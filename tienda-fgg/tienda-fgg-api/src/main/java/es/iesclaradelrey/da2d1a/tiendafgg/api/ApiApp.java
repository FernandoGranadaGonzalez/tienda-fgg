package es.iesclaradelrey.da2d1a.tiendafgg.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication(scanBasePackages = "es.iesclaradelrey.da2d1a.tiendafgg")
@EntityScan(basePackages            = "es.iesclaradelrey.da2d1a.tiendafgg")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a.tiendafgg")
public class ApiApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }

    /**
     * Registra MultipartFilter ANTES que el filtro de Spring Security,
     * para que las peticiones multipart/form-data se parseen correctamente
     * antes de que el JwtAuthFilter intente leer los headers.
     */
    @Bean
    public FilterRegistrationBean<MultipartFilter> multipartFilter() {
        FilterRegistrationBean<MultipartFilter> registration =
                new FilterRegistrationBean<>(new MultipartFilter());
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}