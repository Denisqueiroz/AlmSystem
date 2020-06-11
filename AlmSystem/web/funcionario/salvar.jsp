<%-- 
    Document   : salvar
    Created on : 11/06/2020, 11:17:38
    Author     : TBO-002
--%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${funcionario.tipoPessoa eq 'administrador'}">
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
                                    <span>Cadastrar Funcionario</span>
                                </li>
                            </ul>
                        </div>
                        <a class="btn btn-primary btn-md" href="#" role="button">
                            <span class="oi oi-spreadsheet" title="Cadastro" aria-hidden="true"></span>
                            <span>Listar Funcionario</span>
                        </a>
                    </nav>
                </div>

                <div class="container" id="cadastro">
                    <form  action="${pageContext.request.contextPath}/SalvarFuncionario" method="POST">
                        <p class="text-center text-uppercase">${mensagem}</p>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="nome">Nome Completo</label>
                                <input type="text" class="form-control" id="nome" placeholder="Nome Completo"
                                       autofocus="autofocus" name="nomePessoa" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>

                            <div class="form-group col-md-2">
                                <label for="cpf">Cpf</label>
                                <input type="text" class="form-control" id="cpf" 
                                       name="cpf" />
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-3"> 
                                <label for="tipoPessoa">Tipo de Usuário</label>
                                <select  value="${fornecedor.tipoPessoa}" class="form-control" id="tipoPessoa" name="tipoPessoa" >
                                    <option>Selecione</option>
                                    <option value="funcionario">Funcionario</option>
                                    <option value="fornecedor">Fornecedor</option>
                                    <option value="administrador">Administrador do Sistema</option>
                                </select>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="nome" placeholder="digite o seu email"
                                       autofocus="autofocus" name="emailPessoa" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="telefone">Telefone</label>
                                <input type="phone" class="form-control" id="telefone"  type="phone" name="telefonePessoa" required=""/> 



                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" id="nome" placeholder="Crie um login de usuário"
                                       autofocus="autofocus" name="login" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="senha">Senha</label>
                                <input type="password" placeholder="Crie uma senha" class="form-control" id="password" 
                                       name="senha" />
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="senha">Confirma Senha</label>
                                <input type="password"   placeholder="Confirme Senha" id="confirm_password" class="form-control" required>

                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>
                        <!------------------------------------------------------------------------------------------>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="cep">Cep</label>
                                <input  placeholder="Apenas números" class="form-control input-md" required="" 
                                        name="cepPessoa"  id="cep"  type="search" maxlength="9" pattern="[0-9]+$" onblur="pesquisacep(this.value);" >

                            </div>

                            <div class="form-group col-md-5">
                                <label for="cidade">Cidade</label>
                                <input id="cidade" name="cidadePessoa" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
                                <div class="invalid-feedback">

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-5">
                                    <label for="logradouro">Logradouro</label>
                                    <input id="rua" name="logradoroPessoa" class="form-control" placeholder="" required="" type="text">
                                    <div class="invalid-feedback">

                                    </div>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="bairro">Bairro</label>
                                    <input id="bairro" name="bairroPessoa" class="form-control" placeholder="" required=""  type="text">
                                    <div class="invalid-feedback">

                                    </div>   

                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="numero">Número</label>
                                        <input type="text" class="form-control" id="numero" name="numeroPessoa"/>
                                        <div class="invalid-feedback">

                                        </div>
                                    </div>


                                    <div class="form-group col-md-2">
                                        <label for="uf">UF</label>
                                        <input id="estado" name="ufPessoa" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
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
                                    <div class="form-group col-md-1">
                                        <label for="uf">Id</label>
                                        <input id="id" value="${funcionario.idFuncionario}" name="idFuncionario" class="form-control" placeholder=""  readonly="readonly" type="text">
                                        <div class="invalid-feedback">

                                        </div>
                                    </div>
                                    <input type="hidden" id="id" name="id" value=""/>
                                    <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                                </div>

                            </div>

                            <button type="submit" class="btn btn-primary btn-sm">Limpar</button>
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

                                            $(document).ready(function () {
                                                $('.popup-with-zoom-anim').magnificPopup({
                                                    type: 'inline',
                                                    fixedContentPos: false,
                                                    fixedBgPos: true,
                                                    overflowY: 'auto',
                                                    closeBtnInside: true,
                                                    preloader: false,
                                                    midClick: true,
                                                    removalDelay: 300,
                                                    mainClass: 'my-mfp-zoom-in'
                                                });

                                                var password = document.getElementById("password")
                                                        , confirm_password = document.getElementById("confirm_password");

                                                function validatePassword() {
                                                    if (password.value != confirm_password.value) {
                                                        confirm_password.setCustomValidity("Senhas diferentes!");
                                                    } else {
                                                        confirm_password.setCustomValidity('');
                                                    }
                                                }

                                                password.onchange = validatePassword;
                                                confirm_password.onkeyup = validatePassword;

                                                $(document).ready(function () {
                                                    $('#showPassword').on('click', function () {

                                                        var passwordField = $('#password');
                                                        var passwordFieldType = passwordField.attr('type');
                                                        if (passwordFieldType == 'password')
                                                        {
                                                            passwordField.attr('type', 'text');
                                                            $(this).val('Hide');
                                                        } else {
                                                            passwordField.attr('type', 'password');
                                                            $(this).val('Show');
                                                        }
                                                    });
                                                });
                                            });




                                            password.onchange = validatePassword;
                                            confirm_password.onkeyup = validatePassword;

        </script>

    </body>
</html>
</c:when>
    <c:otherwise>
        <c:redirect url="../index.jsp"></c:redirect>
    </c:otherwise>
</c:choose>