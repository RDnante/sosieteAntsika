<%@ page import="com.example.sosieteantsika.model.Fournisseur" %>
<%@include file="./Header.jsp"%>
<div class="page-wrapper">

    <div class="page-container">

        <div class="main-content">
            <center>
                <body>
                <h1></h1>
                <br>
                <div class="card">
                    <div class="card-header">Liste Bon de Livraison</div>
                    <div class="card-body">
                        <div class="card-title">
                            <h3 class="text-center title-2">Bon de Livraison</h3>
                        </div>
                        <hr>
                        <div class="table-responsive table-responsive-data2">
                            <table class="table table-data2">
                                <thead>
                                <tr>
                                    <th>Numero Bon de commande</th>
                                    <th>Date</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <% for (int i = 0; i < 2; i++) { %>
                                <tr class="tr-shadow">
                                    <td>1</td>
                                    <td>DATE</td>
                                    <td>
                                        <div class="table-data-feature">
                                            <button class="btn btn-info" data-toggle="tooltip" data-placement="top" style="color: white"><a href="">VOIR BL</a></button>
                                        </div>
                                    </td>
                                </tr>
                                <% } %>
                                </tbody>
                            </table>
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