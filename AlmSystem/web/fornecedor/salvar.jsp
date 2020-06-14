<%-- 
    Document   : forncedor
    Created on : 20/01/2020, 13:23:38
    Author     : Suporte
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <c:import url="../layout/head.jsp"/>
    <c:import url="../layout/body.jsp"/>
   
    <!--------------------campo de cadastro----------------------------------------------------->
       <h1>Cadastrar Fornecedor</h1>
    <section class="layout-content">
            
        <div class="container" id="cadastro">
            <form action="${pageContext.request.contextPath}/SalvarFornecedor"  method="POST" class="formulario"> 

                <p class="text-center text-uppercase">${mensagem}</p>
                <div class="form-row">

                    <div  class="form-group col-md-1" >
                        <label  for="idFornecedor">Id</label>
                        <input type="text" class="form-control" readonly="" id="nome" 
                               name="idFornecedor" value="${fornecedor.idFornecedor}" />
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="nomePessoa">Nome Fantasia</label>
                        <input type="text" class="form-control" id="nome" 
                               name="nomePessoa" value="${fornecedor.nomePessoa}" />
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-3"> 
                        <label for="inscricaoEstadual">Incrição Social</label>
                        <input type="text" class="form-control" id="nome" 
                               autofocus="autofocus" name="inscricaoEstadual" value="${fornecedor.inscricaoEstadual}"/>
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-4"> 
                        <label for="cnpj">Cnpj</label>
                        <input type="text" class="form-control" id="nome" placeholder="Digite aqui !"
                               autofocus="autofocus" name="cnpj" value="${fornecedor.cnpj}"/>
                        <div class="invalid-feedback">

                        </div>
                    </div>
                </div>

                <!----------------------------------------------------------------------------------------------->
                <div class="form-row">
                    <div class="form-group col-md-3"> 
                        <label for="tipoPessoa">Tipo</label>
                        <select  value="${fornecedor.tipoPessoa}" class="form-control" id="tipoPessoa" name="tipoPessoa" >
                            <option>Selecione</option>
                            <option>Pessoa Jurídica</option>
                            <option>Pessoa Física</option>
                            <option>Pessoa Estrangeiro</option>
                        </select>
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="emailPessoa">E-mail</label>
                        <input type="text" class="form-control" id="email" 
                               name="emailPessoa" value="${fornecedor.emailPessoa}" />
                        <div class="invalid-feedback">

                        </div>
                    </div>

                    <div class="form-group col-md-3"> 
                        <label for="telefonePessoa">Telefone</label>
                        <input type="text"   name="telefonePessoa" placeholder="(00) 0000-0000" 
                               class="form-control" id="telefone"    value="${fornecedor.telefonePessoa}"/> 

                        <div class="invalid-feedback">

                        </div>
                    </div>
                </div>
                <div class="form-row">          
                    <div class="form-group col-md-2">
                        <label for="cepPessoa">Cep</label>
                        <input  placeholder="Apenas números" class="form-control input-md" required="" value="${fornecedor.cepPessoa}"
                                name="cepPessoa"  id="cep" value="" type="search" size="10" maxlength="9"  onblur="pesquisacep(this.value);" >

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cidadePessoa">Cidade</label>
                            <input id="cidade" name="cidadePessoa" class="form-control" placeholder="" required="" 
                                   value="${fornecedor.cidadePessoa}"      type="text"/>
                            <div class="invalid-feedback">

                            </div>
                        </div>


                        <div class="form-group col-md-6">
                            <label for="logradouro">Logradouro</label>
                            <input id="rua" name="logradouroPessoa" value="${fornecedor.logadoroPessoa}"
                                   class="form-control"  required="" type="text">
                            <div class="invalid-feedback">

                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="bairro">Bairro</label>
                            <input id="bairro" name="bairroPessoa" value="${fornecedor.bairroPessoa}" 
                                   class="form-control" placeholder="" required=""  type="text">
                            <div class="invalid-feedback">

                            </div>   

                        </div>


                        <div class="form-group col-md-2">
                            <label for="numero">Número</label>
                            <input type="text" class="form-control" value="${fornecedor.numeroPessoa}" id="numero" name="numeroPessoa" value=""/>
                            <div class="invalid-feedback">

                            </div>
                        </div>         
                        <div class="form-group col-md-2">
                            <label for="uf">UF</label>
                            <input id="estado" name="ufPessoa" value="${fornecedor.ufPessoa}" class="form-control"
                                   placeholder="" required=""  type="text">
                            <div class="invalid-feedback">

                            </div>
                        </div>
                       <div class="form-group col-md-e"> 
                                        <label for="paisPessoa">País</label>
                                        <select  name="paisPessoa" class="form-control" id="paisPessoa" >
                                            <option>Selecione</option>
                                            <option value="brasil">Brasil</option>
                                            <option value="paraguay">Paraguay</option>
                                            <option value="bolivia">Bolívia</option>
                                        </select>
                                        <div class="invalid-feedback">

                                        </div>
                                    </div>
                    </div>
                </div>  
                <div class="form-row">
                    <button type="submit" class="btn btn-primary btn-sm">Salvar</button>

                </div>

            </form>

        </div>
    </section>

    <c:import url="../layout/footer.jsp"/>
    <script src="../vendor/js/js.js" type="text/javascript"></script>
    <script src="../vendor/js/viacep.js" type="text/javascript"></script>
</html>
