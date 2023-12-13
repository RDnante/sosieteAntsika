package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Commande_livraison {
    int id_bon_de_commande;
    Date date_confirmation;
    int id_fournisseur;
    int id_commande;

    public Commande_livraison(int id_bon_de_commande, Date date_confirmation, int id_fournisseur, int id_commande) {
        this.id_bon_de_commande = id_bon_de_commande;
        this.date_confirmation = date_confirmation;
        this.id_fournisseur = id_fournisseur;
        this.id_commande = id_commande;
    }
    public Commande_livraison() {
    }
    public int getId_bon_de_commande() {
        return id_bon_de_commande;
    }
    public void setId_bon_de_commande(int id_bon_de_commande) {
        this.id_bon_de_commande = id_bon_de_commande;
    }
    public Date getDate_confirmation() {
        return date_confirmation;
    }
    public void setDate_confirmation(Date date_confirmation) {
        this.date_confirmation = date_confirmation;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public int getId_commande() {
        return id_commande;
    }
    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Commande_livraison[] getAllCommandeLivraison(Connection c, int idFournisseur)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Statement st = c.createStatement();
            String sql = "select * from commande_livraison where id_fournisseur="+idFournisseur;
            ResultSet rs = st.executeQuery(sql);
            List<Commande_livraison> allCL = new ArrayList<>();
            while (rs.next()) {
                allCL.add(new Commande_livraison(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4)));
            }
            Commande_livraison[] all = new Commande_livraison[allCL.size()];
            return allCL.toArray(all); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Commande[] getAllCommandeCommandeLivraison(Connection c, int idFournisseur)throws Exception{
        Boolean coTest = false;
        Commande_livraison[] cl = this.getAllCommandeLivraison(c, idFournisseur);
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Commande> allC = new ArrayList<>();
            Commande com = new Commande();
            for (int i = 0; i < cl.length; i++) {
                allC.add(com.getCommandeById(c, cl[i].getId_commande()));
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

}
