package com.example.demo.services;

import com.example.demo.dao.DiscountRepository;
import com.example.demo.models.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiscountService {
    private DiscountRepository repo;

    @Autowired
    public DiscountService(DiscountRepository repo) {
        this.repo = repo;
    }
    public List<Discount> listAll() {
        return repo.findAll();
    }

    public void save(Discount discount) {
        repo.save(discount);
    }

    public Discount get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
