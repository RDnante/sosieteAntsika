<%@include file="./Header.jsp"%>
<div class="page-wrapper">

  <div class="page-container">

    <div class="main-content">
      <center>
        <body>
        <h1></h1>
        <br>
        <div class="col-lg-6">
          <div class="card">
            <div class="card-header">Insertion Vente</div>
            <div class="card-body">
              <div class="card-title">
                <h3 class="text-center title-2">Vente</h3>
              </div>
              <hr>
              <form action="" method="get">
                <div class="form-group">
                  <label for="idarticle" class="control-label mb-1">Article</label>
                  <select id="idarticle" name="idarticle" class="form-control" required>
                    <% for (int i = 0; i < 3; i++) { %>
                    <option value="<%= i %>">Article <%= i %></option>
                    <% } %>
                  </select>
                </div>
                <div class="form-group">
                  <label for="quantite" class="control-label mb-1">Quantite</label>
                  <input id="quantite" name="quantite" type="number" class="form-control">
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