package com.example.demo.interfaceService;

import com.example.demo.Model.Consulta;
import com.example.demo.Model.Mascotas;
import com.example.demo.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IConsultaService {

    public List<Consulta> listar();

    public void guardar(Consulta con);

    public Optional<Consulta> editar(int id);

    public void eliminar (int id);
}
