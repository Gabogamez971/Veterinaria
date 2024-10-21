package com.example.demo.Controller;

import com.example.demo.Model.Propietario;
import com.example.demo.interfaceService.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class PropietarioController {

    @Autowired
    private IPropietarioService service;


    @GetMapping("/listar")
    public String listarPropietarios(Model model){

        model.addAttribute("titulo","Spring DB");
        model.addAttribute("cuerpo","LISTA DE PROPIETARIOS");

        model.addAttribute("datos", service.listar());
        return "index";
    }

    @GetMapping("/nuevo")
    public String formAgregarPropietarios(Model model){

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");

        model.addAttribute("prop",new Propietario());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Propietario pro){

        service.guardar(pro);

        return "redirect:/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable("id") int id, Model model){

        // Optional<Propietario> est =  service.editar(id);

        model.addAttribute("prop", service.editar(id));

        return "nuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/listar";

    }
}
