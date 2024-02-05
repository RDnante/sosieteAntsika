package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Coefficient {
    int id_coefficient;
    int debut;
    int fin;
    double valeur;
    public Coefficient() {
    }
    public Coefficient(int id_coefficient, int debut, int fin, double valeur) {
        this.id_coefficient = id_coefficient;
        this.debut = debut;
        this.fin = fin;
        this.valeur = valeur;
    }
    public int getId_coefficient() {
        return id_coefficient;
    }
    public void setId_coefficient(int id_coefficient) {
        this.id_coefficient = id_coefficient;
    }
    public int getDebut() {
        return debut;
    }
    public void setDebut(int debut) {
        this.debut = debut;
    }
    public int getFin() {
        return fin;
    }
    public void setFin(int fin) {
        this.fin = fin;
    }
    public double getValeur() {
        return valeur;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    public Coefficient[] getAll(Connection c)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Statement st = c.createStatement();
            String sql = "select * from coefficient";
            ResultSet res = st.executeQuery(sql);
            List<Coefficient> all = new ArrayList<>();
            while (res.next()) {
                all.add(new Coefficient(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4)));
            }
            Coefficient[] rep = new Coefficient[all.size()];
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

    public Coefficient get(Connection c, int id)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Coefficient[] all = this.getAll(c);
            for (int i = 0; i < all.length; i++) {
                if (all[i].getId_coefficient()==id) {
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

    public double getCoef(Connection c, int annee)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Coefficient[] all = this.getAll(c);
            for (int i = 0; i < all.length; i++) {
                if (all[i].getDebut()<= annee && all[i].getFin()>= annee) {
                    return all[i].getValeur();
                }
            }
            return 0;
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
