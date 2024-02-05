<%@ page import="com.example.sosieteantsika.model.Immobilisation" %>
<%@include file="./HeaderRH.jsp"%>
<%
  Immobilisation[] immobilisations = (Immobilisation[]) request.getAttribute("immobilisations");
%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
        <div class="card">
          <div class="card-header">Liste Immobilisation(s)</div>
          <div class="card-body">
            <div class="card-title">
              <h3 class="text-center title-2">Immobilisation(s)</h3>
            </div>
            <hr>
            <div class="table-responsive">
              <table class="table table-bordered">
                <thead>
                <tr>
                  <th>Date</th>
                  <th>Prix</th>
                  <th>Compte Comptable</th>
                  <th>Numero</th>
                  <th>type</th>
                  <th>Marque</th>
                  <th>Modele</th>
                  <th>Numero de Serie</th>
                  <th>Description</th>
                  <th>Taux d'amortissement</th>
                  <th>Neuf</th>
                  <th>Utilisable</th>
                  <th>Methode d'amortissement</th>
                  <th>Lieu</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < immobilisations.length; i++) { %>
                <tr class="tr-shadow">
                  <td><%= immobilisations[i].getDate()%></td>
                  <td><%= immobilisations[i].getPrix()%></td>
                  <td><%= immobilisations[i].getCompte_comptable()%></td>
                  <td><%= immobilisations[i].getNumero()%></td>
                  <td><%= immobilisations[i].getType()%></td>
                  <td><%= immobilisations[i].getMarque()%></td>
                  <td><%= immobilisations[i].getModel()%></td>
                  <td><%= immobilisations[i].getNumero_serie()%></td>
                  <td><%= immobilisations[i].getDescription()%></td>
                  <td><%= immobilisations[i].getTaux_amortissement()%></td>
                  <td><%= immobilisations[i].getNeuf()%></td>
                  <td><%= immobilisations[i].getUtilisable()%></td>
                  <td><%= immobilisations[i].getMethode_ammortissement()%></td>
                  <td><%= immobilisations[i].getId_lieu()%></td>
                </tr>
                <% } %>
                </tbody>
              </table>
              </form>
            </div>
          </div>
        </div>
        </body>
      </center>
    </div>
  </div>

</div>
<%@include file="./Footer.jsp"%>