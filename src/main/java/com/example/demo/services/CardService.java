package com.example.demo.services;


import com.example.demo.dao.CardRepository;
import com.example.demo.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardService {
    private CardRepository repo;
    @Autowired
    public CardService(CardRepository repo) {
        this.repo = repo;
    }
    public List<Card> listAll() {
        return repo.findAll();
    }

    public void save(Card card) {
        repo.save(card);
    }

    public Card get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
