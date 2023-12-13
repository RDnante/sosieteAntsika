package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Fournisseur {
    Integer id_fournisseur;
    String nom;
    String mdp;

    public Fournisseur(Integer id_fournisseur, String nom, String mdp) {
        this.id_fournisseur = id_fournisseur;
        this.nom = nom;
        this.mdp = mdp;
    }

    public Fournisseur() {
    }

    public Integer getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Integer id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Fournisseur[] getAllFournisseur(Connection c) throws Exception {
        Boolean coTest = false;
        try {
            if (c == null || c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Statement st = c.createStatement();
            String sql = "select * from fournisseur";
            ResultSet res = st.executeQuery(sql);
            List<Fournisseur> allF = new ArrayList<>();
            while (res.next()) {
                allF.add(new Fournisseur(res.getInt(1), res.getString(2), res.getString(3)));
            }
            Fournisseur[] all = new Fournisseur[allF.size()];
            return allF.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        } finally {
            if (coTest == true)
                c.close();
        }
    }

    public Fournisseur getFournisseurById(Connection c, int id_fournisseur) throws Exception {
        Boolean coTest = false;
        try {
            if (c == null || c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Fournisseur[] allF = this.getAllFournisseur(c);
            for (int i = 0; i < allF.length; i++) {
                if (allF[i].getId_fournisseur() == id_fournisseur)
                    return allF[i];
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        } finally {
            if (coTest == true)
                c.close();
        }
    }
}
