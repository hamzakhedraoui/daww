package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
    private long id;
    private long clientId;
    private long plateId;
    private int finshed;

    public Card(long id, long clientId, long plateId, int finshed) {
        this.id = id;
        this.clientId = clientId;
        this.plateId = plateId;
        this.finshed = finshed;
    }
    public Card(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getPlateId() {
        return plateId;
    }

    public void setPlateId(long plateId) {
        this.plateId = plateId;
    }

    public int getFinshed() {
        return finshed;
    }

    public void setFinshed(int finshed) {
        this.finshed = finshed;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", plateId=" + plateId +
                ", finshed=" + finshed +
                '}';
    }

}
