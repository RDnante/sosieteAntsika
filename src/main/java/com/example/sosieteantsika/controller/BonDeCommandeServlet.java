package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Proforma;
import com.example.sosieteantsika.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BonDeCommandeServlet", value = "/BonDeCommandeServlet")
public class BonDeCommandeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idService = ((Service)session.getAttribute("service")).getId_service();
            int idFournisseur = Integer.parseInt(request.getParameter("id"));
            Connect co = new Connect();
            Connection c = co.connecter();
            Fournisseur f = new Fournisseur();
            Commande com = new Commande();
            Commande[] allC = com.getAllCommandeByFournisseur(c,idService,idFournisseur);
            request.setAttribute("commande", allC);
            String lien = "Bon_commande";
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
