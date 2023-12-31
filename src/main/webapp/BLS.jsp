<%@ page import="com.example.sosieteantsika.model.Commande" %>
<%@ page import="com.example.sosieteantsika.model.Service" %>
<%@ page import="com.example.sosieteantsika.model.Commande_livraison" %>
<%@include file="./Header.jsp"%>
<%
  Commande[] allC = (Commande[]) request.getAttribute("c");
  double somme = (double)request.getAttribute("somme");
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
              <h2 class="text-center title-2">Bon de Livraison</h2>
            </div>
            <hr>
            <div class="container-fluid">

              <!-- vatany eto -->
              <div class="row justify-content-center" id="boncommande">
                <div class="col-xl-10 col-lg-12 col-md-9">

                  <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                      <!-- Nested Row within Card Body -->
                      <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                          <div class="card shadow mb-4">
                            <div class="card-header py-3">
                              <h6 class="m-0 font-weight-bold text-primary">Facture</h6>
                            </div>
                            <div class="card-body">
                              <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                    <th>Categorie</th>
                                    <th>Designation</th>
                                    <th>Quantite</th>
                                    <th>Prix unitaire</th>
                                    <th>TTC</th>

                                  </tr>
                                  </thead>

                                  <tbody>
                                  <%for (int i = 0; i < allC.length; i++) {%>
                                  <tr>
                                    <td><%out.print(allC[i].getCategorie());%></td>
                                    <td><%out.print(allC[i].getDesignation());%></td>
                                    <td><%out.print(allC[i].getQuantite());%></td>
                                    <td><%out.print(allC[i].getTva());%></td>
                                    <td><%out.print(allC[i].getTtc());%></td>
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
                        <div class="col-lg-8 offset-lg-4">
                          <p>Arretee la presente facture a la somme de : <span style="color: #2d2e33; font-size: large"><%out.print(somme);%></span></p>
                        </div>
                      </div>

                      <div class="user-data__footer">
                        <button class="au-btn au-btn-load"><a href="EnvoieBLServlet?date=<%out.print(cl.getDate_confirmation());%>">Confirmer</a></button>
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
  <script src="./styles/html2pdf/dist/html2pdf.bundle.js"></script>
  <script>
    document.getElementById("btnpdf").addEventListener('click', function () {
      var element = document.getElementById("boncommande");
      html2pdf(element);
    });
  </script>

</div>
<%@include file="./Footer.jsp"%>