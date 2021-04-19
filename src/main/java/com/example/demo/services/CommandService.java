package com.example.demo.services;

import com.example.demo.dao.CommandRepository;
import com.example.demo.models.Command;
import com.example.demo.models.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandService {

    private CommandRepository repo;

    @Autowired
    public CommandService(CommandRepository repo) {
        this.repo = repo;
    }

    public List<Command> listAll() {
        return repo.findAll();
    }

    public void save(Command command) {
        repo.save(command);
    }

    public Command get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
