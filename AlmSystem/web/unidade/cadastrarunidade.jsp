<%-- 
    Document   : cadastrarunidade
    Created on : 21/01/2020, 17:12:44
    Author     : Suporte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Unidades de Medida</title>
    </head>
   
    <link href="vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

            <aside>
                <nav class="sidebar  sidebar-open">
                    <ul class="nav nav-pills">
                        <li class="nav-item"><a class="nav-link " href="/"> <i
                                    class="oi oi-home"></i> <span>Home</span>
                            </a></li>
                    </ul>

                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active">Departamentos</span></li>
                        <li class="nav-item"><a class="nav-link"
                        href="/departamentos/cadastrar"> <i class="oi oi-plus"></i>
                                <span>Cadastrar</span>
                            </a></li>
                        <li class="nav-item"><a class="nav-link"
                                                href="/departamentos/listar"> <i class="oi oi-spreadsheet"></i>
                                <span>Listar </span>
                            </a></li>
                    </ul>

                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active">Cargos</span></li>
                        <li class="nav-item"><a class="nav-link"
                                                href="/cargos/cadastrar"> <i class="oi oi-plus"></i> <span>Cadastrar </span>
                            </a></li>
                        <li class="nav-item"><a class="nav-link"
                                                href="/cargos/listar"> <i
                                    class="oi oi-spreadsheet"></i> <span>Listar </span>
                            </a></li>
                    </ul>

                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active">Produtos</span></li>
                        <li class="nav-item"><a class="nav-link"
                                                href="DadosUnidade"> <i class="oi oi-plus"></i>
                                <span>Cadastrar </span>
                            </a></li>
                        <li class="nav-item"><a class="nav-link"
                                                href="/funcionarios/listar"> <i class="oi oi-spreadsheet"></i>
                                <span>Listar </span>
                            </a></li>
                    </ul>
                </nav>
            </aside>

            <section class="layout-content">
                <div class="page-header">
                    <nav class="navbar navbar-expand-md navbar-top bg-light">
                        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <i class="oi oi-caret-right"></i>
                                    <span>Cadastrar Fornecedores</span>
                                </li>
                            </ul>
                        </div>
                        <a class="btn btn-primary btn-md" href="/funcionarios/listar" role="button">
                            <span class="oi oi-spreadsheet" title="Cadastro" aria-hidden="true"></span>
                            <span>Listar Produtos</span>
                        </a>
                    </nav>
                </div>
                <!--------------------campo de cadastro----------------------------------------------------->
               <p class="text-center text-uppercase">${mensagem}<p>
                <div class="container" id="cadastro">
                    <form  name="CadastrarUnidade" action="CadastrarUnidade" method="POST">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="nomemarca">Unidade de Medida</label>
                                <input type="text" class="form-control" id="nome" placeholder="Digite unidade de medida"
                                       autofocus="autofocus" name="descri" value=""/>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </di>
                        </div>  
                <input type="hidden" id="id" name="id" value=""/>
                <button type="submit" class="btn btn-primary btn-sm">Salvar</button>
                </form>
        </div>
    </section>

</div>

<footer class="layout-footer">
    <div class="container">
        <span class="footer-copy">&copy; 2020 Denis Queiroz. Todos os direitos reservados.</span>
    </div>
</footer>	

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
