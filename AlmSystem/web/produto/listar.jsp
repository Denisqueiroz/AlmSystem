<%-- 
    Document   : listar
    Created on : 02/04/2020, 14:01:49
    Author     : TBO-002
--%>

<%@page import="br.com.AlmSystem.model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/vendor/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <c:import url="../layout/head.jsp"/>

        <div class="layout-main">

            <c:import url="../layout/body.jsp"/>

            <section class="layout-content">

                <nav class="navbar navbar-expand-md bg-light">
                    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <i class="oi oi-caret-right"></i>

                            </li>
                        </ul>
                    </div>
                    <a class="btn btn-primary btn-md" href="${pageContext.request.contextPath}/DadosProduto" role="button">
                        <span class="oi oi-plus" title="Cadastro" aria-hidden="true"></span>
                        <span>Cadastrar Produtos</span>
                    </a>
                </nav>

                <div class="container" id="listagem">
                    <div class="table-responsive">

                        <table class="table  table-striped">
                            <thead class="thead-warning">
                                <tr>
                                    <td>Codigo</td>
                                    <td>Descricao</td>
                                    <td>Unidade</td>
                                    <td>Marca</td>
                                    <td>Fornecedor</td>

                                    <td>Ação</td>
                                    <td>Ação</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="produto" items="${produtos}">
                                    <tr>
                                        <td>${produto.idProduto}</td>
                                        <td>${produto.descricaoProduto}</td>
                                        <td>${produto.unidade.descUnidade}</td>
                                        <td>${produto.marca.nomeMarca}</td>
                                        <td>${produto.fornecedor.nomePessoa}</td>



                                       
                                        <td><a href=" CarregaProduto?idProduto=${produto.idProduto}"><span class="oi oi-circle-x" title="Excluir Fornecedor" aria-hidden="true"></span>Alterar</a></td>
                                    <td><a href="ExcluirProduto?idProduto=${produto.idProduto}"> <span class="oi oi-aperture" title="Alterar Fornecedor" ></span>Excluir</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>





                    </div>
                </div>

            </section>

        </div>



        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="/webjars/jquery/jquery.min.js"></script>
        <script src="/webjars/jquery-mask-plugin/dist/jquery.mask.min.js"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
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
