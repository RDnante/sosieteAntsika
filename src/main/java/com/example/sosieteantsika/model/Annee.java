package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Annee {
    int id_annee;
    int id_immobilisation;
    int annee;
    public Annee(int id_annee, int id_immobilisation, int annee) {
        this.id_annee = id_annee;
        this.id_immobilisation = id_immobilisation;
        this.annee = annee;
    }
    public Annee() {
    }
    public int getId_annee() {
        return id_annee;
    }
    public void setId_annee(int id_annee) {
        this.id_annee = id_annee;
    }
    public int getId_immobilisation() {
        return id_immobilisation;
    }
    public void setId_immobilisation(int id_immobilisation) {
        this.id_immobilisation = id_immobilisation;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Annee[] getAll(Connection c)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Statement st = c.createStatement();
            String sql = "select * from Annee";
            ResultSet res = st.executeQuery(sql);
            List<Annee> all = new ArrayList<>();
            while (res.next()) {
                all.add(new Annee(res.getInt(1), res.getInt(2),res.getInt(3)));
            }
            Annee[] rep = new Annee[all.size()];
            return all.toArray(rep);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        } finally{
            if (testco==true) {
                c.close();
            }
        }
    }

    public Annee get(Connection c, int id)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Annee[] all = this.getAll(c);
            for (int i = 0; i < all.length; i++) {
                if (all[i].getId_immobilisation()==id) {
                    return all[i];
                }
            }
            return null;
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        } finally{
            if (testco==true) {
                c.close();
            }
        }
    }
    
}
