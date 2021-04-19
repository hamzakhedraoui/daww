package com.example.demo.dao;

import com.example.demo.models.Account;
import com.example.demo.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
