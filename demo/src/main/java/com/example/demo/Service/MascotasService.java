package com.example.demo.Service;

import com.example.demo.Model.Mascotas;
import com.example.demo.Repository.ReConsulta;
import com.example.demo.Repository.ReMascotas;
import com.example.demo.interfaceService.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasService implements IMascotaService {

    @Autowired
    private ReMascotas repositorio;

    @Override
    public List<Mascotas> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascotas mas) {
        repositorio.save(mas);
    }

    @Override
    public Optional<Mascotas> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
