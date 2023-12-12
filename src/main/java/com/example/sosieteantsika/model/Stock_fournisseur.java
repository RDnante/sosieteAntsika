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

    public Stock_fournisseur[] getAllStockFournisseurByArticle(Connection c, int idFournisseur,int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Statement st = c.createStatement();
            String sql = "select * from stock_fournisseur where id_article = "+idArticle+" and id_fournisseur ="+idFournisseur;
            ResultSet res = st.executeQuery(sql);
            List<Stock_fournisseur> allSf = new ArrayList<>();
            while (res.next()) {
                allSf.add(new Stock_fournisseur(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDouble(5)));
            }
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

    public double getSommeQuantiteStockFournisseur(Connection c, int idFournisseur,int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}

            Stock_fournisseur[] allSf = this.getAllStockFournisseurByArticle(c,idFournisseur, idArticle);
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

    public Boolean verificationStockFournisseur(Connection c, int idfournisseur,int idArticle, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            double sommeQuantiteStockFourn = this.getSommeQuantiteStockFournisseur(c,idfournisseur, idArticle);
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

    public Stock_fournisseur getStockFByArticle(Connection c, int idFournisseur,int idArticle, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Stock_fournisseur[] allSf = this.getAllStockFournisseurByArticle(c,idFournisseur,idArticle);
            if (allSf.length!=0){
                Stock_fournisseur sf = allSf[0];
                if (sf.getQuantite()>=quantite) {
                    return sf;
                }else{
                    return null;
                }
            }else{
                return null;
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

    public Stock_fournisseur[] getAllStockDispo(Connection c, int idFournisseur, Service_besoin[] allServiceBesoinFiltrer)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Stock_fournisseur> allSf = new ArrayList<>();
            for (int i = 0; i < allServiceBesoinFiltrer.length; i++) {
                Stock_fournisseur sf = this.getStockFByArticle(c, idFournisseur,allServiceBesoinFiltrer[i].getId_article(), allServiceBesoinFiltrer[i].getQuantite());
                if (sf!=null) {
                    allSf.add(sf);
                }
            }
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

    public Stock_fournisseur[] getAllStockByArticle(Connection c, int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Stock_fournisseur> allF = new ArrayList<>();
            Statement st = c.createStatement();
            String sql = "select * from stock_fournisseur where id_article = "+idArticle;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allF.add(new Stock_fournisseur(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getDouble(5)));
            }
            Stock_fournisseur[] all = new Stock_fournisseur[allF.size()];
            return allF.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Stock_fournisseur moinsDisant(Connection c, int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Stock_fournisseur[] allF = this.getAllStockByArticle(c, idArticle);
            Stock_fournisseur sf = allF[0];
            for (int i = 1; i < allF.length; i++) {
                if (allF[i].getPrix_unitaire()<sf.getPrix_unitaire()) {
                    sf = allF[i];
                }
            }
            return sf;
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
