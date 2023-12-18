<%@ page import="com.example.sosieteantsika.model.Commande" %>
<%@ page import="com.example.sosieteantsika.model.Service" %>
<%@include file="./Header.jsp"%>
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
                        <div class="col-lg-8 offset-lg-2">
                          <div class="p-5">
                            <div class="text-center">
                              <h1 class="h4 text-gray-900 mb-4"> Bon de Livraison et Facture</h1>
                            </div>

                          </div>
                        </div>
                      </div>


                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <h3 class="h3" style="color: #1c294e">Date :<span style="color:darkgray"> 28/10/2003</span></h3>
                        </div>
                      </div>

                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <h5 style="color: #1c294e">Numero Bon de commande :<span style="color:darkgray">4</span></h5>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                          <div class="card shadow mb-4">
                            <div class="card-header py-3">
                              <h6 class="m-0 font-weight-bold text-primary">Bon de livraison</h6>
                            </div>
                            <div class="card-body">
                              <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                    <th>Categorie</th>
                                    <th>Designation</th>
                                    <th>Quantite</th>

                                  </tr>
                                  </thead>

                                  <tbody>
                                  <%for (int i = 0; i < 2; i++) {%>
                                  <tr>
                                    <td>ARTICLE</td>
                                    <td>categorie</td>
                                    <td>3</td>
                                  </tr>
                                  <%}%>
                                  </tbody>
                                </table>
                              </div>

                            </div>
                          </div>
                        </div>
                      </div>


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
                                  <%for (int i = 0; i < 2; i++) {%>
                                  <tr>
                                    <td>Outil</td>
                                    <td>Couteau</td>
                                    <td>5</td>
                                    <td>560.00</td>
                                    <td>600.00</td>
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
                          <p>Arretee la presente facture a la somme de : <span style="color: #2d2e33; font-size: large"></span></p>
                        </div>
                      </div>

                      <div class="user-data__footer">
                        <button class="au-btn au-btn-load">Confirmer</button>
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