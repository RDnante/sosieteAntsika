package com.example.sosieteantsika;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande_livraison;
import com.example.sosieteantsika.model.Service_besoin;
import com.example.sosieteantsika.model.Stock_fournisseur;

import java.sql.Connection;

public class TestTatiana {
    public static void main(String[] args) throws Exception{
        Service_besoin sb = new Service_besoin();
        //sb.insertServiceBesoin(null, 1, 2, 50);
        //sb.insertServiceBesoin(null, 2, 2, 5);
        Connect co = new Connect();
        Connection c = co.connecter();
        // Service_besoin[] allSbFiltrer = sb.getAllServiceBesoinFiltre(c,1);
        // Service_besoin[] allSb = sb.getAllServiceBesoin(c,1);
        // for (int i = 0; i < allSb.length; i++) {
        //     System.out.println(allSb[i].getId_article()+" qu = "+allSb[i].getQuantite());
        // }
        // Stock_fournisseur sf = new Stock_fournisseur();

        // Stock_fournisseur[] allSf = sf.getAllStockDispo(c, 2, allSbFiltrer);

        // for (int i = 0; i < allSf.length; i++) {
        //     System.out.println(allSf[i].getId_article() +" q = "+allSf[i].getQuantite()+" pr = "+allSf[i].getPrix_unitaire());
        // }

        Commande_livraison[] all = (new Commande_livraison()).getAllCommandeLivraison(c, 1);
        System.out.println(all[0].getDate_confirmation());
    }
}
