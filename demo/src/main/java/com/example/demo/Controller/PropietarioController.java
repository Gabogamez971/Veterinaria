package com.example.demo.Controller;

import com.example.demo.Model.Propietario;
import com.example.demo.interfaceService.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    private IPropietarioService service;


    @GetMapping("/listar")
    public String listarPropietarios(Model model){

        model.addAttribute("titulo","Spring DB");
        model.addAttribute("cuerpo","LISTA DE PROPIETARIOS");

        model.addAttribute("datos", service.listar());
        return "propietario";
    }

    @GetMapping("/nuevoP")
    public String formAgregarPropietarios(Model model){
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");
        model.addAttribute("pro",new Propietario());
        return "propietarioNuevo";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Propietario pro){
        service.guardar(pro);
        return "redirect:/propietario/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable("id") int id, Model model){

        // Optional<Propietario> est =  service.editar(id);

        model.addAttribute("pro", service.editar(id));

        return "propietarioNuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/propietario/listar";

    }
}
