package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.Etat_stock;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EtatStockServlet", value = "/EtatStockServlet")
public class EtatStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Etat_stock etatStock = new Etat_stock();
        try {
            List<Etat_stock> listetat = etatStock.getAllEtatstock(null);
            request.setAttribute("etatstock",listetat);

            RequestDispatcher d = request.getRequestDispatcher("EtatStock.jsp");
            d.forward(request,response);
        }catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
