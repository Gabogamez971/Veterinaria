package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nombre;

    private String especialidad;

    private String telefono;

    @OneToMany(mappedBy = "veterinario")
    private List<Consulta>consulta;

}
