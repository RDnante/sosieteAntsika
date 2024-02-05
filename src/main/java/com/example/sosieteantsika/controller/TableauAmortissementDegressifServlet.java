package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.AmortissementDegressif;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

@WebServlet(name = "TableauAmortissementDegressifServlet", value = "/TableauAmortissementDegressifServlet")
public class TableauAmortissementDegressifServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            HashMap<String,Object> all = (new AmortissementDegressif()).getAmortissementDegressif(c,id);
            AmortissementDegressif[] alli = (AmortissementDegressif[]) all.get("tableau");
            for (int i = 0; i < alli.length; i++) {
                System.out.println(alli[i].getAnnee());
            }
            request.setAttribute("all",all);
            String lien = "TableauAmortissementDegressif";
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
