<%-- 
    Document   : listar
    Created on : 13/06/2020, 18:33:02
    Author     : TBO-002
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AdminLTE 3 | Simple Tables</title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
    </head>
    <c:import url="../layout/body.jsp"/>
     <div class="wrapper">
    <!-- /.card-header -->
    <div class="card-body table-responsive p-0" style="height: 300px;">
        <table class="table table-head-fixed text-nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Cnpj</th>
                    <th>Nome Fansia</th>
                    <th>Inscrição Estadual:</th>
                    <th>Tipo</th>
                    <th>E-mail</th>
                    <th>Telefone</th>

                </tr>
            </thead>
            <tbody>

                <c:forEach var="fornecedor" items="${fornecedores}">

                    <tr>
                        <td >${fornecedor.idFornecedor}</td>
                        <td >${fornecedor.cnpj}</td>
                        <td>${fornecedor.nomePessoa}</td>
                        <td>${fornecedor.inscricaoEstadual}</td>
                        <td >${fornecedor.tipoPessoa}</td>
                        <td >${fornecedor.emailPessoa}</td>
                        <td >${fornecedor.telefonePessoa}</td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
        </div>

 </div>

        <!-- Control Sidebar Alinzar o comportamento da  pagina-->
        <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
      </aside>  

    
    <c:import url="../layout/footer.jsp"/>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/vendor/vendors/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="${pageContext.request.contextPath}/vendor/vendors/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/vendor/vendors/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/vendor/vendors/dist/js/demo.js"></script>
</body>
</html>
