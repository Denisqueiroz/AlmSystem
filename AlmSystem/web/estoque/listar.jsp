<%-- 
    Document   : listar
    Created on : 30/04/2020, 11:18:14
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.AlmSystem.model.Produto"%>
<c:choose>
    <c:when test="${funcionario.tipoPessoa eq 'administrador'}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Estoque</title>
</head>

             <c:import url="../layout/header.jsp"/>

<div class="layout-main">
    <c:import url="../layout/menu.jsp"/> 

    <div class="container">
        ${mensagem}
        <div class="table-responsive">
            <table class="table table-striped table-hover table-sm">
                <thead>
                    <tr>

                        <td>Descricao</td>
                        <td>Unidade</td>
                        <td>Marca</td>
                       
                        <td>Total em Estoque</td>
                    </tr>
                </thead>
                <tbody>


                    <tr>

                        <td>${produto.descricaoProduto}</td>
                        <td>${produto.unidade.descUnidade}</td>
                        <td>${produto.marca.nomeMarca}</td>
                       
                        <td>${item.totalItem}</td>                        
                    </tr>
                </tbody>
            </table>




            <a href="ListarItens"role="button"> 
                <button type="submit" class="btn btn-primary  glyphicon glyphicon-trash">Voltar</button></a>
        </div>
        </div>
    </div>
</section>
</c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
