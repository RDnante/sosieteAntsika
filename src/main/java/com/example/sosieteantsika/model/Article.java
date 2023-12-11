package com.example.sosieteantsika.model;

public class Article {
    Integer id_article;
    Integer id_categorie;
    String nom;
    Integer id_unite;
    Integer id_type_gestion;

    public Article() {
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Integer id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId_unite() {
        return id_unite;
    }

    public void setId_unite(Integer id_unite) {
        this.id_unite = id_unite;
    }

    public Integer getId_type_gestion() {
        return id_type_gestion;
    }

    public void setId_type_gestion(Integer id_type_gestion) {
        this.id_type_gestion = id_type_gestion;
    }
}
