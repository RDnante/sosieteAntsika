package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Bon_de_livraison;
import com.example.sosieteantsika.model.Commande_livraison;
import com.example.sosieteantsika.model.Fournisseur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet(name = "EnvoieBLServlet", value = "/EnvoieBLServlet")
public class EnvoieBLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Fournisseur f = (Fournisseur) session.getAttribute("fournisseur");
            Commande_livraison cl = new Commande_livraison();
            System.out.println("hkhkhk");
            Connect co = new Connect();
            Connection c = co.connecter();
            String da = request.getParameter("date");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dd = dateFormat.parse(da);
            Date date = new Date(dd.getTime());
            cl.envoyerBonDeLivraison(c,f.getId_fournisseur(),date);
            String lien = "ListeBLServlet";
            response.sendRedirect(lien);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}