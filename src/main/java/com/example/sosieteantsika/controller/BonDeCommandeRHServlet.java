package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Service;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "BonDeCommandeRHServlet", value = "/BonDeCommandeRHServlet")
public class BonDeCommandeRHServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idService = Integer.parseInt(request.getParameter("idS"));
            int idFournisseur = Integer.parseInt(request.getParameter("id"));
            Connect co = new Connect();
            Connection c = co.connecter();
            Fournisseur f = new Fournisseur();
            Commande com = new Commande();
            Commande[] allC = com.getAllCommandeByFournisseur(c,idService,idFournisseur);
            request.setAttribute("commande", allC);
            request.setAttribute("idService",idService);
            request.setAttribute("idFournisseur",idFournisseur);
            String lien = "Bon_commandeRH";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
