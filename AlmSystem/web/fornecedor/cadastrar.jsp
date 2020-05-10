<%-- 
    Document   : forncedor
    Created on : 20/01/2020, 13:23:38
    Author     : Suporte
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Fornecedores</title>
    </head>

    <link href="${pageContext.request.contextPath}/vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="../vendor/js/viacep.js" type="text/javascript"></script>
    <script src="../vendor/js/js.js" type="text/javascript"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="../vendor/js/viacep.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous"></script>

    <body>

        <c:import url="../layout/header.jsp"/>

        <div class="layout-main">

            <c:import url="../layout/menu.jsp"/> 


            <!--------------------campo de cadastro----------------------------------------------------->
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
                                <div class="form-group col-md-2">
                                    <label for="uf">País</label>
                                    <input id="pais" name="paisPessoa" value="${fornecedor.paisPessoa}" class="form-control" placeholder="" required=""  type="text">
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



            <!-- Bootstrap core JavaScript
            ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <script type="text/javascript">

                                            $(function () {
                                                $('[data-toggle="popover"]').popover();
                                            });

                                            $(document).ready(function () {
                                                $(".navbar-toggle").click(function () {
                                                    $(".sidebar").toggleClass("sidebar-open");
                                                })
                                            });

            </script>
    </body>
</html>