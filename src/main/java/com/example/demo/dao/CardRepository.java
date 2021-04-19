package com.example.demo.dao;

import com.example.demo.models.Card;
import com.example.demo.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
