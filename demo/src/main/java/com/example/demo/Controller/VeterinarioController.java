package com.example.demo.Controller;

import com.example.demo.Model.Veterinario;
import com.example.demo.interfaceService.IVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping("/veterinario")
    public class VeterinarioController {

        @Autowired
        private IVeterinario service;


        @GetMapping("/listar")
        public String listarVeterinarios(Model model){

            model.addAttribute("titulo","Spring DB");
            model.addAttribute("cuerpo","LISTA DE Veterinarios");

            model.addAttribute("datos", service.listar());
            return "InicioVeterinario";
        }

        @GetMapping("/nuevoP")
        public String formAgregarVeterinarios(Model model){
            model.addAttribute("titulo", "Nuevo");
            model.addAttribute("cuerpo", "USUARIO NUEVO");
            model.addAttribute("vet",new Veterinario());
            return "veterinarioNuevo";
        }

        @PostMapping("/guardar")
        public String guardarVeterinario(@ModelAttribute Veterinario vet){
            service.guardar(vet);
            return "redirect:/veterinario/listar";
        }


        @GetMapping("/editar/{id}")
        public String editarVeterinario(@PathVariable("id") int id, Model model){

            // Optional<Propietario> est =  service.editar(id);

            model.addAttribute("vet", service.editar(id));

            return "propietarioNuevo";

        }

        @GetMapping("/eliminar/{id}")
        public String eliminarVterinario(@PathVariable("id") int id){

            service.eliminar(id);

            return "redirect:/propietario/listar";

        }
    }
