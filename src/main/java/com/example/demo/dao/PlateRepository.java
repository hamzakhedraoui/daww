package com.example.demo.dao;

import com.example.demo.models.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate,Long> {
}
