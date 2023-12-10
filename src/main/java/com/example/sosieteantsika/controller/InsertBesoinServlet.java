package com.example.sosieteantsika.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Service;
import com.example.sosieteantsika.model.Service_besoin;

@WebServlet(name = "InsertBesoinServlet", value = "/InsertBesoinServlet")
public class InsertBesoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Service_besoin sb = new Service_besoin();
            HttpSession session = request.getSession();
            Service s = (Service)session.getAttribute("service");
            int id_article = Integer.parseInt((String)request.getAttribute("idArticle"));            
            double quantite = Double.parseDouble((String)request.getAttribute("quantite"));

            sb.insertServiceBesoin(c, s.getId_service(), id_article, quantite);
            String lien = "Insert_besoins";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);                                                                                                                                                                                                                                                                                                                                                                                                                             
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
