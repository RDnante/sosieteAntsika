package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Stock_fournisseur {
    Integer id_stock_fournisseur;
    Integer id_fournisseur;
    Integer id_article;
    Double quantite;
    Double prix_unitaire;

    public Stock_fournisseur(Integer id_stock_fournisseur, Integer id_fournisseur, Integer id_article, Double quantite,
            Double prix_unitaire) {
        this.id_stock_fournisseur = id_stock_fournisseur;
        this.id_fournisseur = id_fournisseur;
        this.id_article = id_article;
        this.quantite = quantite;
        this.prix_unitaire = prix_unitaire;
    }
    public Stock_fournisseur() {
    }
    public Integer getId_stock_fournisseur() {
        return id_stock_fournisseur;
    }

    public void setId_stock_fournisseur(Integer id_stock_fournisseur) {
        this.id_stock_fournisseur = id_stock_fournisseur;
    }

    public Integer getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Integer id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
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

    public Stock_fournisseur[] getAllStockFournisseurByArticle(Connection c, int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;

            Statement st = c.createStatement();
            String sql = "select * from stock_fournisseur";
            ResultSet res = st.executeQuery(sql);
            List<Stock_fournisseur> allSf = new ArrayList<>();
            while (res.next()) {
                allSf.add(new Stock_fournisseur(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDouble(5)));
            }
            int exct = st.executeUpdate(sql);
            Stock_fournisseur[] all = new Stock_fournisseur[allSf.size()];
            return allSf.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public double getSommeQuantiteStockFournisseur(Connection c, int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;

            Stock_fournisseur[] allSf = this.getAllStockFournisseurByArticle(c, idArticle);
            double somme = allSf[0].getQuantite();
            for (int i = 1; i < allSf.length; i++) {
                somme = somme + allSf[i].getQuantite();
            }
            return somme;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Boolean verificationStockFournisseur(Connection c, int idArticle, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            double sommeQuantiteStockFourn = this.getSommeQuantiteStockFournisseur(c, idArticle);
            if (sommeQuantiteStockFourn<quantite) {
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

}
