<%@ page import="com.example.sosieteantsika.model.Commande" %>
<%@ page import="com.example.sosieteantsika.model.Service" %>
<%@include file="./HeaderRH.jsp"%>
<%
  Commande[] allC = (Commande[]) request.getAttribute("commande");
  int idService = (Integer) request.getAttribute("idService");
  int idFournisseur = (Integer) request.getAttribute("idFournisseur");
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
              <h2 class="text-center title-2">Bon de commande</h2>
            </div>
            <hr>
            <div class="container-fluid">

              <!-- Page Heading -->
              <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <button id="btnpdf" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                        class="fas fa-download fa-sm text-white-50"></i> telecharger pdf</button>
              </div>

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
                              <h1 class="h4 text-gray-900 mb-4"> Bon de Commande</h1>
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
                          <h5 style="color: #1c294e">numero :<span style="color:darkgray"> 23/10/3</span></h5>
                        </div>
                      </div>

                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <h5 style="color: #1c294e">Livraison :<span style="color:darkgray"> partielle</span></h5>
                        </div>
                      </div>

                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <h5 style="color: #1c294e">paiement :<span style="color:darkgray"> check</span></h5>
                        </div>
                      </div>

                      <!--            text introduction proforma    -->
                      <div class="row" >
                        <div class="col-lg-11 offset-lg-1">
                          <p>voici la liste des articles que nous avons par rapport a vos attentes :</p>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                          <div class="card shadow mb-4">
                            <div class="card-header py-3">
                              <h6 class="m-0 font-weight-bold text-primary">Liste des articles</h6>
                            </div>
                            <div class="card-body">
                              <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                    <th>Nom</th>
                                    <th>Date</th>
                                    <th>Livraison partielle</th>
                                    <th>Mode de paiement</th>
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
                                    <td><%out.print(allC[i].getNom());%></td>
                                    <td><%out.print(allC[i].getDate());%></td>
                                    <td><%out.print(allC[i].getLivraison_partielle());%></td>
                                    <td><%out.print(allC[i].getMode_paiement());%></td>
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
                          <p>Arrete le present bon de commande a la somme de : <span style="color: #2d2e33; font-size: large"></span></p>
                        </div>
                        <div class="user-data__footer">
                          <button class="au-btn au-btn-load"><a href="ConfirmationBonDeCommandeServlet?idS=<%out.print(idService);%>&idF=<%out.print(idFournisseur);%>">Confirmer</a></button>
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
<%@include file="./Footer.jsp"%>