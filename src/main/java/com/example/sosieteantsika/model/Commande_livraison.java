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

    public Commande_livraison[] getcl(Date d, Commande_livraison[] allcl){
        List<Commande_livraison> all = new ArrayList<>();
        for (int i = 0; i < allcl.length; i++) {
            if (allcl[i].getDate_confirmation().equals(d)){
                all.add(allcl[i]);
            }
        }
        Commande_livraison[] a = new Commande_livraison[all.size()];
        return all.toArray(a);
    }

    public Commande[] getc(Date d, Commande[] allc){
        List<Commande> all = new ArrayList<>();
        for (int i = 0; i < allc.length; i++) {
            if (allc[i].getDate().equals(d)){
                all.add(allc[i]);
            }
        }
        Commande[] a = new Commande[all.size()];
        return all.toArray(a);
    }



    public void envoyerBonDeLivraison(Connection c, int idFournisseur,Date d)throws Exception{
        Boolean coTest = false;
        Commande_livraison[] cl = getcl(d,this.getAllCommandeLivraison(c, idFournisseur));
        Commande[] allC =getc(d,this.getAllCommandeCommandeLivraison(c, idFournisseur));
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Statement st = c.createStatement();
            String sql1 = "insert into bon_de_livraison(date,dateBDC) values(DEFAULT,'"+cl[0].getDate_confirmation()+"')";
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

    public Commande_livraison[] verification(Connection c, Commande_livraison[] allcl)throws Exception{
        try{
            Bon_de_livraison[] all = (new Bon_de_livraison()).getAllBL(c);
            List<Commande_livraison> cl = new ArrayList<>();
            int test =0;
            for (int i = 0; i < allcl.length; i++) {
                test =0;
                for (int j = 0; j < all.length; j++) {
                    if (allcl[i].getDate_confirmation().equals(all[j].getDateBDC())){
                        System.out.println("ato");
                        test=1;
                    }
                }
                if (test==0){
                    cl.add(allcl[i]);
                }
            }
            Commande_livraison[] rep = new Commande_livraison[cl.size()];
            return cl.toArray(rep);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
