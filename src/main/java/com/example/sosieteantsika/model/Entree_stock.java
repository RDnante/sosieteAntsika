package com.example.sosieteantsika.model;

import java.sql.Date;

public class Entree_stock {
    int id_entree_stock;
    int id_article;
    double quantite;
    double prix_unitaire;
    Date date_entree;
    
    public Entree_stock(int id_entree_stock, int id_article, double quantite, double prix_unitaire, Date date_entree) {
        this.id_entree_stock = id_entree_stock;
        this.id_article = id_article;
        this.quantite = quantite;
        this.prix_unitaire = prix_unitaire;
        this.date_entree = date_entree;
    }
    public Entree_stock() {
    }
    public int getId_entree_stock() {
        return id_entree_stock;
    }
    public void setId_entree_stock(int id_entree_stock) {
        this.id_entree_stock = id_entree_stock;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public double getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    public Date getDate_entree() {
        return date_entree;
    }
    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }
    
}
