package com.example.sosieteantsika.model;

public class Mouvement_sortie {
    int id_mouvement_sortie;
    int id_sortie_stock;
    int id_entree_stock;
    int id_article;
    double quantite;
    double prix_unitaire;
    
    public Mouvement_sortie(int id_mouvement_sortie, int id_sortie_stock, int id_entree_stock, int id_article,
            double quantite, double prix_unitaire) {
        this.id_mouvement_sortie = id_mouvement_sortie;
        this.id_sortie_stock = id_sortie_stock;
        this.id_entree_stock = id_entree_stock;
        this.id_article = id_article;
        this.quantite = quantite;
        this.prix_unitaire = prix_unitaire;
    }
    public Mouvement_sortie() {
    }
    public int getId_mouvement_sortie() {
        return id_mouvement_sortie;
    }
    public void setId_mouvement_sortie(int id_mouvement_sortie) {
        this.id_mouvement_sortie = id_mouvement_sortie;
    }
    public int getId_sortie_stock() {
        return id_sortie_stock;
    }
    public void setId_sortie_stock(int id_sortie_stock) {
        this.id_sortie_stock = id_sortie_stock;
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
}
