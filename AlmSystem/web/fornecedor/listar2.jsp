<%-- 
    Document   : listarfornecedor
    Created on : 25/02/2020, 15:43:27
    Author     : Suporte
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.AlmSystem.model.Fornecedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${funcionario.tipoPessoa eq 'administrador'}">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <link href="vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <body>
        <c:import url="../layout/header.jsp"/>
        <div class="layout-main">
            <c:import url="../layout/menu.jsp"/>

                <div class="container">

                    ${mensagem}
                    <div class="table-responsive">
                        <table class="table table-striped table-hover table-sm">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Cnpj</th>
                                    <th>Nome Fansia</th>
                                    <th>Inscrição Estadual:</th>
                                    <th>Tipo</th>
                                    <th>E-mail</th>
                                    <th>Telefone</th>
                                    <th>Alterar</th>
                                    <th>Excluir</th>
                                </tr>
                            </thead>
                            <tfoot>	               
                            <tbody>

                                <c:forEach var="fornecedor" items="${fornecedores}">

                                    <tr>
                                        <td >${fornecedor.idFornecedor}</td>
                                        <td >${fornecedor.cnpj}</td>
                                        <td>${fornecedor.nomePessoa}</td>
                                        <td>${fornecedor.inscricaoEstadual}</td>
                                        <td >${fornecedor.tipoPessoa}</td>
                                        <td >${fornecedor.emailPessoa}</td>
                                        <td >${fornecedor.telefonePessoa}</td>


                                        <td><a href="ExcluirFornecedor?idFornecedor=${fornecedor.idFornecedor}"><button>Excluir</button></a></td>
                                        <td><a href="CarregarFornecedor?idFornecedor=${fornecedor.idFornecedor}"><button>Alterar</button></a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>

                        </table>







                    </div>
                </div>
      
        </div>



        <!-- Bootstrap core JavaScript
        ================================================== -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript">

            $(function () {
                $('[data-toggle="popover"]').popover();
            });

            $(document).ready(function () {
                $(".navbar-toggle").click(function () {
                    $(".sidebar").toggleClass("sidebar-open");
                })
            });

        </script>
    </body>
</html>
</c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>