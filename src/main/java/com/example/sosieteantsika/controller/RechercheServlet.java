package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande_livraison;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Immobilisation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "RechercheServlet", value = "/RechercheServlet")
public class RechercheServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Immobilisation immobilisation = new Immobilisation();
            String textRecherche = request.getParameter("search");
            Immobilisation[] immobilisations = immobilisation.rechercheAvecBoolean(textRecherche, c);
            request.setAttribute("immobilisations", immobilisations);
            String lien = "ResultatRecherche";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Pas de resultats</h1>");
            out.println("</body></html>");
        }
    }
}
