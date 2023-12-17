package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Login;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginFournisseurServlet", value = "/LoginFournisseurServlet")
public class LoginFournisseurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Login l = new Login();

            String nom = request.getParameter("nom");
            String mdp = request.getParameter("mdp");

            Fournisseur f = l.loginFournisseur(nom,mdp);

            HttpSession session = request.getSession();
            session.setAttribute("fournisseur",f);

            response.sendRedirect("ListeBLServlet");
        } catch (Exception e) {
            response.sendRedirect("Login_Fournisseur.jsp");
        }
    }
}
