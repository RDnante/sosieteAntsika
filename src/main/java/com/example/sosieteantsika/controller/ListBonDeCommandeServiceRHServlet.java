package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Commande;
import com.example.sosieteantsika.model.Fournisseur;
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

@WebServlet(name = "ListBonDeCommandeServiceRHServlet", value = "/ListBonDeCommandeServiceRHServlet")
public class ListBonDeCommandeServiceRHServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idService = ((Service)session.getAttribute("service")).getId_service();
            Connect co = new Connect();
            Connection c = co.connecter();
            Service s = new Service();
            Service[] allS = s.getAllService(c);
            request.setAttribute("allService", allS);
            String lien = "Liste_bonDeCommandeServiceRH";
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
