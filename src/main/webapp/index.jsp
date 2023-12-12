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
                <div class="table-responsive table--no-card m-b-40">
                    <table class="table table-borderless table-striped">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Numero</th>
                            <th>Partie</th>
                            <th>Nom</th>
                            <th>Voies</th>
                            <th>Pourcentage</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                </body>
            </center>
        </div>
    </div>

</div>
<%@include file="./Footer.jsp"%>