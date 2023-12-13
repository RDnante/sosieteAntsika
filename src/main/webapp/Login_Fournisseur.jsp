<%--
  Created by IntelliJ IDEA.
  User: jerri
  Date: 11/12/2023
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags-->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="au theme template">
  <meta name="author" content="Hau Nguyen">
  <meta name="keywords" content="au theme template">

  <!-- Title Page-->
  <title>Login</title>

  <!-- Fontfaces CSS-->
  <link href="./styles/css/font-face.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

  <!-- Bootstrap CSS-->
  <link href="./styles/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

  <!-- Vendor CSS-->
  <link href="./styles/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/wow/animate.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/slick/slick.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/select2/select2.min.css" rel="stylesheet" media="all">
  <link href="./styles/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

  <!-- Main CSS-->
  <link href="./styles/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
  <div class="page-content--bge5">
    <div class="container">
      <div class="login-wrap">
        <div class="login-content">
          <div class="login-logo">
            <a href="#">
              <img src="./styles/images/icon/logo-blue.png" alt="CoolAdmin">
            </a>
          </div>
          <div class="login-form">
            <form action="./LoginFournisseurServlet" method="post">
              <div class="form-group">
                <label>Identifiant</label>
                <input class="au-input au-input--full" type="text" name="nom" placeholder="Identifiant">
              </div>
              <div class="form-group">
                <label>Password</label>
                <input class="au-input au-input--full" type="password" name="mdp" placeholder="Password">
              </div>
              <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">sign in</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>

<!-- Jquery JS-->
<script src="./styles/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="./styles/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="./styles/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="./styles/vendor/slick/slick.min.js">
</script>
<script src="./styles/vendor/wow/wow.min.js"></script>
<script src="./styles/vendor/animsition/animsition.min.js"></script>
<script src="./styles/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="./styles/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="./styles/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="./styles/vendor/circle-progress/circle-progress.min.js"></script>
<script src="./styles/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="./styles/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="./styles/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="./styles/js/main.js"></script>

</body>

</html>
<!-- end document-->
