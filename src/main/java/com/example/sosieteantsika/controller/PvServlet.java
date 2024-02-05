package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.model.Immobilisation;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PvServlet", value = "/PvServlet")
public class PvServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Immobilisation immobilisation = new Immobilisation();
            int idImmo = Integer.parseInt(request.getParameter("idImmo"));
            immobilisation = immobilisation.get(null,idImmo);
            request.setAttribute("immobilisation",immobilisation);

            RequestDispatcher dispatcher = request.getRequestDispatcher("pv.jsp");
            dispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
