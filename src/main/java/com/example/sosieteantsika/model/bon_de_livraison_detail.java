package com.example.sosieteantsika.model;

public class bon_de_livraison_detail {
    int id_bon_de_livraison_detail;
    int id_bon_de_livraison;
    int id_bon_de_commande;
    
    public bon_de_livraison_detail(int id_bon_de_livraison_detail, int id_bon_de_livraison, int id_bon_de_commande) {
        this.id_bon_de_livraison_detail = id_bon_de_livraison_detail;
        this.id_bon_de_livraison = id_bon_de_livraison;
        this.id_bon_de_commande = id_bon_de_commande;
    }
    public bon_de_livraison_detail() {
    }
    public int getId_bon_de_livraison_detail() {
        return id_bon_de_livraison_detail;
    }
    public void setId_bon_de_livraison_detail(int id_bon_de_livraison_detail) {
        this.id_bon_de_livraison_detail = id_bon_de_livraison_detail;
    }
    public int getId_bon_de_livraison() {
        return id_bon_de_livraison;
    }
    public void setId_bon_de_livraison(int id_bon_de_livraison) {
        this.id_bon_de_livraison = id_bon_de_livraison;
    }
    public int getId_bon_de_commande() {
        return id_bon_de_commande;
    }
    public void setId_bon_de_commande(int id_bon_de_commande) {
        this.id_bon_de_commande = id_bon_de_commande;
    }
}
