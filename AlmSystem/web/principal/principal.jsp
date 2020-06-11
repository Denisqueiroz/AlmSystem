<%-- 
    Document   : index
    Created on : 30/03/2020, 14:13:58
    Author     : TBO-002
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<c:import url="../layout/header.jsp"/>
<c:import url="../layout/menu.jsp"/>
<a href="${pageContext.request.contextPath}/LogarFuncionario?acao=logout">Sair</a>   <br />  
<section>   <h3>${saudacao}</h3> </section>
