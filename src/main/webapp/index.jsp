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

            // single bar chart
            var ctx = document.getElementById("singelBarChartTEST");
            if (ctx) {
                ctx.height = 150;
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ["Coucouteau", "Stylo", "Riz"],
                        datasets: [
                            {
                                label: "Article",
                                data: [10, 15, 13],
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