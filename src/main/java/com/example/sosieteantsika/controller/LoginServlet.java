package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.Login;
import com.example.sosieteantsika.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Login login = new Login();
            Service service = new Service();

            String password = request.getParameter("password");
            Login valiny = login.login(password);
            service = service.getServiceById(valiny.getId_service(),null);
            String lien = valiny.getLien(valiny.getId_poste());

            HttpSession session = request.getSession();
            session.setAttribute("service",service);

            response.sendRedirect(lien);
        }catch (Exception e) {

        }
    }
}
