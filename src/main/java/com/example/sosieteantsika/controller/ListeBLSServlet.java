package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Bon_de_livraison;
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

@WebServlet(name = "ListeBLSServlet", value = "/ListeBLSServlet")
public class ListeBLSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Bon_de_livraison[] all = (new Bon_de_livraison()).getAllBL(c);
            request.setAttribute("bl", all);
            String lien = "Liste_BLS";
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
