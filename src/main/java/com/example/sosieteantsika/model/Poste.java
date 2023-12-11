package com.example.sosieteantsika.model;

public class Poste {
    int id_poste;
    String nom;
    
    public Poste(int id_poste, String nom) {
        this.id_poste = id_poste;
        this.nom = nom;
    }
    public Poste() {
    }
    public int getId_poste() {
        return id_poste;
    }
    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
