package com.example.demo.Controller;

import com.example.demo.Model.Consulta;
import com.example.demo.Service.ConsultaService;
import com.example.demo.Service.MascotasService;
import com.example.demo.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private MascotasService mascotaService; // Asegúrate de tener un servicio para Mascotas

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private ConsultaService service;


    @GetMapping("/listar")
    public String listarConsulta(Model model){

        model.addAttribute("titulo","Spring DB");
        model.addAttribute("cuerpo","LISTA DE Consultas");

        model.addAttribute("datos", service.listar());
        return "InicioConsultas";
    }

    @GetMapping("/nuevoP")
    public String formAgregarConsultas(Model model){
        model.addAttribute("con", new Consulta());
        model.addAttribute("mascotas", mascotaService.listar()); // Carga todas las mascotas
        model.addAttribute("veterinarios", veterinarioService.listar()); // Carga todos los veterinarios
        return "consultasNuevo";
    }

    @PostMapping("/guardar")
    public String guardarConsultas(@ModelAttribute Consulta con){
        service.guardar(con);
        return "redirect:/consulta/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarConsultas(@PathVariable("id") int id, Model model){

        // Optional<Propietario> est =  service.editar(id);

        model.addAttribute("con", service.editar(id));

        return "consultasNuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConsultas(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/consulta/listar";

    }
}
