package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Immobilisation {
    int id_immobilisation;
    Date date;
    double prix;
    String compte_comptable;
    String numero;
    String type;
    String marque;
    String model;
    String numero_serie;
    String description;
    double taux_amortissement;
    Boolean neuf;
    Boolean utilisable;
    String methode_ammortissement;
    int id_lieu;
    public Immobilisation(int id_immobilisation, Date date, double prix, String compte_comptable, String numero,
            String type, String marque, String model, String numero_serie, String description,
            double taux_amortissement, Boolean neuf, Boolean utilisable, String methode_ammortissement, int id_lieu) {
        this.id_immobilisation = id_immobilisation;
        this.date = date;
        this.prix = prix;
        this.compte_comptable = compte_comptable;
        this.numero = numero;
        this.type = type;
        this.marque = marque;
        this.model = model;
        this.numero_serie = numero_serie;
        this.description = description;
        this.taux_amortissement = taux_amortissement;
        this.neuf = neuf;
        this.utilisable = utilisable;
        this.methode_ammortissement = methode_ammortissement;
        this.id_lieu = id_lieu;
    }
    public Immobilisation() {
	}
	public int getId_immobilisation() {
        return id_immobilisation;
    }
    public void setId_immobilisation(int id_immobilisation) {
        this.id_immobilisation = id_immobilisation;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getCompte_comptable() {
        return compte_comptable;
    }
    public void setCompte_comptable(String compte_comptable) {
        this.compte_comptable = compte_comptable;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getNumero_serie() {
        return numero_serie;
    }
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getTaux_amortissement() {
        return taux_amortissement;
    }
    public void setTaux_amortissement(double taux_amortissement) {
        this.taux_amortissement = taux_amortissement;
    }
    public Boolean getNeuf() {
        return neuf;
    }
    public void setNeuf(Boolean neuf) {
        this.neuf = neuf;
    }
    public Boolean getUtilisable() {
        return utilisable;
    }
    public void setUtilisable(Boolean utilisable) {
        this.utilisable = utilisable;
    }
    public String getMethode_ammortissement() {
        return methode_ammortissement;
    }
    public void setMethode_ammortissement(String methode_ammortissement) {
        this.methode_ammortissement = methode_ammortissement;
    }
    public int getId_lieu() {
        return id_lieu;
    }
    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public Immobilisation[] getAll(Connection c)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Statement st = c.createStatement();
            String sql = "select * from immobilisation";
            ResultSet res = st.executeQuery(sql);
            List<Immobilisation> all = new ArrayList<>();
            while (res.next()) {
                all.add(new Immobilisation(res.getInt(1), res.getDate(2), res.getDouble(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9),res.getString(10), res.getDouble(11), res.getBoolean(12), res.getBoolean(13), res.getString(14), res.getInt(15)));
            }
            Immobilisation[] rep = new Immobilisation[all.size()];
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

    public Immobilisation get(Connection c, int id)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Immobilisation[] all = this.getAll(c);
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

    public Immobilisation[] getLineaire(Connection c)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Immobilisation[] all = this.getAll(c);
            List<Immobilisation> allI = new ArrayList<>();
            for (int i = 0; i < all.length; i++) {
                if (all[i].getMethode_ammortissement().equals("lineaire")) {
                    allI.add(all[i]);
                }
            }
            Immobilisation[] rep = new Immobilisation[allI.size()];
            return allI.toArray(rep);
        } catch (Exception e) {
            throw e;
            // TODO: handle exception
        } finally{
            if (testco==true) {
                c.close();
            }
        }
    }

    public Immobilisation[] getDegressif(Connection c)throws Exception{
        Boolean testco = false;
        try {
            if (c==null||c.isClosed()) {
                Connect co = new Connect();
                c = co.connecter();
                testco = true;
            }
            Immobilisation[] all = this.getAll(c);
            List<Immobilisation> allI = new ArrayList<>();
            for (int i = 0; i < all.length; i++) {
                if (all[i].getMethode_ammortissement().equals("degressif")) {
                    allI.add(all[i]);
                }
            }
            Immobilisation[] rep = new Immobilisation[allI.size()];
            return allI.toArray(rep);
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
