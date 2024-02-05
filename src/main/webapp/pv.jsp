<%@ page import="com.example.sosieteantsika.model.*" %>
<%@ page import="java.util.List" %>
<%@include file="./Header.jsp"%>
<%
  try{
    Immobilisation immobilisation = (Immobilisation) request.getAttribute("immobilisation");
%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
        <div class="card">
          <div class="card-body">
            <div class="card-title">
              <h2 class="text-center title-2">Proforma</h2>
            </div>
            <hr>
            <div class="container-fluid">

              <div class="row justify-content-center">
                <div class="col-xl-10 col-lg-12 col-md-9">

                  <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                      <!-- Nested Row within Card Body -->
                      <div class="row">
                        <div class="col-lg-8 offset-lg-2">
                          <div class="p-5">
                            <div class="text-center">
                              <h1 class="h4 text-gray-900 mb-4">Proces Verbal</h1>
                            </div>

                          </div>
                        </div>
                      </div>

                      <div class="text-left row">
                        <div class="col-md-4 offset-lg-2">
                          <p><span style="font-size: 30px;">Date : </span> <% out.print(immobilisation.getDate()); %></p>
                        </div>
                      </div>
                      <div class="text-left row">
                        <div class="col-md-4 offset-lg-2">
                          <p><span style="font-size: 30px;">Prix : </span> <% out.print(immobilisation.getPrix()); %></p>
                        </div>
                      </div>
                      <div class="text-left row">
                        <div class="col-md-8 offset-lg-2">
                          <p><span style="font-size: 30px;">Compte Comptable : </span> <% out.print(immobilisation.getCompte_comptable()); %></p>
                        </div>
                      </div>
                      <div class="text-left row">
                        <div class="col-md-4 offset-lg-2">
                          <p><span style="font-size: 30px;">Numero : </span> <% out.print(immobilisation.getNumero()); %></p>
                        </div>
                      </div>
<%--                      <div class="row" >--%>
<%--                        <div class="col-lg-11 offset-lg-1">--%>
<%--                          <h3>Proforma venant de <%out.print("coucou");%></h3>--%>
<%--                        </div>--%>
<%--                      </div>--%>
                      <div class="row" >
                        <div class="col-lg-8 offset-lg-1">
                          <p>Voici la liste des articles que nous avons par rapport a vos attentes :</p>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                          <div class="card shadow mb-4">
                            <div class="card-header py-3">
                              <h6 class="m-0 font-weight-bold text-primary">Data Tables Example</h6>
                            </div>
                            <div class="card-body">
                              <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                    <th>type</th>
                                    <td><%out.print(immobilisation.getType());%></td>
<%--                                    <th>description</th>--%>
<%--                                    <th>neuf</th>--%>
<%--                                    <th>utilisable</th>--%>
<%--                                    <th>methode amortissement</th>--%>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                    <th>Description</th>
                                    <td><%out.print(immobilisation.getDescription());%></td>
<%--                                    <td><%out.print(immobilisation.getNeuf());%></td>--%>
<%--                                    <td><%out.print(immobilisation.getUtilisable());%></td>--%>
<%--                                    <td><%out.print(immobilisation.getMethode_ammortissement());%></td>--%>
                                  </tr>
                                  <tr>
                                    <th>marque</th>
                                    <td><%out.print(immobilisation.getMarque());%></td>
                                  </tr>
                                  <tr>
                                    <th>modele</th>
                                    <td><%out.print(immobilisation.getModel());%></td>
                                  </tr>
                                  <tr>
                                    <th>numero serie</th>
                                    <td><%out.print(immobilisation.getNumero_serie());%></td>
                                  </tr>
                                  <tr>
                                    <th>Neuf</th>
                                    <td><%out.print(immobilisation.getNeuf());%></td>
                                  </tr>
                                  <tr>
                                    <th>Utilisable</th>
                                    <td><%out.print(immobilisation.getUtilisable());%></td>
                                  </tr>
                                  <tr>
                                    <th>methode amortissement</th>
                                    <td><%out.print(immobilisation.getMethode_ammortissement());%></td>
                                  </tr>
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!--               remerciements -->
                      <div class="row">
                        <div class="col-lg-6 offset-lg-6">
                          <p>Merci de votre attention !</p>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>


            </div>
          </div>
        </div>
        </body>
      </center>
    </div>
  </div>

</div>
<%}catch (Exception e){}%>
<%@include file="./Footer.jsp"%>