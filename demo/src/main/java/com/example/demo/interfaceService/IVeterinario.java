package com.example.demo.interfaceService;

import com.example.demo.Model.Mascotas;
import com.example.demo.Model.Propietario;
import com.example.demo.Model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface IVeterinario {
    public List<Veterinario> listar();

    public void guardar(Veterinario vet);

    public Optional<Veterinario> editar(int id);

    public void eliminar (int id);
}
