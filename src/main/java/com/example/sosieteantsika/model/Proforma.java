package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.sql.Statement;

import com.example.sosieteantsika.connection.Connect;

public class Proforma {
    Fournisseur id_fournisseur;
    Stock_fournisseur[] allArticleServiceBesoin;

    public Proforma(Fournisseur id_fournisseur, Stock_fournisseur[] allArticleServiceBesoin) {
        this.id_fournisseur = id_fournisseur;
        this.allArticleServiceBesoin = allArticleServiceBesoin;
    }
    public Proforma() {
    }
    public Fournisseur getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(Fournisseur id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public Stock_fournisseur[] getAllArticleServiceBesoin() {
        return allArticleServiceBesoin;
    }
    public void setAllArticleServiceBesoin(Stock_fournisseur[] allArticleServiceBesoin) {
        this.allArticleServiceBesoin = allArticleServiceBesoin;
    }

    public Proforma getProformaByFournisseur(Connection c,int idService,int idFournisseur)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;

            Statement st = c.createStatement();
            String sql = "insert into service_besoin(id_service,id_article,quantite,date,status) values("+idService+","+idArticle+","+quantite+",DEFAULT,0)";
            int exct = st.executeUpdate(sql);
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
