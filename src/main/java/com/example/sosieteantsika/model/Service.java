package com.example.sosieteantsika.model;

public class Service {
    int id_service;
    String nom;
    
    public Service(int id_service, String nom) {
        this.id_service = id_service;
        this.nom = nom;
    }
    public Service() {
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
