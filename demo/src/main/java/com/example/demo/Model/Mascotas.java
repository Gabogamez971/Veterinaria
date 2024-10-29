package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "mascota")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String especie;

    private String raza;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    // Relación muchos a uno con la entidad Propietario
    @ManyToOne
    @JoinColumn(name = "propietario_id", referencedColumnName = "id") // corregido para que coincida con 'codigo' en Propietario
    private Propietario propietario;

    // Relación uno a muchos con Consulta
   /* @OneToMany(mappedBy = "mascota")
    private List<Consulta> consulta;*/
}
