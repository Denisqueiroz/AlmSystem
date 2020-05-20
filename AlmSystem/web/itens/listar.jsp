<%-- 
    Document   : listar
    Created on : 22/04/2020, 14:21:57
    Author     : TBO-002
--%>

<%@page import="br.com.AlmSystem.model.Item"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Itens</title>
</head>

<c:import url="../layout/header.jsp"/>

<div class="layout-main">
    <c:import url="../layout/menu.jsp"/> 




    <section class="layout-content">


        <div class="container">

            ${mensagem}
            <div class="table-responsive">
                <table class="table table-striped table-hover table-sm">
                    <thead>
                        <tr>
                            <th>Codigo Produto</th>
                            <th> Descrição Produto</th>
                            <th>Codigo Item</th>
                            <th>Quantidade</th>
                            <th>Data da Compra</th>
                            <th>Validade do Produto</th>
                            <th>Data de Entrada</th>
                           
                        </tr>
                    </thead>
                    <tfoot>	               
                    <tbody>

                        <c:forEach var="item"  items="${items}">

                            <tr>
                                <td >${item.produto.idProduto}</td>
                               <td >${item.produto.descricaoProduto}</td>
                                <td >${item.idItem}</td>
                                <td >${item.saldoItem}</td>
                                <td>${item.dataValidadeItem}</td>
                                <td>${item.dataCompraItem}</td>
                                <td>${item.dataEntrada}</td>


         <td><a href="ListarEstoque?idProduto=${item.produto.idProduto}"><button>Consultar Estoque</button></a></td>
                               
                            </tr>
                        </c:forEach>


                    </tbody>

                </table>
            </div>
        </div>
</div>
</section>


