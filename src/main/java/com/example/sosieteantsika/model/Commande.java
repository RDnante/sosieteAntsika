package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Commande {
    int id_commande;
    String nom;
    Date date;
    boolean livraison_partielle;
    String mode_paiement;
    String categorie;
    String designation;
    Double quantite;
    Double tva;
    Double ttc;
    int id_service_besoin;

    public Commande(int id_commande, String nom, Date date, boolean livraison_partielle, String mode_paiement,
            String categorie, String designation, Double quantite, Double tva, Double ttc, int id_service_besoin) {
        this.id_commande = id_commande;
        this.nom = nom;
        this.date = date;
        this.livraison_partielle = livraison_partielle;
        this.mode_paiement = mode_paiement;
        this.categorie = categorie;
        this.designation = designation;
        this.quantite = quantite;
        this.tva = tva;
        this.ttc = ttc;
        this.id_service_besoin = id_service_besoin;
    }

    public Commande() {
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
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

    public boolean getLivraison_partielle() {
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

    public int getId_service_besoin() {
        return id_service_besoin;
    }

    public void setId_service_besoin(int id_service_besoin) {
        this.id_service_besoin = id_service_besoin;
    }

    public Commande[] getAllCommande(Connection c,int idService)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Service_besoin sb = new Service_besoin();
            Stock_fournisseur sf = new Stock_fournisseur();
            Categorie ca = new Categorie();
            Article a = new Article();
            Service_besoin[] allSb = sb.getAllServiceBesoin(c, idService);
            List<Commande> allC = new ArrayList<>();
            Fournisseur f = new Fournisseur();
            double quantite = 0;
            double tva = 0;
            double ttc = 0;
            for (int i = 0; i < allSb.length; i++) {
                sf = sf.moinsDisant(c, allSb[i].getId_article());
                f = f.getFournisseurById(c, sf.getId_fournisseur());
                a = a.getarticleById(c, allSb[i].getId_article());
                ca = ca.getCategorieById(c, a.getId_categorie());
                quantite = allSb[i].getQuantite();
                tva = sf.getPrix_unitaire();
                ttc = sf.getPrix_unitaire() + (sf.getPrix_unitaire()*20)/100;
                allC.add(new Commande(0,f.getNom(),allSb[i].getDate(),false,"Espece",ca.getNom(),a.getNom(),quantite,tva, ttc, allSb[i].getId_service_besoin()));
            }
            Commande[] all = new Commande[allC.size()];
            return allC.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Commande[] getAllCommandeByFournisseur(Connection c, int idService,int idFournisseur)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Fournisseur f = new Fournisseur();
            f = f.getFournisseurById(c, idFournisseur);
            Commande[] allC = this.getAllCommande(c, idService);
            List<Commande> all = new ArrayList<>();
            for (int i = 0; i < allC.length; i++) {
                if (allC[i].getNom().equals(f.getNom())) {
                    all.add(allC[i]);
                }
            }
            Commande[] allc = new Commande[all.size()];
            return all.toArray(allc);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Commande getCommandeById(Connection c, int idCommande)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Statement st = c.createStatement();
            String sql = "select * from commande where id_commande="+idCommande;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                return new Commande(res.getInt(1), res.getString(2), res.getDate(3), res.getBoolean(4), res.getString(5), res.getString(6), res.getString(7), res.getDouble(8), res.getDouble(9), res.getDouble(10), res.getInt(11));
            }
            return null;
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
