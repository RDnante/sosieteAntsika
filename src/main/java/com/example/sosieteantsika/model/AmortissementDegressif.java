package com.example.sosieteantsika.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;

public class AmortissementDegressif {
    int annee;
    double baseamortissement;
    int tauxdegressif;
    int tauxlineaire;
    double amortissement;
    double valeurnette;
    public AmortissementDegressif(int annee, double baseamortissement, int tauxdegressif, int tauxlineaire,
            double amortissement, double valeurnette) {
        this.annee = annee;
        this.baseamortissement = baseamortissement;
        this.tauxdegressif = tauxdegressif;
        this.tauxlineaire = tauxlineaire;
        this.amortissement = amortissement;
        this.valeurnette = valeurnette;
    }
    public AmortissementDegressif() {
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public double getBaseamortissement() {
        return baseamortissement;
    }
    public void setBaseamortissement(double baseamortissement) {
        this.baseamortissement = baseamortissement;
    }
    public int getTauxdegressif() {
        return tauxdegressif;
    }
    public void setTauxdegressif(int tauxdegressif) {
        this.tauxdegressif = tauxdegressif;
    }
    public int getTauxlineaire() {
        return tauxlineaire;
    }
    public void setTauxlineaire(int tauxlineaire) {
        this.tauxlineaire = tauxlineaire;
    }
    public double getAmortissement() {
        return amortissement;
    }
    public void setAmortissement(double amortissement) {
        this.amortissement = amortissement;
    }
    public double getValeurnette() {
        return valeurnette;
    }
    public void setValeurnette(double valeurnette) {
        this.valeurnette = valeurnette;
    }
    
    
    

    public HashMap<String,Object> getAmortissementDegressif(Connection c, int id)throws Exception{
         Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;
            }
            // Immobilisation[] all = (new Immobilisation()).getDegressif(c);
            HashMap<String,Object> all = new HashMap<>();
            Immobilisation one = (new Immobilisation()).get(c, id);
            List<AmortissementDegressif> allA = new ArrayList<>();
            Annee a = (new Annee()).get(c, one.getId_immobilisation());
            double coef = (new Coefficient()).getCoef(c, a.getAnnee());
            double base = one.getPrix();
            int tauxlineaire = (100/a.getAnnee());
            int tauxdegressif = (int)(tauxlineaire*coef);
            System.out.println(a.getAnnee());

           for (int i = 0; i < a.getAnnee(); i++) {

                   tauxlineaire = ((100)/(a.getAnnee()-i));

                int tx = tauxdegressif;
                if (tauxdegressif<tauxlineaire) {
                    tx = tauxlineaire;
                }
                double amortissement =  (base*tx)/100;
//               System.out.println("jsk"+amortissement);
               System.out.println(tauxdegressif);
                double valeurnette = base - amortissement;
                allA.add(new AmortissementDegressif(one.getDate().getYear()+i, base, tauxdegressif, tauxlineaire, amortissement, valeurnette));
                base = valeurnette;
//               System.out.println(base);
            }
            AmortissementDegressif[] al = new AmortissementDegressif[allA.size()];
            all.put("tableau", allA.toArray(al));
            all.put("immobilisation", one);
            all.put("annee",a);
            all.put("coefficient",coef);
            all.put("taux",tauxdegressif);
            return all;
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
