<%-- 
    Document   : realtorios
    Created on : 09/06/2020, 17:00:01
    Author     : TBO-002
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${funcionario.tipoPessoa eq 'administrador'}">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/vendor/style.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

    <li>
        <div class="form-row">                  

            <br/> <br/><br/><br/>
            <div class="form-row">  

                <form name="relatorioitem" action="${pageContext.request.contextPath}/RelatorioItem" method="POST">
                    <label for="idItem">Item : </label><select name="idItem" required >
                        <c:forEach var="item" items="${items}">
                            <option value="${item.idItem}">${item.produto.descricaoProduto}</option>
                        </c:forEach>
                    </select><br /><br />
                    <input type="submit" label="Salvar" name="salvar" /><br /><br />
                </form>      


                <!--                            <form class="form-inline mt-2 mt-md-0">
                                                <input class="form-control mr-sm-2" type="text" placeholder="Procurar Produto" aria-label="blue">
                                          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Procurar </button>
                                            </form>-->

            </div>

        </div>
    </li>
    <div class="layout-main">
        <div class="container-fluid">
            <div class="box-content">

                <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Date registered</th>
                            <th>Role</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>David R</td>
                            <td class="center">2012/01/01</td>
                            <td class="center">Member</td>
                            <td class="center">
                                <span class="label-success label label-default">Active</span>
                            </td>
                            <td class="center">
                                <a class="btn btn-success" href="#">
                                    <i class="glyphicon glyphicon-zoom-in icon-white"></i>
                                    View
                                </a>
                                <a class="btn btn-info" href="#">
                                    <i class="glyphicon glyphicon-edit icon-white"></i>
                                    Edit
                                </a>
                                <a class="btn btn-danger" href="#">
                                    <i class="glyphicon glyphicon-trash icon-white"></i>
                                    Delete
                                </a>
                            </td>
                        </tr>

                        </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <script src="../vendor/js/js.js" type="text/javascript"></script>

</body>
</html>
</c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>