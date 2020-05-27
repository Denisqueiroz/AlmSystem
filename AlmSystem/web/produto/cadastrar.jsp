<%-- 
    Document   : cadastrarproduto
    Created on : 21/01/2020, 11:56:22
    Author     : Suporte
--%>

<%@page import="br.com.AlmSystem.model.Unidade"%>
<%@page import="java.util.List"%>
<%@page import="br.com.AlmSystem.model.Marca"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>

    <link href="vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <body>

        <c:import url="../layout/header.jsp"/>

        <div class="layout-main">
            <c:import url="../layout/menu.jsp"/>


            <section class="layout-content">
                <div class="page-header">
                    <nav class="navbar navbar-expand-md navbar-top bg-light">
                        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <i class="oi oi-caret-right"></i>
                                    <span>Cadastrar Produtos</span>
                                </li>
                            </ul>
                        </div>
                        <a class="btn btn-primary btn-md" href="ListarProduto" role="button">
                            <span class="oi oi-spreadsheet" title="Cadastro" aria-hidden="true"></span>
                            <span>Listar Produtos</span>
                        </a>
                    </nav>
                </div>
                <div class="container">
                    <!--------------------campo de cadastro----------------------------------------------------->
                    <p class="text-center text-uppercase">${mensagem}<p>
                    <div class="container" id="cadastro">
                        <form  name="SalvarProduto" action="SalvarProduto" method="POST">
                            <div class="form-row">

                                <div class="form-group col-md-2">
                                    <label for="cod">Codigo do Produto</label>
                                    <input type="text" class="form-control" id="idProduto" readonly=""
                                           value="${produto.idProduto}"   autofocus="autofocus" name="idProduto" value=""/>
                                    <div class="invalid-feedback">
                                    </div>
                                </div>


                                <div class="form-group col-md-8">
                                    <label for="descricaoProduto">Descrição do Produto</label>
                                    <input type="text" class="form-control" id="nome" placeholder="Digite a descrição"
                                           value="${produto.descricaoProduto}"  
                                           autofocus="autofocus" name="descricaoProduto" value=""/>
                                    <div class="invalid-feedback">

                                    </div>
                                </div>


                                <div class="form-group col-md-4">
                                    <label>Unidade de Medida</label>
                                    <select  class="form-control" name="idUnidade">
                                        <c:forEach var="unidade"  items="${unidades}">
                                            <option value="${unidade.idUnidade}"
                                                    ${unidade.idUnidade == produto.idUnidade ? 'selected': ''} >
                                                ${unidade.descUnidade}</option>
                                            </c:forEach>
                                    </select>                                                                            
                                </div>
                                <div class="clearfix"> </div>



                                <div class="form-group col-md-3">
                                    <label>Fornecedor </label>
                                    <select  class="form-control" name="idFornecedor">
                                        <c:forEach var="fornecedor"  items="${fornecedores}">
                                            <option value="${fornecedor.idFornecedor}"
                                                    ${fornecedor.idFornecedor == produto.idFornecedor ? 'selected': ''} >
                                                ${fornecedor.nomePessoa}</option>
                                            </c:forEach>
                                    </select>                                                                             
                                </div> 

                                <div class="clearfix"> </div>


                                <div class="form-group col-md-4">
                                    <label>Marca </label>
                                    <select  class="form-control" name="idMarca">
                                        <c:forEach var="marca"  items="${marcas}">
                                            <option value="${marca.idMarca}"
                                                    ${marca.idMarca == produto.idMarca ? 'selected': ''} >
                                                ${marca.nomeMarca}</option>
                                            </c:forEach>
                                    </select>                                                                            
                                </div>
                                <div class="clearfix"> </div>   

                            </div>
                            <input type="hidden" id="id" name="id" value=""/>
                            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                        </form>
                    </div>
            </section>

        </div>



        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
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