package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "propietario")
public class Propietario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nombre;

        private String direccion;

        private String telefono;

        // Relación uno a muchos con la entidad Mascotas
        @OneToMany(mappedBy = "propietario")
        private List<Mascotas> mascotas;

}