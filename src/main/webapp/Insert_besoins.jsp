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
          <div class="card-header">Insertion Besoin</div>
          <div class="card-body">
            <div class="card-title">
              <h3 class="text-center title-2">Besoin</h3>
            </div>
            <hr>
            <form action="" method="post">
              <div class="form-group">
                <label for="article" class="control-label mb-1">Article</label>
                <input id="article" name="article" type="text" class="form-control">
              </div>
              <div class="form-group">
                <label for="nombre" class="control-label mb-1">Nombre</label>
                <input id="nombre" name="nombre" type="number" class="form-control">
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