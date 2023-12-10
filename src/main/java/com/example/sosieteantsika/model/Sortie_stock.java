package com.example.sosieteantsika.model;

import java.sql.Date;

public class Sortie_stock {
    int id_sortie_stock;
    int id_article;
    double quantite_total;
    Date date_sortie;
    
    public Sortie_stock(int id_sortie_stock, int id_article, double quantite_total, Date date_sortie) {
        this.id_sortie_stock = id_sortie_stock;
        this.id_article = id_article;
        this.quantite_total = quantite_total;
        this.date_sortie = date_sortie;
    }
    public Sortie_stock() {
    }
    public int getId_sortie_stock() {
        return id_sortie_stock;
    }
    public void setId_sortie_stock(int id_sortie_stock) {
        this.id_sortie_stock = id_sortie_stock;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public double getQuantite_total() {
        return quantite_total;
    }
    public void setQuantite_total(double quantite_total) {
        this.quantite_total = quantite_total;
    }
    public Date getDate_sortie() {
        return date_sortie;
    }
    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }
    
}
