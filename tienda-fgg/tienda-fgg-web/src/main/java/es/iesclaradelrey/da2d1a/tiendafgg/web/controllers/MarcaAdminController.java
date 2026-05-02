package es.iesclaradelrey.da2d1a.tiendafgg.web.controllers;

import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendafgg.common.services.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("marcaAdminController")
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final MarcaService marcaService;

    public MarcaAdminController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("elementos", marcaService.obtenerTodos());
        return "admin/marcas/listado";
    }

    @GetMapping("/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marcas/formulario";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("marca") Marca marca, Model model) {
        try {
            marcaService.guardar(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/marcas/formulario";
        }
    }

    @GetMapping("/{id}/edit")
    public String editar(@PathVariable Long id, Model model) {
        marcaService.buscarPorId(id).ifPresent(m -> model.addAttribute("marca", m));
        return "admin/marcas/formulario";
    }

    @GetMapping("/{id}/delete")
    public String confirmarBorrado(@PathVariable Long id, Model model) {
        marcaService.buscarPorId(id).ifPresent(m -> model.addAttribute("elemento", m));
        model.addAttribute("urlBorrar", "/admin/marcas/" + id + "/delete");
        return "admin/confirmar-borrado";
    }

    @PostMapping("/{id}/delete")
    public String ejecutarBorrado(@PathVariable Long id, Model model) {
        try {
            marcaService.eliminar(id);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            model.addAttribute("error", "No se puede eliminar: existen productos asociados.");
            return "admin/confirmar-borrado";
        }
    }
}