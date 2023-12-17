package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bon_de_livraison {
    int id_bon_de_livraison;
    Date date;
    Date dateBDC;
    


    public Bon_de_livraison(int id_bon_de_livraison, Date date, Date dateBDC) {
        this.id_bon_de_livraison = id_bon_de_livraison;
        this.date = date;
        this.dateBDC = dateBDC;
    }



    public Bon_de_livraison() {
    }



    public Bon_de_livraison[] getAllBL(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()) {
                c = (new Connect()).connecter();
                coTest = true;
            }

            Statement st = c.createStatement();
            String sql = "select * from bon_de_livraison";
            List<Bon_de_livraison> allbl = new ArrayList<>();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allbl.add(new Bon_de_livraison(res.getInt(1),res.getDate(2),res.getDate(3)));
            }
            Bon_de_livraison[] all = new Bon_de_livraison[allbl.size()];
            return allbl.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }



    public int getId_bon_de_livraison() {
        return id_bon_de_livraison;
    }



    public void setId_bon_de_livraison(int id_bon_de_livraison) {
        this.id_bon_de_livraison = id_bon_de_livraison;
    }



    public Date getDate() {
        return date;
    }



    public void setDate(Date date) {
        this.date = date;
    }



    public Date getDateBDC() {
        return dateBDC;
    }



    public void setDateBDC(Date dateBDC) {
        this.dateBDC = dateBDC;
    }
}
