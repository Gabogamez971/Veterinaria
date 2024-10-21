package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.util.Date;

@Data
@Entity
@Table(name = "mascota")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    private String especie;

    private String raza;

    private Date fecha_nacimiento;

    private int propietario_id;


    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;



}
