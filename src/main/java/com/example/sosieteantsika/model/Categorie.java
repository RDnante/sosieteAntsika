package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Categorie {
    int id_categorie;
    String nom;
    
    public Categorie(int id_categorie, String nom) {
        this.id_categorie = id_categorie;
        this.nom = nom;
    }
    public Categorie() {
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorieById(Connection c, int idCategorie)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Categorie> allC = new ArrayList<>();
            Statement st = c.createStatement();
            String sql = "select * from categorie where id_categorie="+idCategorie;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allC.add(new Categorie(res.getInt(1),res.getString(2)));
            }
            return allC.get(0);
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
