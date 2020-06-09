<%-- 
    Document   : realtorios
    Created on : 09/06/2020, 17:00:01
    Author     : TBO-002
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>




        <link href="${pageContext.request.contextPath}/vendor/novo/css/bootstrap-cerulean.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/charisma-app.css" rel="stylesheet">
        <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
        <link href='${pageContext.request.contextPath}/bower_components/chosen/chosen.min.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/jquery.noty.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/noty_theme_default.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/elfinder.min.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/elfinder.theme.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/jquery.iphone.toggle.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/uploadify.css' rel='stylesheet'>
        <link href='${pageContext.request.contextPath}/css/animate.min.css' rel='stylesheet'>

    </head>
    <body>

    <li>
        <form class="navbar-search pull-left">
            <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                   type="text">
        </form>
    </li>

    <div class="box-content">

        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Date registered</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>David R</td>
                    <td class="center">2012/01/01</td>
                    <td class="center">Member</td>
                    <td class="center">
                        <span class="label-success label label-default">Active</span>
                    </td>
                    <td class="center">
                        <a class="btn btn-success" href="#">
                            <i class="glyphicon glyphicon-zoom-in icon-white"></i>
                            View
                        </a>
                        <a class="btn btn-info" href="#">
                            <i class="glyphicon glyphicon-edit icon-white"></i>
                            Edit
                        </a>
                        <a class="btn btn-danger" href="#">
                            <i class="glyphicon glyphicon-trash icon-white"></i>
                            Delete
                        </a>
                    </td>
                </tr>

                </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</div>
<!--/span-->

</div><!--/row-->
</body>
</html>
