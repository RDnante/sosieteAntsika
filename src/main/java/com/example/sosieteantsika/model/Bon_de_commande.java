package com.example.sosieteantsika.model;

import com.example.sosieteantsika.connection.Connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bon_de_commande {
    Integer id_bon_de_commande;
    Integer id_fournisseur;
    Date date_confirmation;
    int status;

    public Bon_de_commande(Integer id_bon_de_commande, Integer id_fournisseur, Date date_confirmation, int status) {
        this.id_bon_de_commande = id_bon_de_commande;
        this.id_fournisseur = id_fournisseur;
        this.date_confirmation = date_confirmation;
        this.status = status;
    }

    public Bon_de_commande() {
    }

    public Integer getId_bon_de_commande() {
        return id_bon_de_commande;
    }

    public void setId_bon_de_commande(Integer id_bon_de_commande) {
        this.id_bon_de_commande = id_bon_de_commande;
    }

    public Integer getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Integer id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public Date getDate_confirmation() {
        return date_confirmation;
    }

    public void setDate_confirmation(Date date_confirmation) {
        this.date_confirmation = date_confirmation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public void confirmationBonDeCommande(Connection c, int idService, int idFournisseur)throws Exception{
        Commande[] allC = (new Commande()).getAllCommandeByFournisseur(c, idService, idFournisseur);
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()) {
                c = (new Connect()).connecter();
                coTest = true;
            }
            Statement st = c.createStatement();
            String sql1 = "insert into bon_de_commande(id_fournisseur,date_confirmation,status) values("+idFournisseur+",DEFAULT,0)";
            int ok = st.executeUpdate(sql1);

            String sql2 = "select max(id_bon_de_commande) from bon_de_commande";
            ResultSet res = st.executeQuery(sql2);
            int idBonDeCommande = 0;
            while (res.next()){
                idBonDeCommande = res.getInt(1);
            }
                
            int idCommande = 0;

            String sql3 = "";            
            String sql4 = "";            
            String sql5 = "";            
            String sql6 = "";


            for (int i = 0; i < allC.length; i++) {
                sql3 = "insert into commande(nom,date,livraison_partielle,mode_paiement,categorie,designation,quantite,tva,ttc,id_service_besoin) values('"+allC[i].getNom()+"','"+allC[i].getDate()+"','"+allC[i].getLivraison_partielle()+"','"+allC[i].getMode_paiement()+"','"+allC[i].getCategorie()+"','"+allC[i].getDesignation()+"',"+allC[i].getQuantite()+","+allC[i].getTva()+","+allC[i].getTtc()+","+allC[i].getId_service_besoin()+")";
                ok = st.executeUpdate(sql3);
                sql4 = "select max(id_commande) from commande";
                res = st.executeQuery(sql4);
                while (res.next()) {
                    idCommande = res.getInt(1);
                }
                sql5 = "insert into bon_de_commande_commandes(id_bon_de_commande,id_commande) values("+idBonDeCommande+","+idCommande+")";
                ok = st.executeUpdate(sql5); 
                sql6 = "update service_besoin set status = 5 where id_service_besoin = "+allC[i].getId_service_besoin();
                ok = st.executeUpdate(sql6);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }



    
}
