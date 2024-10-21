package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "propietario")
public class Propietario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codigo;

        private String nombre;

        private String direccion;

        private String telefono;



}
