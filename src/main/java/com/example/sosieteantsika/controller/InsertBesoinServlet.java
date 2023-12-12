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
            int id_article = Integer.parseInt((String)request.getParameter("idarticle"));
            double quantite = Double.parseDouble((String)request.getParameter("quantite"));
            System.out.println(id_article);
            sb.insertServiceBesoin(c, s.getId_service(), id_article, quantite);
            String lien = "PageInsertServlet";
            response.sendRedirect(lien);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
