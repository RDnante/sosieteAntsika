<%@ page import="com.example.sosieteantsika.model.*" %>
<%@include file="./HeaderRH.jsp"%>
<%
  try{
  Proforma pr = (Proforma)request.getAttribute("proforma");
  Fournisseur f = (Fournisseur) request.getAttribute("fournisseur");
  Stock_fournisseur[] sf = pr.getAllArticleServiceBesoin();
  Article a = new Article();
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
                              <h1 class="h4 text-gray-900 mb-4">Proforma</h1>
                            </div>

                          </div>
                        </div>
                      </div>

                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <h3>Proforma venant de <%out.print(f.getNom());%></h3>
                        </div>
                      </div>
                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
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
                                    <th>Designation</th>
                                    <th>Quantite</th>
                                    <th>Prix Unitaire</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <% for (int i = 0; i < sf.length; i++) {
                                    a = a.getarticleById(null,sf[i].getId_article());
                                  %>
                                  <tr>
                                    <td><%out.print(a.getNom());%></td>
                                    <td><%out.print(sf[i].getQuantite());%></td>
                                    <td><%out.print(sf[i].getPrix_unitaire());%></td>
                                  </tr>
                                  <%}%>
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