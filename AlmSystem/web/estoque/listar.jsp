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
                          
                            <th>Total em Estoque</th>


                        </tr>
                    </thead>
                    <tfoot>	               
                    <tbody>

                      

                            <tr>
                               
                                <td>${item.totalItem}</td>


                            </tr>
                       


                    </tbody>

                </table>
                <button type="submit" class="btn btn-primary">Retirada</button>
                <button type="submit" class="btn btn-primary">Inserir Estoque</button>
                <button type="submit" class="btn btn-primary">Cancelar Saida</button>
            </div>
        </div>
    </section>

