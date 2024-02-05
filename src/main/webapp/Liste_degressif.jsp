<%@ page import="com.example.sosieteantsika.model.Fournisseur" %>
<%@ page import="com.example.sosieteantsika.model.Immobilisation" %>
<%@include file="./HeaderRH.jsp"%>
<%
  Immobilisation[] all = (Immobilisation[]) request.getAttribute("all");
%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
          <div class="card">
            <div class="card-header">Liste des immobilisation à methode d'amortissement degressif</div>
            <div class="card-body">
              <div class="card-title">
                <h3 class="text-center title-2">Liste d'immobilisation</h3>
              </div>
              <hr>
              <div class="table-responsive table-responsive-data2">
                  <table class="table table-data2">
                    <thead>
                    <tr>
                      <th>Nom</th>
                      <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (int i = 0; i < all.length; i++) { %>
                    <tr class="tr-shadow">
                      <td><%out.print(all[i].getType()+" "+all[i].getMarque()+" "+all[i].getModel());%></td>
                      <td>
                        <div class="table-data-feature">
                          <button class="btn btn-info" data-toggle="tooltip" data-placement="top" style="color: white"><a href="TableauAmortissementDegressifServlet?id=<%out.print(all[i].getId_immobilisation());%>">VOIR TABLEAU</a></button>
                        </div>
                      </td>
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