<%-- 
    Document   : listar
    Created on : 13/06/2020, 18:33:02
    Author     : TBO-002
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">


    <c:import url="../layout/head.jsp"/>

    <c:import url="../layout/body.jsp"/>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header"><
                
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
                                    <th>Alterar</th>
                                    <th>Excluir</th>

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


                                        <td><a href="CarregarFornecedor?idFornecedor=${fornecedor.idFornecedor}"><button type="button">
                                                    <span class="oi oi-aperture" title="Alterar Fornecedor" ></span>
                                                </button></a></td>                  


                                        <td><a href="ExcluirFornecedor?idFornecedor=${fornecedor.idFornecedor}"><button type="button">
                                                    <span class="oi oi-circle-x" title="Excluir Fornecedor" aria-hidden="true"></span>
                                                </button></a></td>    




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


</body>
</html>
