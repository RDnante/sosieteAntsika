package com.example.sosieteantsika.controller;

import com.example.sosieteantsika.connection.Connect;
import com.example.sosieteantsika.model.Article;
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

@WebServlet(name = "ListProformaServlet", value = "/ListProformaServlet")
public class ListProformaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int idService = ((Service)session.getAttribute("service")).getId_service();
            Connect co = new Connect();
            Connection c = co.connecter();
            Fournisseur f = new Fournisseur();
            List<Fournisseur> allF = new ArrayList<>();
            Fournisseur[] all = f.getAllFournisseur(c);
            Proforma pr = new Proforma();
            for (int i = 0; i < all.length; i++) {
                pr = pr.getProformaByFournisseur(c,idService,all[i].getId_fournisseur());
                if (pr.getAllArticleServiceBesoin().length!=0){
                    allF.add(all[i]);
                }
            }
            request.setAttribute("fournisseur", allF.toArray(all));
            String lien = "Liste_proforma";
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
