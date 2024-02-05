package com.example.sosieteantsika.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AmortissementLineaire {
    Double prix;
    Double taux;
    Double am_debut_periode;

    Double am_fin_periode;
    Double dotation;
    Double valeur_net_comptable;

    public AmortissementLineaire() {
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Double getAm_debut_periode() {
        return am_debut_periode;
    }

    public void setAm_debut_periode(Double am_debut_periode) {
        this.am_debut_periode = am_debut_periode;
    }

    public Double getAm_fin_periode() {
        return am_fin_periode;
    }

    public void setAm_fin_periode(Double am_fin_periode) {
        this.am_fin_periode = am_fin_periode;
    }

    public Double getDotation() {
        return dotation;
    }

    public void setDotation(Double dotation) {
        this.dotation = dotation;
    }

    public Double getValeur_net_comptable() {
        return valeur_net_comptable;
    }

    public void setValeur_net_comptable(Double valeur_net_comptable) {
        this.valeur_net_comptable = valeur_net_comptable;
    }

    public List<AmortissementLineaire> calcule_lineaire(Connection connection, Integer id_immobilisation) throws Exception {
        List<AmortissementLineaire> valiny = new ArrayList<>();
        Immobilisation im = new Immobilisation();
        Immobilisation immob = im.get(connection,id_immobilisation);
        double dota = immob.getPrix() / this.annee(immob.getTaux_amortissement());
//        System.out.println(this.annee(immob.getTaux_amortissement()));

        double am_debut_periode = 0.0;
        double am_fin_periode = am_debut_periode + dota;
        double valeur_net = immob.getPrix() - am_fin_periode;

        for (int i = 0; i < this.annee(immob.getTaux_amortissement()); i++) {
            AmortissementLineaire vaovao = new AmortissementLineaire();
//            vaovao = immob;
            vaovao.setPrix(immob.getPrix());
            vaovao.setTaux(immob.getTaux_amortissement());

            vaovao.setAm_debut_periode(am_debut_periode);
            vaovao.setDotation(dota);
            vaovao.setAm_fin_periode(am_fin_periode);
            vaovao.setValeur_net_comptable(valeur_net);
            valiny.add(vaovao);

            am_debut_periode = am_fin_periode;
            System.out.println("debut "+vaovao.getAm_debut_periode());
            am_fin_periode = am_fin_periode + dota;
            System.out.println("fin ");
            valeur_net = immob.getPrix() - am_fin_periode;
            System.out.println("net ");
        }

        return valiny;
    }

    public int annee(double taux) {
        int valiny = 0;
        double plus = taux;

        while (taux <= 100) {
            valiny++;
//            System.out.println("taux" +taux);
            taux += plus;
        }

        return valiny;
    }
}
