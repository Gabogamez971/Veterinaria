package com.example.demo.Service;

import com.example.demo.Model.Consulta;
import com.example.demo.Repository.ReConsulta;
import com.example.demo.interfaceService.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private ReConsulta repositorio;

    @Override
    public List<Consulta> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Consulta con) {
        repositorio.save(con);
    }

    @Override
    public Optional<Consulta> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);

    }
}
