package es.iesclaradelrey.da2d1a.tiendafgg.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración para personalizar el comportamiento de Spring MVC.
 * <p>
 * Implementa {@link WebMvcConfigurer} para añadir configuraciones adicionales
 * al entorno web de la aplicación sin necesidad de modificar los controladores
 * existentes. Se utiliza principalmente para gestionar recursos web y navegación.
 * </p>
 *
 * @author Fernando Granada
 * @version 1.0
 */
@Configuration
public class WebConfiguracion implements WebMvcConfigurer {

    /**
     * Registra controladores de vista (view controllers) para rutas estáticas o directas.
     * <p>
     * Este método permite mapear directamente una URL a una plantilla de vista (Thymeleaf, etc.)
     * sin necesidad de crear un método específico en una clase anotada con {@code @Controller}.
     * Es ideal para páginas con contenido estático como términos de servicio o políticas.
     * </p>
     *
     * @param registro El registro donde se añaden las configuraciones de vistas y rutas.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/condiciones").setViewName("legal/terms");
    }
}