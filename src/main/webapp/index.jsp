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

                </body>
            </center>
        </div>
    </div>

</div>
<%@include file="./Footer.jsp"%>