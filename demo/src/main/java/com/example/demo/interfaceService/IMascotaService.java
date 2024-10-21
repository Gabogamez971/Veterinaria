package com.example.demo.interfaceService;

import com.example.demo.Model.Mascotas;
import com.example.demo.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    public List<Propietario> listar();

    public void guardar(Mascotas mas);

    public Optional<Propietario> editar(int id);

    public void eliminar (int id);
}
