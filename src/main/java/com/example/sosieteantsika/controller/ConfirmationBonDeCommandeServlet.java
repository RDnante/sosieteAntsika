package com.example.sosieteantsika.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Bon_de_commande;

@WebServlet(name = "ConfirmationBonDeCommandeServlet", value = "/ConfirmationBonDeCommandeServlet")
public class ConfirmationBonDeCommandeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idService = Integer.parseInt(request.getParameter("idS"));
            int idFournisseur = Integer.parseInt(request.getParameter("idF"));
            System.out.println(idService);
            System.out.println(idFournisseur);
            Connect co = new Connect();
            Connection c = co.connecter();
            Bon_de_commande bdc = new Bon_de_commande();
            bdc.confirmationBonDeCommande(c, idService, idFournisseur);
            String lien = "ListBonDeCommandeServiceRHServlet";
            response.sendRedirect(lien);
        }catch (Exception e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
