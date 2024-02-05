<%@ page import="com.example.sosieteantsika.model.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.sosieteantsika.controller.TableauAmortissementDegressifServlet" %>
<%@include file="./HeaderRH.jsp"%>
<%
  try{
    HashMap<String,Object> all= (HashMap<String, Object>) request.getAttribute("all");
    Immobilisation one = (Immobilisation) all.get("immobilisation");
    AmortissementDegressif[] tab = (AmortissementDegressif[]) all.get("tableau");

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
                          <h3>Nature du bien : <%=one.getType()+" "+one.getModel()+" "+one.getMarque()%></h3>
                          <h3>Date d'achat : <%=one.getDate()%></h3>
                          <h3>Duree : <%=((Annee)(all.get("annee"))).getAnnee()%></h3>
                          <h3>Montant : <%=one.getPrix()%></h3>
                          <h3>Coefficient : <%=((double)(all.get("coefficient")))%></h3>
                          <h3>Taux degressif : <%=((int)(all.get("taux")))%></h3>

                        </div>
                      </div>

                      <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                          <div class="card shadow mb-4">

                            <div class="card-body">
                              <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                  <tr>
                                    <th>Annee</th>
                                    <th>Base amortissement</th>
                                    <th>Taux degressif</th>
                                    <th>Taux lineaire</th>
                                    <th>Amortissement</th>
                                    <th>Valeur nette</th>

                                  </tr>
                                  </thead>
                                  <tbody>
                                  <% for (int i = 0; i < tab.length; i++) {%>
                                  <tr>
                                    <td><%out.print(tab[i].getAnnee());%></td>
                                    <td><%out.print(tab[i].getBaseamortissement());%></td>
                                    <td><%out.print(tab[i].getTauxdegressif());%></td>
                                    <td><%out.print(tab[i].getTauxlineaire());%></td>
                                    <td><%out.print(tab[i].getAmortissement());%></td>
                                    <td><%out.print(tab[i].getValeurnette());%></td>
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