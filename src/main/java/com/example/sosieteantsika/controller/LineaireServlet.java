package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.AmortissementLineaire;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LineaireServlet", value = "/LineaireServlet")
public class LineaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AmortissementLineaire a = new AmortissementLineaire();
        try {
            List<AmortissementLineaire> list = a.calcule_lineaire(null,1);
            request.setAttribute("listlineaire",list);

            RequestDispatcher dispatcher = request.getRequestDispatcher("lineaire.jsp");
            dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
