package com.example.sosieteantsika.model;

import java.sql.Date;

public class Bon_de_commande {
    Integer id_bon_de_commande;
    Integer id_fournisseur;
    Date date_confirmation;

    public Bon_de_commande() {
    }

    public Integer getId_bon_de_commande() {
        return id_bon_de_commande;
    }

    public void setId_bon_de_commande(Integer id_bon_de_commande) {
        this.id_bon_de_commande = id_bon_de_commande;
    }

    public Integer getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Integer id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public Date getDate_confirmation() {
        return date_confirmation;
    }

    public void setDate_confirmation(Date date_confirmation) {
        this.date_confirmation = date_confirmation;
    }
}
