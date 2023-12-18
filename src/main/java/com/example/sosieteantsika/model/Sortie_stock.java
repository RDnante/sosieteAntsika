package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sortie_stock {
    int id_sortie_stock;
    int id_article;
    double quantite_total;
    Date date_sortie;
    
    public Sortie_stock(int id_sortie_stock, int id_article, double quantite_total, Date date_sortie) {
        this.id_sortie_stock = id_sortie_stock;
        this.id_article = id_article;
        this.quantite_total = quantite_total;
        this.date_sortie = date_sortie;
    }
    public Sortie_stock() {
    }
    public int getId_sortie_stock() {
        return id_sortie_stock;
    }
    public void setId_sortie_stock(int id_sortie_stock) {
        this.id_sortie_stock = id_sortie_stock;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public double getQuantite_total() {
        return quantite_total;
    }
    public void setQuantite_total(double quantite_total) {
        this.quantite_total = quantite_total;
    }
    public Date getDate_sortie() {
        return date_sortie;
    }
    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public void inserer_sortie(Connection connection, int id_article, double quantite_total, String date) throws Exception {
        boolean verif = false;
        double sortie = this.sortieQuantitebyArticle(connection,id_article) + quantite_total;
        double entrer = new Entree_stock().getQuantiteByArticle(connection,id_article);
        if (entrer - sortie < 0) {
            throw new Exception("quantite insuffisant");
        }
        try {
            if (connection == null || connection.isClosed()) {
                connection = new Connect().connecter();
                verif = true;
            }
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sortie_stock values (default,"+id_article+","+quantite_total+",'"+date+"')");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("erreur insertion sortie stock");
        }finally {
            if (verif == true) {
                connection.close();
            }
        }
    }

    public Double sortieQuantitebyArticle(Connection connection,int id_article) throws Exception {
        boolean verif = false;
        Double valiny = 0.0;

        try {
            if (connection == null || connection.isClosed()) {
                verif = true;
                connection = new Connect().connecter();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select sum(quantite_total) as sum from sortie_stock where id_article = "+id_article);
            resultSet.next();

            valiny = resultSet.getDouble("sum");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return valiny;
    }
}
