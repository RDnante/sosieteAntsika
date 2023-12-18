<%@ page import="java.net.http.HttpClient" %>
<%@include file="./Header.jsp"%>
<%
    if(session.getAttribute("service")== null) response.sendRedirect("login.jsp");
%>
<div class="page-wrapper">

    <div class="page-container">

        <div class="main-content">
            <center>

                <body>
                <h1>Accueil</h1>
                <br>
                <div class="col-lg-6">
                    <div class="au-card m-b-30">
                        <div class="au-card-inner">
                            <h3 class="title-2 m-b-40">Articles</h3>
                            <canvas id="singelBarChart"></canvas>
                        </div>
                    </div>
                </div>
                </body>
            </center>
        </div>
    </div>

</div>
<%@include file="./Footer.jsp"%>