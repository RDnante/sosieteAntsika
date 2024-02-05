<%@ page import="java.net.http.HttpClient" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.sosieteantsika.connection.Connect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.sosieteantsika.model.Service_besoin" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.example.sosieteantsika.model.Article" %>
<%@include file="./Header.jsp"%>
<%
    if(session.getAttribute("service")== null) response.sendRedirect("login.jsp");
    HashMap<String,String[]> all = new HashMap<>();
    try{
        Connect co = new Connect();
        Connection c = co.connecter();
        all = (new Service_besoin()).getAll(c);

    }catch(Exception e){

    }
    String[] qt = all.get("qt");
    String[] a = all.get("article");
    String[] ar = new String[a.length];
    Article art = new Article();
    for (int i = 0; i < a.length; i++) {
        try{
            ar[i]= (art.getarticleById(null,Integer.parseInt(a[i]))).getNom();
            System.out.println(qt[i]);
        }catch (Exception e){

        }

    }
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
                            <canvas id="singelBarChartTEST"></canvas>
                        </div>
                    </div>
                </div>
                </body>
            </center>
        </div>
    </div>

</div>
<%@include file="./Footer.jsp"%>

<script>
    (function ($) {
        // USE STRICT
        "use strict";

        try {
            var qt = <%= Arrays.toString(qt)%>
            var a = <%= Arrays.toString(a)%>
            // single bar chart
            var ctx = document.getElementById("singelBarChartTEST");
            if (ctx) {
                ctx.height = 150;
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: a,
                        datasets: [
                            {
                                label: "Article",
                                data: qt,
                                borderColor: "rgba(0, 123, 255, 0.9)",
                                borderWidth: "0",
                                backgroundColor: "rgba(0, 123, 255, 0.5)"
                            }
                        ]
                    },
                    options: {
                        legend: {
                            position: 'top',
                            labels: {
                                fontFamily: 'Poppins'
                            }

                        },
                        scales: {
                            xAxes: [{
                                ticks: {
                                    fontFamily: "Poppins"

                                }
                            }],
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true,
                                    fontFamily: "Poppins"
                                }
                            }]
                        }
                    }
                });
            }

        } catch (error) {
            console.log(error);
        }
    })(jQuery);
</script>