package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Fournisseur;
import com.example.sosieteantsika.model.Proforma;
import com.example.sosieteantsika.model.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProformaServlet", value = "/ProformaServlet")
public class ProformaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idService = ((Service)session.getAttribute("service")).getId_service();
            int idFournisseur = Integer.parseInt(request.getParameter("id" ));
            Connect co = new Connect();
            Connection c = co.connecter();
            Proforma pr = new Proforma();
            Fournisseur f = (new Fournisseur()).getFournisseurById(c,idFournisseur);
            pr = pr.getProformaByFournisseur(c,idService,idFournisseur);
            request.setAttribute("proforma", pr);
            request.setAttribute("fournisseur", f);
            String lien = "Proforma";
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
