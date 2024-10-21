package com.example.demo.interfaceService;

import com.example.demo.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {

    // AQUI SE VAN A CREAR LOS METODOS QUE VOY USAR

    public List<Propietario> listar();

    public void guardar(Propietario pro);

    public Optional<Propietario> editar(int id);

    public void eliminar (int id);
}
