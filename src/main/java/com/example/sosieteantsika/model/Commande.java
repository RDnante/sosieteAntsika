package com.example.sosieteantsika.model;

import java.util.Date;

public class Commande {
    Integer id_commande;
    String nom;
    Date date;
    boolean livraison_partielle;
    String mode_paiement;
    String categorie;
    String designation;
    Double quantite;
    Double tva;
    Double ttc;
    Integer id_service_besoin;

    public Commande() {
    }

    public Integer getId_commande() {
        return id_commande;
    }

    public void setId_commande(Integer id_commande) {
        this.id_commande = id_commande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isLivraison_partielle() {
        return livraison_partielle;
    }

    public void setLivraison_partielle(boolean livraison_partielle) {
        this.livraison_partielle = livraison_partielle;
    }

    public String getMode_paiement() {
        return mode_paiement;
    }

    public void setMode_paiement(String mode_paiement) {
        this.mode_paiement = mode_paiement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    public Double getTtc() {
        return ttc;
    }

    public void setTtc(Double ttc) {
        this.ttc = ttc;
    }

    public Integer getId_service_besoin() {
        return id_service_besoin;
    }

    public void setId_service_besoin(Integer id_service_besoin) {
        this.id_service_besoin = id_service_besoin;
    }
}
