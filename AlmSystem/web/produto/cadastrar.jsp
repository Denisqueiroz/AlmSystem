<%-- 
    Document   : cadastrarproduto
    Created on : 21/01/2020, 11:56:22
    Author     : Suporte
--%>

<%@page import="br.com.AlmSystem.model.Unidade"%>
<%@page import="java.util.List"%>
<%@page import="br.com.AlmSystem.model.Marca"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>



        <c:import url="../layout/head.jsp"/>

        <div class="layout-main">
            <c:import url="../layout/body.jsp"/>


            <section class="layout-content">
                <div class="page-header">
                    <nav class="navbar navbar-expand-md navbar-top bg-light">
                        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <i class="oi oi-caret-right"></i>
                                    <span>Cadastrar Produtos</span>
                                </li>
                            </ul>
                        </div>
                        <a class="btn btn-primary btn-md" href="ListarProduto" role="button">
                            <span class="oi oi-spreadsheet" title="Cadastro" aria-hidden="true"></span>
                            <span>Listar Produtos</span>
                        </a>
                    </nav>
                </div>
                <div class="container">
                    <!--------------------campo de cadastro----------------------------------------------------->
                    <p class="text-center text-uppercase">${mensagem}<p>
                    <div class="container" id="cadastro">
                        <form  name="SalvarProduto" action="SalvarProduto" method="POST">
                            <div class="form-row">

                                <div class="form-group col-md-2">
                                    <label for="cod">Codigo do Produto</label>
                                    <input type="text" class="form-control" id="idProduto" readonly=""
                                           value="${produto.idProduto}"   autofocus="autofocus" name="idProduto" value=""/>
                                    <div class="invalid-feedback">
                                    </div>
                                </div>


                                <div class="form-group col-md-8">
                                    <label for="descricaoProduto">Descrição do Produto</label>
                                    <input type="text" class="form-control" id="nome" placeholder="Digite a descrição"
                                           value="${produto.descricaoProduto}"  
                                           autofocus="autofocus" name="descricaoProduto" value=""/>
                                    <div class="invalid-feedback">

                                    </div>
                                </div>


                                <div class="form-group col-md-4">
                                    <label>Unidade de Medida</label>
                                    <select  class="form-control" name="idUnidade">
                                        <c:forEach var="unidade"  items="${unidades}">
                                            <option value="${unidade.idUnidade}"
                                                    ${unidade.idUnidade == produto.idUnidade ? 'selected': ''} >
                                                ${unidade.descUnidade}</option>
                                            </c:forEach>
                                    </select>                                                                            
                                </div>
                                <div class="clearfix"> </div>



                                <div class="form-group col-md-3">
                                    <label>Fornecedor </label>
                                    <select  class="form-control" name="idFornecedor">
                                        <c:forEach var="fornecedor"  items="${fornecedores}">
                                            <option value="${fornecedor.idFornecedor}"
                                                    ${fornecedor.idFornecedor == produto.idFornecedor ? 'selected': ''} >
                                                ${fornecedor.nomePessoa}</option>
                                            </c:forEach>
                                    </select>                                                                             
                                </div> 

                                <div class="clearfix"> </div>


                                <div class="form-group col-md-4">
                                    <label>Marca </label>
                                    <select  class="form-control" name="idMarca">
                                        <c:forEach var="marca"  items="${marcas}">
                                            <option value="${marca.idMarca}"
                                                    ${marca.idMarca == produto.idMarca ? 'selected': ''} >
                                                ${marca.nomeMarca}</option>
                                            </c:forEach>
                                    </select>                                                                            
                                </div>
                                <div class="clearfix"> </div>   

                            </div>
                            <input type="hidden" id="id" name="id" value=""/>
                            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                        </form>
                    </div>
            </section>

        </div>
 <c:import url="../layout/footer.jsp"/>

</html>
