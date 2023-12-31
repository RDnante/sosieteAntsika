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

@WebServlet(name = "ListBonDeCommandeServlet", value = "/ListBonDeCommandeServlet")
public class ListBonDeCommandeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idService = ((Service)session.getAttribute("service")).getId_service();
            Connect co = new Connect();
            Connection c = co.connecter();
            Fournisseur f = new Fournisseur();
            Commande com = new Commande();
            List<Fournisseur> allF = new ArrayList<>();
            Fournisseur[] all = f.getAllFournisseur(c);
            for (int i = 0; i < all.length; i++) {
                Commande[] allC = com.getAllCommandeByFournisseur(c,idService,all[i].getId_fournisseur());
                System.out.println(allC.length);
                if (allC.length!=0){
                    System.out.println("ato");
                    allF.add(all[i]);
                }
            }
            Fournisseur[] ff = new Fournisseur[allF.size()];
            request.setAttribute("fournisseur", allF.toArray(ff));
            String lien = "Liste_bonDeCommande";
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
