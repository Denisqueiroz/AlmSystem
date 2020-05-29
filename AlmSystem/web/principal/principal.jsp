<%-- 
    Document   : index
    Created on : 30/03/2020, 14:13:58
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${pessoa.tipoPessoa eq 'a'}">
        <c:import url="layout/header.jsp"/>
        <c:import url="layout/menu.jsp"/>


    </c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>