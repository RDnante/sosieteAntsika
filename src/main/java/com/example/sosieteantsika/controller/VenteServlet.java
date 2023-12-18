package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.Article;
import com.example.sosieteantsika.model.Sortie_stock;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "VenteServlet", value = "/VenteServlet")
public class VenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Article a = new Article();
            List<Article> allarticle = a.getAllArticle(null);
            request.setAttribute("listarticle",allarticle);

            RequestDispatcher d = request.getRequestDispatcher("Insert_vente.jsp");
            d.forward(request,response);
        }catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idarticle = Integer.valueOf(request.getParameter("idarticle"));
            double quantite = Double.valueOf(request.getParameter("quantite"));
            Date d = Date.valueOf(LocalDate.now());
            Sortie_stock sortieStock = new Sortie_stock();
            sortieStock.inserer_sortie(null,idarticle,quantite,d.toString());
        }catch (Exception e) {

        }
    }
}
