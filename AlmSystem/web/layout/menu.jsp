<%-- 
    Document   : menu2
    Created on : 09/06/2020, 17:17:34
    Author     : TBO-002
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <link  id="bs-css" href="vendor/novo/css/bootstrap-cerulean.min.css" rel="stylesheet" type="text/css"/>
   
   <link href="vendor/novo/css/charisma-app.css" rel="stylesheet" type="text/css"/>
   
    <link href='${pageContext.request.contextPath}/vendor/novo/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/vendor/novo/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${pageContext.request.contextPath}/vendor/novo/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/vendor/novo/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/vendor/novo/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/vendor/novo/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/jquery.noty.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/noty_theme_default.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/elfinder.theme.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/elfinder.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/jquery.iphone.toggle.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/uploadify.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/vendor/novo/css/animate.min.css" rel="stylesheet" type="text/css"/>

<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Fornecedores</li>
                         <li><a class="ajax-link" href="${pageContext.request.contextPath}/fornecedor/cadastrar.jsp"><span>Cadastro</span></a>
                         </li>
                        <li><a class="ajax-link" href="#"><span> Listar</span></a>
                        </li>
                     <li class="nav-header">Pprodutos</li>
                        <li><a class="ajax-link" href="${pageContext.request.contextPath}/DadosProduto"><span>Cadastrar</span></a>
                        </li>
                        <li><a class="ajax-link"  href="${pageContext.request.contextPath}/ListarProduto"><span>Listar</span></a>
                        </li>
                       <li class="nav-header hidden-md">Movimentação Item</li>
                        <li><a class="ajax-link" href="${pageContext.request.contextPath}/DadosItens"><span>Cadastrar</span></a>
                        </li>
                        <li><a class="ajax-link"  href="${pageContext.request.contextPath}/ListarItens"><span>Listar</span></a>
                        </li>
                         <li><a class="ajax-link" href="${pageContext.request.contextPath}/ListarEstoque"><span>Estoque</span></a>
                        </li>
                         <li><a class="ajax-link" href="${pageContext.request.contextPath}/ListarEstoque"><span>Relatorio</span></a>
                        </li>
                      
                     </ul>
                 
                </div>
            </div>
        </div>
                          
      </div>
  </div>
  <!-- external javascript -->
    <script src="vendor/novo/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- library for cookie management -->
    <script src="vendor/novo/js/jquery.cookie.js" type="text/javascript"></script>

    <!-- calender plugin -->
    <script src="vendor/novo/bower_components/moment/min/moment.min.js" type="text/javascript"></script>
    <script src="vendor/novo/fullcalendar/dist/fullcalendar.min.js" type="text/javascript"></script>

    <!-- data table plugin -->
    <script src="vendor/novo/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <!-- select or dropdown enhancer -->
    <script src="vendor/novo/bower_components/chosen/chosen.jquery.min.js" type="text/javascript"></script>

    <!-- plugin for gallery image view -->

    <script src="vendor/novo/colorbox/jquery.colorbox-min.js" type="text/javascript"></script>
    <!-- notification plugin -->
    <script src="vendor/novo/js/jquery.noty.js" type="text/javascript"></script>

    <!-- library for making tables responsive -->
    <script src="vendor/novo/responsive-tables/responsive-tables.js" type="text/javascript"></script>

    <!-- tour plugin -->
    <script src="vendor/novo/bootstrap-tour/build/js/bootstrap-tour.min.js" type="text/javascript"></script>

    <!-- star rating plugin -->

    <script src="vendor/novo/js/jquery.raty.min.js" type="text/javascript"></script>
    <!-- for iOS style toggle switch -->
    <script src="vendor/novo/js/jquery.iphone.toggle.js" type="text/javascript"></script>

    <!-- autogrowing textarea plugin -->
    <script src="vendor/novo/js/jquery.autogrow-textarea.js" type="text/javascript"></script>

    <!-- multiple file upload plugin -->
    <script src="vendor/novo/js/jquery.uploadify-3.1.min.js" type="text/javascript"></script>

    <!-- history.js for cross-browser state change on ajax -->

    <script src="vendor/novo/js/jquery.history.js" type="text/javascript"></script>
    <!-- application script for Charisma demo -->

    <script src="vendor/novo/js/charisma.js" type="text/javascript"></script>                       
                        

</html>