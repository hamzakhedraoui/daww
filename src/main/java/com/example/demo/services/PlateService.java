package com.example.demo.services;

import com.example.demo.dao.PlateRepository;
import com.example.demo.models.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlateService {

    private PlateRepository repo;

    @Autowired
    public PlateService(PlateRepository repo) {
        this.repo = repo;
    }
    public List<Plate> listAll() {
        return repo.findAll();
    }

    public void save(Plate plate) {
        repo.save(plate);
    }

    public Plate get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
