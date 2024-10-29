package com.example.demo.Controller;

import com.example.demo.Model.Mascotas;
import com.example.demo.interfaceService.IMascotaService;
import com.example.demo.interfaceService.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private IMascotaService service;

    @Autowired
    private IPropietarioService servicee;


    @GetMapping("/listar")
    public String listarMascota(Model model){

        model.addAttribute("titulo","Spring DB");
        model.addAttribute("cuerpo","LISTA DE MASCOTAS");

        model.addAttribute("datos", service.listar());
        return "InicioMascota";
    }

    @GetMapping("/nuevoP")
    public String mostrarFormularioDeMascota(Model model) {
        model.addAttribute("mas", new Mascotas());
        model.addAttribute("propietario", servicee.listar());
        return "mascotaNuevo";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascotas mas) {
        service.guardar(mas);
        return "redirect:/mascota/listar"; // Asegúrate de que la redirección es correcta
    }


    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") int id, Model model){

        // Optional<Propietario> est =  service.editar(id);

        model.addAttribute("mas", service.editar(id));

        return "mascotaNuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/mascota/listar";

    }
}
