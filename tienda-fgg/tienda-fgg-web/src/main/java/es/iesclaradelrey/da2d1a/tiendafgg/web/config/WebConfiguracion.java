package es.iesclaradelrey.da2d1a.tiendafgg.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración para personalizar el comportamiento de Spring MVC.
 * <p>
 * Implementa {@link WebMvcConfigurer} para añadir configuraciones adicionales
 * al entorno web de la aplicación sin necesidad de modificar los controladores
 * existentes.
 * </p>
 * * @author TuNombre
 * @version 1.0
 */
@Configuration
public class WebConfiguracion implements WebMvcConfigurer {

    /**
     * Registra controladores de vista (view controllers) para rutas estáticas.
     * <p>
     * Este método permite mapear directamente una URL a una vista sin requerir
     * la creación de un método en una clase {@code @Controller}.
     * Es ideal para páginas simples como términos de servicio, políticas de privacidad,
     * o páginas de ayuda.
     * </p>
     *
     * @param registro El registro donde se añaden las configuraciones de vistas.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/condiciones").setViewName("legal/terms");
    }
}