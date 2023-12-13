package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Proforma;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListProformaRHServlet", value = "/ListProformaRHServlet")
public class ListProformaRHServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idService = Integer.parseInt(request.getParameter("id"));
            Connect co = new Connect();
            Connection c = co.connecter();
            Fournisseur f = new Fournisseur();
            List<Fournisseur> allF = new ArrayList<>();
            Fournisseur[] all = f.getAllFournisseur(c);
            Proforma pr = new Proforma();
            for (int i = 0; i < all.length; i++) {
                pr = pr.getProformaByFournisseur(c,idService,all[i].getId_fournisseur());
                System.out.println(pr.getAllArticleServiceBesoin().length);
                if (pr.getAllArticleServiceBesoin().length!=0){
                    System.out.println("ato");
                    allF.add(all[i]);
                }
            }
            Fournisseur[] ff = new Fournisseur[allF.size()];
            request.setAttribute("fournisseur", allF.toArray(ff));
            String lien = "Liste_proformaRH";
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
