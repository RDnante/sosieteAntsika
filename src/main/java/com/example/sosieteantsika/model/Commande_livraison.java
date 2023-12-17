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

    public Commande_livraison getCommandeLivraisonByDate(Connection c, Date d, int idFournisseur)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Commande_livraison[] cl = this.getAllCommandeLivraison(c, idFournisseur);
            for (int i = 0; i < cl.length; i++) {
                if (cl[i].getDate_confirmation().equals(d)) {
                    return cl[i];
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

    public Commande[] getAllCommandeCommandeLivraisonByDate(Connection c, int idFournisseur, Date date)throws Exception{
        Boolean coTest = false;
        Commande_livraison[] cl = this.getAllCommandeLivraison(c, idFournisseur);
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Commande> allC = new ArrayList<>();
            Commande com = new Commande();
            for (int i = 0; i < cl.length; i++) {
                Commande co = com.getCommandeById(c, cl[i].getId_commande());
                if (co.getDate().equals(date))
                    allC.add(co);
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

    public void envoyerBonDeLivraison(Connection c, int idFournisseur)throws Exception{
        Boolean coTest = false;
        Commande_livraison[] cl = this.getAllCommandeLivraison(c, idFournisseur);
        Commande[] allC = this.getAllCommandeCommandeLivraison(c, idFournisseur);
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Statement st = c.createStatement();
            String sql1 = "insert into bon_de_livraison(date) values(DEFAULT)";
            int ok = st.executeUpdate(sql1);
            String sql2 = "select max(id_bon_de_livraison) from bon_de_livraison";
            ResultSet res = st.executeQuery(sql2);
            int idBonDeLivraison = 0;
            String sql3 = "";            
            String sql4 = "";
            Service_besoin sb = new Service_besoin();

            while (res.next()) {
                idBonDeLivraison = res.getInt(1);
            }
            for (int i = 0; i < cl.length; i++) {
                sql3 = "insert into bon_de_livraison_detail(id_bon_de_livraison,id_bon_de_commande) values("+idBonDeLivraison+","+cl[i].getId_bon_de_commande()+")";
                ok = st.executeUpdate(sql3);
            }

            for (int i = 0; i < allC.length; i++) {
                sb.updateStatus(c, 10 , allC[i].getId_service_besoin());
                sb = sb.verificationServiceAchat(c, allC[i].getId_service_besoin());
                if (sb!=null) {
                    sql4 = "insert into entree_stock(id_article,quantite,prix_unitaire,date_entree) values("+sb.getId_article()+","+allC[i].getQuantite()+","+allC[i].getTtc()+",CURRENT_DATE";
                    ok = st.executeUpdate(sql4);
                }
            }
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
