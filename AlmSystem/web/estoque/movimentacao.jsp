<%-- 
    Document   : movimentacao
    Created on : 29/05/2020, 09:18:38
    Author     : TBO-002
--%>

<%@page import="br.com.AlmSystem.model.Item"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<c:choose>
    <c:when test="${funcionario.tipoPessoa eq 'administrador'}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Movimentar Itens</title>
</head>

<c:import url="../layout/header.jsp"/>


<form action="${pageContext.request.contextPath}/AtualizarItem"  method="POST" class="formulario"> 

    <div class="container">
        <div class="form-row">
            <div class="form-group col-md-1"> 
                <label for="retirada">Codigo</label>
                <input type="number" class="form-control" id="idItem" 
                       readonly   name="idItem" value="${item.idItem}" />
            </div>
           
            <div class="form-group col-md-2">
                <label for="operacaoItem">Movimentação</label>
                <select id="operacaoItem" class="form-control" name="operacaoItem">
                    <option value="">Selecione</option>
                    <option id="operacaoItem1" value="2">Estorna</option>
                    <option value="1">Retirar</option>

                </select>
            </div>

            <div class="form-group col-md-3"> 
                <label for="descricaoProduto">Descrição do Produto</label>
                <input type="text" class="form-control" id="nome" placeholder="Digite a descrição"
                       readonly    value="${item.produto.descricaoProduto}"  
                       autofocus="autofocus" name="descricaoProduto" value=""/>
            </div>


            <div class="form-group col-md-2"> 
                <label for="retirada">Quantidade Dispónivel</label>
                <input type="number" class="form-control" id="saldoItem" 
                       readonly   name="quantidadeItem" value="${item.quantidadeItem}" />
            </div>

            <div class="form-group col-md-2"> 
                <label for="retiradaItem"> Quantidade </label>
                <input type="number" class="form-control" id="retiradaItem" 
                       name="retiradaItem" value="" />

            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
    </div>
</form>

<!-- <a href="#" class="card-link" data-toggle="modal" data-target="#siteModal">Chama</a>-->

<!--Modal -->

<div class="modal fade" id="siteModal" tabindex="-1" role=" dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">Fusce ac crusus nisi</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span>X</span></button>
            </div>

            <div class="modal-body">
                <p>Teste aleluia vai funcionar  osssssaaaaa</p>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-danger" data-dismiss="modal">Donec</button>
            </div>

        </div>
    </div>
</div>
<script>
    $('#operacaoItem').on('change', function () {
        $('#siteModal').modal('toggle')
    })

</script>

  </c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>