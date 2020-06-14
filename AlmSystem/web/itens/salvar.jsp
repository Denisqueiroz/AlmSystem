<%-- 
    Document   : salvar
    Created on : 08/04/2020, 16:57:02
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Fornecedores</title>
    </head>
    <body>
        <c:import url="../layout/head.jsp"/>
        <div class="layout-main">
            <c:import url="../layout/body.jsp"/> 
            <section class="layout-content">

                <div class="container" id="cadastro">
                    <form action="${pageContext.request.contextPath}/SalvarItem"  method="POST" enctype="multipart/form-data"  class="formulario"> 
                        <p class="text-center text-uppercase">${mensagem}</p>
                        <div class="form-row">
                            <div  class="form-group col-md-2" >
                                <label  for="idIidItem">Codigo do Item</label>
                                <input type="text" class="form-control" readonly="" id="idItens" 
                                       placeholder=""  name="idItem" value="${item.idItem}" />
                                <div class="invalid-feedback">

                                </div>
                            </div>

                            <div  class="form-group col-md-2" >
                                <label  for="idProduto">Codigo do Produto</label>
                                <input type="text" class="form-control" id="idProduto" 
                                       name="idProduto" value="${item.idProduto}" />
                                <div class="invalid-feedback">

                                </div>
                            </div>    

                            <div class="form-group col-md-2">
                                <label for="quantidadeItem"> Inserir Quantidade </label>
                                <input type="number" class="form-control" id="saldoItem" 
                                       name="quantidadeItem" value="${item.quantidadeItem}" />
                                <div class="invalid-feedback">

                                </div>
                            </div>

                            <div class="form-group col-md-3"> 
                                <label for="dataCompraItem">Data da Compra</label>
                                <input type="date" class="form-control" id="dataCompraItem" 
                                       autofocus="autofocus" name="dataCompraItem" value="${item.dataCompraItem}"/>
                                <div class="invalid-feedback">

                                </div>
                            </div>

                            <div class="form-group col-md-3"> 
                                <label for="dataValidadeItem">Data Vencimento do Produto</label>
                                <input type="date" class="form-control" id="dataValidadeItem" 
                                       autofocus="autofocus" name="dataValidadeItem" value="${item.dataValidadeItem}"/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
      <div class="form-group">
      <label  custom-file-label for="notafiscai">Nota Fiscal: </label>
      <div class="input-group">
          <div class="custom-file">
      <input type="file" value="${item.notafiscal}" 
              name="notafiscal" id="notafiscal" placeholder="Nota Fiscal" /><br />     
        

      </div>
      </div>
      </div>
         <!----------------------------------------->
         
                

                        </div>
                        <div class="form-row">
                            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>

                        </div>



                    </form>

                  
            </section>
        </div>





    </body>
</html>
