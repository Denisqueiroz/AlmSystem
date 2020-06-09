<%-- 
    Document   : menu
    Created on : 27/03/2020, 16:02:33
    Author     : TBO-002
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="${pageContext.request.contextPath}/vendor/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <aside>
        <nav class="sidebar sidebar-open">
            <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link " href="../principal/principal.jsp"> <i
                            class="oi oi-home"></i> <span>Home</span>
                    </a></li>
            </ul>

            <ul class="nav nav-pills">
                <li class="nav-item"><span class="nav-link active" >Funcionários</span></li>
                <li class="nav-item"><a class="nav-link"
                                        href="usuario/cadastrar.jsp"> <i class="oi oi-plus"></i> <span>Cadastrar</span>
                    </a></li>
                <li class="nav-item"><a class="nav-link"
                                        href="#"> <i class="oi oi-spreadsheet"></i>
                        <span>Listar </span>
                    </a></li>
            </ul>

            <ul class="nav nav-pills">
                <li class="nav-item"><span class="nav-link active" >Fornecedores</span></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/fornecedor/cadastrar.jsp"> <i class="oi oi-plus"></i> <span>Cadastrar </span>
                    </a></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/ListarFornecedor"> <i
                            class="oi oi-spreadsheet"></i> <span>Listar </span>
                    </a></li>
            </ul>

            <ul class="nav nav-pills">
                <li class="nav-item"><span class="nav-link active">Produtos</span></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/DadosProduto"> <i class="oi oi-plus"></i> <span>Cadastrar </span>
                    </a></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/ListarProduto"> <i class="oi oi-spreadsheet"></i> <span>Listar </span>
                    </a></li>
            </ul>

            <ul class="nav nav-pills">
                <li class="nav-item"><span class="nav-link active" >Movimentação</span></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/DadosItens"> <i class="oi oi-plus"></i> <span>Cadastrar Item</span>
                    </a></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/ListarItens"> <i
                            class="oi oi-spreadsheet"></i> <span>Consultar Item</span>
                    </a></li>
                <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/ListarEstoque"> <i
                            class="oi oi-spreadsheet"></i> <span>Estoque Item</span>
                    </a></li>
                     <li class="nav-item"><a class="nav-link" 
                                        href="${pageContext.request.contextPath}/ListarEstoque"> <i
                            class="oi oi-spreadsheet"></i> <span>Relatorio Item</span>
                    </a></li>

            </ul>   



        </nav>
    </aside>
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
</html>
