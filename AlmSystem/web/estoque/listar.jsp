<%-- 
    Document   : listar
    Created on : 30/04/2020, 11:18:14
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Estoque</title>
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
                            <td>Item</td>
                            <td>Codigo</td>
                            <td>Descricao</td>
                            <td>Unidade</td>
                            <td>Marca</td>
                            <td>Fornecedor</td>
                            <td>Total em Estoque</td>
                        </tr>
                    </thead>
                    <tbody>
                      
                    
                            <tr>
                                <td>${item.idItem}</td>
                                <td>${produto.idProduto}</td>
                                <td>${produto.descricaoProduto}</td>
                                <td>${produto.unidade.descUnidade}</td>
                                <td>${produto.marca.nomeMarca}</td>
                                <td>${produto.fornecedor.nomePessoa}</td>
                                <td>${item.totalItem}</td>                        
                            </tr>
                    </tbody>
                </table>



               <a href="RetirarEstoque?idProduto=${item.produto.idProduto}" role="button">           
               <button type="submit"  class="btn btn-primary">Retirar</button></a>
                <button type="submit" class="btn btn-primary">Inserir Estoque</button>
                <button type="submit" class="btn btn-primary">Cancelar Saida</button>
            </div>
        </div>
    </section>

