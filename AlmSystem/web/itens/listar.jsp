<%-- 
    Document   : listar
    Created on : 22/04/2020, 14:21:57
    Author     : TBO-002
--%>

<%@page import="br.com.AlmSystem.model.Item"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <th>Codigo Item</th>
                            <th> Descrição Produto</th>
                            <th>Quantidade</th>
                            <th>Data da Compra</th>
                            <th>Validade do Produto</th>
                            <th>Data de Entrada</th>
                            <th>Nota Fiscal</th>

                        </tr>
                    </thead>
                    <tfoot>	               
                    <tbody>

                        <c:forEach var="item"  items="${items}">

                            <tr>
                                <td >${item.produto.idProduto}</td>
                                <td >${item.idItem}</td>
                                <td >${item.produto.descricaoProduto}</td>
                                <td >${item.quantidadeItem}</td>
                                <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${item.dataValidadeItem}"></fmt:formatDate></td>
                                <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${item.dataCompraItem}"></fmt:formatDate></td>
                                <td><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${item.dataEntrada}"></fmt:formatDate></td>
                                <td><a href="${item.notafiscal}" title="Baixar Nota" target="blank">Nota Fiscal</a></td>


               <td><a href="ListarEstoque?idProduto=${item.produto.idProduto}"><button>Consultar Estoque</button></a></td>
               <td><a href="CarregarSaldoEstoque?idItem=${item.idItem}"><button>Movimentar Produto</button></a></td> 
                            </tr>
                        </c:forEach>


                    </tbody>

                </table>
            </div>
        </div>
</div>
</section>


