package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande;
import com.example.sosieteantsika.model.Commande_livraison;
import com.example.sosieteantsika.model.Fournisseur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "BLServlet", value = "/BLServlet")
public class FactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /*Connect co = new Connect();
            Connection c = co.connecter();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String d = request.getParameter("date");
            java.util.Date dd = dateFormat.parse(d);
            Date date = new Date(dd.getTime());
            Commande_livraison cl = new Commande_livraison();
            cl = cl.getCommandeLivraisonByDate(c, date, f.getId_fournisseur());
            Commande[] com = cl.getAllCommandeCommandeLivraisonByDate(c,f.getId_fournisseur(),date);
            double somme = 0;
            for (int i = 0; i < com.length; i++) {
                somme = somme + (com[i].getQuantite()*com[i].getTtc());
            }
            request.setAttribute("cl",cl);
            request.setAttribute("c",com);
            request.setAttribute("somme",somme);
            String lien = "BL";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);*/
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
