package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Command {
    private long id;
    private long clientId;
    private long livreurId;
    private long plateId;
    private long resturatureId;
    private double totalPrice;
    private String address;
    private String state;
    private int quantity;
    private int sent;
    private int finshed;

    public Command(long id, long clientId, long livreurId, long plateId, long resturatureId, String state, int sent, int finshed) {
        this.id = id;
        this.clientId = clientId;
        this.livreurId = livreurId;
        this.plateId = plateId;
        this.resturatureId = resturatureId;
        this.state = state;
        this.sent = sent;
        this.finshed = finshed;
    }
    public Command(){}
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

    public long getLivreurId() {
        return livreurId;
    }

    public void setLivreurId(long livreurId) {
        this.livreurId = livreurId;
    }

    public long getPlateId() {
        return plateId;
    }

    public void setPlateId(long plateId) {
        this.plateId = plateId;
    }

    public long getResturatureId() {
        return resturatureId;
    }

    public void setResturatureId(long resturatureId) {
        this.resturatureId = resturatureId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public int getFinshed() {
        return finshed;
    }

    public void setFinshed(int finshed) {
        this.finshed = finshed;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", livreurId=" + livreurId +
                ", plateId=" + plateId +
                ", resturatureId=" + resturatureId +
                ", state='" + state + '\'' +
                ", sent=" + sent +
                ", finshed=" + finshed +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
