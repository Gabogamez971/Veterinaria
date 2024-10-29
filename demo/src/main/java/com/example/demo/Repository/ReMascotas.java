package com.example.demo.Repository;

import com.example.demo.Model.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReMascotas extends JpaRepository<Mascotas,Integer> {
}
