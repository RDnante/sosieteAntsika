<%@ page import="com.example.sosieteantsika.model.Fournisseur" %>
<%@include file="./Header.jsp"%>
<%
  Fournisseur[] allF = (Fournisseur[])request.getAttribute("fournisseur");
%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
          <div class="card">
            <div class="card-header">Liste Fournisseur</div>
            <div class="card-body">
              <div class="card-title">
                <h3 class="text-center title-2">Proforma</h3>
              </div>
              <hr>
              <div class="table-responsive table-responsive-data2">
                <table class="table table-data2">
                  <thead>
                  <tr>
                    <th>Fournissuer</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <% for (int i = 1; i < allF.length; i++) { %>
                  <tr class="tr-shadow">
                    <td><%out.print(allF[i].getNom());%></td>
                    <td>
                      <div class="table-data-feature">
                        <button class="btn btn-info" data-toggle="tooltip" data-placement="top" style="color: white">VOIR PROFORMA</button>
                      </div>
                    </td>
                  </tr>
                  <% } %>

                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </body>
      </center>
    </div>
  </div>

</div>
<%@include file="./Footer.jsp"%>