package com.example.sosieteantsika.model;

import java.sql.Date;

public class Bon_de_livraison {
    int id_bon_de_livraison;
    Date date;
    
    public Bon_de_livraison(int id_bon_de_livraison, Date date) {
        this.id_bon_de_livraison = id_bon_de_livraison;
        this.date = date;
    }
    public Bon_de_livraison() {
    }
    public int getId_bon_de_livraison() {
        return id_bon_de_livraison;
    }
    public void setId_bon_de_livraison(int id_bon_de_livraison) {
        this.id_bon_de_livraison = id_bon_de_livraison;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
