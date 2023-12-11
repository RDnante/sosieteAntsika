<%@ page import="com.example.sosieteantsika.model.Article" %>
<%@ page import="java.util.List" %>
<%@include file="./Header.jsp"%>

<%
    List<Article> allA = (List<Article>)request.getAttribute("article");
%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
        <div class="col-lg-6">
        <div class="card">
          <div class="card-header">Insertion Besoin</div>
          <div class="card-body">
            <div class="card-title">
              <h3 class="text-center title-2">Besoin</h3>
            </div>
            <hr>
            <form action="InsertBesoinServlet" method="get">
              <div class="form-group">
                <label for="idarticle" class="control-label mb-1">Article</label>
                <select id="idarticle" name="idarticle" class="form-control" required>
                  <% for (int i = 0; i < allA.size(); i++) { %>
                  <option value="<%out.print(allA.get(i).getId_article());%>"><%out.print(allA.get(i).getNom());%></option>
                  <% } %>
                </select>
              </div>
              <div class="form-group">
                <label for="nombre" class="control-label mb-1">Nombre</label>
                <input id="nombre" name="quantite" type="number" class="form-control">
              </div>
              <div>
                <button id="payment-button" type="submit" class="btn btn-lg btn-info btn-block">
                  <span id="payment-button-amount">Confirmer</span>
                </button>
              </div>
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