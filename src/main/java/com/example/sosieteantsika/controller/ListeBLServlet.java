package com.example.sosieteantsika.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande_livraison;
import com.example.sosieteantsika.model.Fournisseur;

@WebServlet(name = "ListeBLServlet", value = "/ListeBLServlet")
public class ListeBLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            HttpSession session = request.getSession();
            Fournisseur fournisseur = (Fournisseur)session.getAttribute("fournisseur");
            Commande_livraison cl = new Commande_livraison();
            Commande_livraison[] allC = cl.verification(c,cl.getAllCommandeLivraison(c, fournisseur.getId_fournisseur()));
            request.setAttribute("bdc", allC);
            String lien = "Liste_BL";
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
