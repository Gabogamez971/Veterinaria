package com.example.demo.Service;

import com.example.demo.Model.Propietario;
import com.example.demo.Repository.RePropietario;
import com.example.demo.interfaceService.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService implements IPropietarioService  {

    // AQUI SE IMPLMENTAN LOS METODOS QUE ESTAN EN INTERFACE SERVICE

    // SE DEBE INYECTAR LA INTERFACE QUE EXITENDE DE JPA

    @Autowired
    private RePropietario repositorio;


    @Override
    public List<Propietario> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Propietario pro) {
        repositorio.save(pro);
    }

    @Override
    public Optional<Propietario> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {

        repositorio.deleteById(id);

    }
}
