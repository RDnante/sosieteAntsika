package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Etat_stock {
    String nom_article;
    Double quantite;
    Double prix_unitaire;
    Double prix_total;

    public Etat_stock() {
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(Double prix_total) {
        this.prix_total = prix_total;
    }

    public double quantite_article(Connection connection, int idarticle) throws Exception {
        double valiny = 0.0;
        boolean verif = false;
        try {
            if (connection.isClosed() || connection == null) {
                verif = true;
                connection = new Connect().connecter();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select quantite from etatstock where id_article = "+idarticle);
            resultSet.next();
            valiny = resultSet.getDouble("quantite");

        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("erreur quantite article");
        }
        finally {
            if (verif == true) {
                connection.close();
            }
        }
        return valiny;
    }

    public double get_prix_unitaire(Connection connection,int id_article) throws Exception {
        double valiny = 0.0;
        boolean verif = false;
        try {
            if (connection == null || connection.isClosed()) {
                verif = true;
                connection = new Connect().connecter();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select prix_unitaire from entree_stock order by prix_unitaire");
            resultSet.next();
            valiny = resultSet.getDouble("prix_unitaire");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (verif == true) {
                connection.close();
            }
        }

        return valiny;
    }

    public List<Etat_stock> getAllEtatstock(Connection connection) throws Exception {
        List<Etat_stock> valiny = new ArrayList<>();
        boolean verif = false;
        try {
            if (connection == null || connection.isClosed()) {
                verif = true;
                connection = new Connect().connecter();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from etatstock");
            while (resultSet.next()) {
                Etat_stock v = new Etat_stock();
                int id_article = resultSet.getInt("id_article");
                Article a = new Article().getarticleById(connection,id_article);
                v.setNom_article(a.getNom());
                v.setQuantite(resultSet.getDouble("quantite"));
                v.setPrix_unitaire(this.get_prix_unitaire(connection,id_article));
                v.setPrix_total(v.getQuantite() * v.getPrix_unitaire() * 1.4);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        finally {
            if (verif == true){
                connection.close();
            }
        }

        return valiny;
    }
}
