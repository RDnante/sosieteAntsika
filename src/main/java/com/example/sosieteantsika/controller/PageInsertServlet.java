package com.example.sosieteantsika.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Article;

@WebServlet(name = "PageInsertServlet", value = "/PageInsertServlet")
public class PageInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Article a = new Article();
            List<Article> allA = a.getAllArticle(c);
            request.setAttribute("article", allA);
            String lien = "Insert_besoins";
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
