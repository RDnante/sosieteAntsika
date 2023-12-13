package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class Article {
    Integer id_article;
    Integer id_categorie;
    String nom;
    Integer id_unite;
    Integer id_type_gestion;

    public Article(Integer id_article, Integer id_categorie, String nom, Integer id_unite, Integer id_type_gestion) {
        this.id_article = id_article;
        this.id_categorie = id_categorie;
        this.nom = nom;
        this.id_unite = id_unite;
        this.id_type_gestion = id_type_gestion;
    }

    public Article() {
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Integer id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId_unite() {
        return id_unite;
    }

    public void setId_unite(Integer id_unite) {
        this.id_unite = id_unite;
    }

    public Integer getId_type_gestion() {
        return id_type_gestion;
    }

    public void setId_type_gestion(Integer id_type_gestion) {
        this.id_type_gestion = id_type_gestion;
    }

    public List<Article> getAllArticle(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Article> allA = new ArrayList<>();
            Statement st = c.createStatement();
            String sql = "select * from article";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allA.add(new Article(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4),res.getInt(5)));
            }
            return allA;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Article getarticleById(Connection c,int idArticle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Article> allA = this.getAllArticle(c);
            for (Article article : allA) {
                if (article.getId_article()==idArticle) {
                    return article;
                }
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
