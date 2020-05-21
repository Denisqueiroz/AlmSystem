<%-- 
    Document   : retirar
    Created on : 06/05/2020, 11:34:08
    Author     : TBO-002
--%>

<%@page import="br.com.AlmSystem.model.Item"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Movimentar Itens</title>
</head>

<c:import url="../layout/header.jsp"/>



<section class="layout-content">

    <form action="${pageContext.request.contextPath}/RetirarSaldoItem"  method="POST" class="formulario"> 

         <div class="container">
            <div class="form-group col-md-3"> 
                <label for="retirada">Codigo do Item</label>
               <input type="number" class="form-control" id="idItem" 
                                 readonly   name="idItem" value="${item.idItem}" />
            </div>
        
        
        <div class="container">
            <div class="form-group col-md-3"> 
                <label for="retirada">Quantidade Dispónivel</label>
               <input type="number" class="form-control" id="saldoItem" 
                                 readonly   name="saldoItem" value="${item.saldoItem}" />
            </div>
                                          
            <div class="form-group col-md-3"> 
                <label for="retirada">Digite a Quantidade a ser Retirada</label>
               <input type="number" class="form-control" id="saldoItem" 
                                       name="retirada" value="" />
            </div>
            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
    </div>
    </form>
</section>
