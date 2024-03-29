<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


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
    <title>SosieteAntsika</title>
    <link href="./styles/images/icon/logo-mini.png" rel="icon">


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

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="index.jsp">
                <img src="./styles/images/icon/logo-blue.png" alt="Trei Degete" />
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a href="ListProformaServiceRHServlet">
                            <i class="fas fa-chart-bar"></i>Proforma</a>
                    </li>
                    <li>
                        <a href="ListBonDeCommandeServiceRHServlet">
                            <i class="fas fa-chart-bar"></i>Bon de commande</a>
                    </li>
                    <li>
                        <a href="ListBonDeCommandeServiceRHServlet">
                            <i class="fas fa-chart-bar"></i>Tableau d'amortissement lineaire</a>
                    </li>
                    <li>
                        <a href="ListeAmortissementDegressif">
                            <i class="fas fa-chart-bar"></i>Tableau d'amortissement degressif</a>
                    </li>

                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header" action="RechercheServlet" method="POST">
                            <input class="au-input au-input--xl" type="text" name="search" placeholder="Recherche d'immobilisation" />
                            <button class="au-btn--submit" type="submit">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>
                        <div class="header-button">
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="./styles/images/icon/image.webp" alt="Profil" />
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">ANARANLE BRANCHE</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="./styles/images/icon/image.webp" alt="Profil" />
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">ANARANLE BRANCHE</a>
                                                </h5>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="./DecoServlet">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->

        <!-- END MAIN CONTENT-->
        <!-- END PAGE CONTAINER-->
    </div>

</div>

