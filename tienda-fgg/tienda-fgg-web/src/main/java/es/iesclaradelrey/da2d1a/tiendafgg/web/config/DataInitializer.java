package es.iesclaradelrey.da2d1a.tiendafgg.web.config;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Category;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryService categoryService;

    public DataInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.guardar(new Category(1L, "Aventura", "Explora mundos épicos", "aventura.jpg"));
        categoryService.guardar(new Category(2L, "Shooter", "Acción frenética en primera persona", "shooter.png"));
        categoryService.guardar(new Category(3L, "Estrategia", "Planifica tu victoria", "estrategia.png"));
        categoryService.guardar(new Category(4L, "RPG", "Juegos de rol y fantasía", null));
    }
}