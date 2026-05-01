package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Videojuego;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        List<Videojuego> videojuegos = videojuegoService.obtenerTodos();

        if (videojuegos != null) {
            videojuegos.sort(Comparator.comparing(Videojuego::getTitulo, String.CASE_INSENSITIVE_ORDER));
        }

        model.addAttribute("videojuegos", videojuegos);
        return "productos/listado";
    }

    @GetMapping("/{id}/{nombreEscapado}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Optional<Videojuego> videojuegoOptional = videojuegoService.buscarPorId(id);

        if (videojuegoOptional.isPresent()) {
            model.addAttribute("juego", videojuegoOptional.get());
            return "productos/detalle";
        } else {
            return "redirect:/productos";
        }
    }
}