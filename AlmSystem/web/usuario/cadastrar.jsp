<%-- 
    Document   : cadastrar
    Created on : 28/03/2020, 13:19:22
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

    <link href="${pageContext.request.contextPath}/vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="javascript/viacep.js" type="text/javascript"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <body>
        <header>
            <nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="btn btn-dark navbar-toggle pull-left">
                            <i class="oi oi-menu"></i>
                        </button>				
                        <a class="navbar-brand navbar-toggle pull-left" href="#">AlmSytem soluções em Almoxarifado</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="layout-main">

            <c:import url="../layout/menu.jsp"/>

            <section class="layout-content">
                <div class="page-header">
                    <nav class="navbar navbar-expand-md navbar-top bg-light">
                        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <i class="oi oi-caret-right"></i>
                                    <span>Cadastrar Usuário</span>
                                </li>
                            </ul>
                        </div>
                        <a class="btn btn-primary btn-md" href="#" role="button">
                            <span class="oi oi-spreadsheet" title="Cadastro" aria-hidden="true"></span>
                            <span>Listar Usuários</span>
                        </a>
                    </nav>
                </div>

                <div class="container" id="cadastro">
                    <form  action="${pageContext.request.contextPath}/CadastrarUsuario" method="POST">
                        <p class="text-center text-uppercase">${mensagem}</p>
                  
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nome">Nome Usuário</label>
                                <input type="text" class="form-control" id="nome" placeholder="Nome Completo"
                                       autofocus="autofocus" name="nome" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        <div class="form-group col-md-6">
                                <label for="salario">Tipo de Usuário</label>
                                <input type="text" class="form-control" id="salario" 
                                       name="tipo" />
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nome">Email</label>
                                <input type="email" class="form-control" id="nome" placeholder="digite o seu email"
                                       autofocus="autofocus" name="email" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="salario">Telefone</label>
                                <input type="phone" class="form-control" id=""  type="phone" name="telefone" required=""/> 



                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>
                          <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="nome">Login</label>
                                <input type="text" class="form-control" id="nome" placeholder="Crie um login de usuário"
                                       autofocus="autofocus" name="login" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="senha">Senha</label>
                                <input type="password" placeholder="Crie uma senha" class="form-control" id="salario" 
                                       name="senha" />
                                <div class="invalid-feedback">

                                </div>
                            </div>
                                  <div class="form-group col-md-4">
                                <label for="senha">Confirma Senha</label>
<!--                                <input type="password" placeholder="Confirma a senha" class="form-control" id="salario" /> -->
                                      
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>
                        <!------------------------------------------------------------------------------------------>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="cep">Cep</label>
     <input  placeholder="Apenas números" class="form-control input-md" required="" 
              name="cep"  id="cep" value="" type="search" maxlength="8" pattern="[0-9]+$" onblur="pesquisacep(this.value);" >

                            </div>

                            <div class="form-group col-md-6">
                                <label for="cidade">Cidade</label>
                                <input id="cidade" name="cidade" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="logradouro">Logradouro</label>
                                    <input id="rua" name="logradouro" class="form-control" placeholder="" required="" type="text">
                                    <div class="invalid-feedback">

                                    </div>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="bairro">Bairro</label>
                                    <input id="bairro" name="bairro" class="form-control" placeholder="" required=""  type="text">
                                    <div class="invalid-feedback">

                                    </div>   

                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="numero">Número</label>
                                        <input type="text" class="form-control" id="numero" name="endereco.numero" value=""/>
                                        <div class="invalid-feedback">

                                        </div>
                                    </div>

                                </div>
                                <div class="form-group col-md-2">
                                    <label for="uf">UF</label>
                                    <input id="estado" name="uf" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                                    <div class="invalid-feedback">

                                    </div>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="uf">País</label>
                                    <input id="pais" name="pais" class="form-control" placeholder="" required=""  type="text">
                                    <div class="invalid-feedback">

                                    </div>
                                </div>

                            </div>
                            <input type="hidden" id="id" name="id" value=""/>
                            <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                        </div>
                    </form>
                </div>
            </section>
        </div>

        
       

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="../vendor/js/js.js" type="text/javascript"></script>
        <script src="../vendor/js/viacep.js" type="text/javascript"></script>
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
