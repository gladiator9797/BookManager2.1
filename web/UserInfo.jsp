<%-- 
    Document   : index
    Created on : Jun 18, 2018, 11:03:27 PM
    Author     : gladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Favicon -->
        <link rel="icon" type="image/png" href="image/imgweb/favicon.png">
        <title>User Information</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <!-- Navigation-->
        <%@include file="layout/headerUser.jsp" %>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="redirectDashboardUser">Main menu</a>
                    </li>
                    <li class="breadcrumb-item active">User Information</li>
                </ol>

                <!-- Do something here -->
                <center><h1>User Information</h1></center>
                <table class="table table-hover">
                    <tr>
                        <th>Avatar</th>
                        <th>Username</th>
                        <th></th>
                        <th>Fullname</th>
                        <th>Email</th>
                        <th></th>
                        <th colspan="1">Action</th>
                    </tr>

                    <tr>
                        <td><img src="<s:property value="%{user.avatar}" />" alt="Pic not found" width="120px" height="120px"></td>
                        <td><s:property value="%{user.username}" /></td>
                        <td><s:hidden value="%{user.role}" /></td>
                        <td><s:property value="%{user.fullname}" /></td>
                        <td><s:property value="%{user.email}" /></td>
                        <td><s:hidden value="%{user.status}" /></td>
                        <td>
                            <s:url var="userChangeInfo" action="redirectUserUpdate">
                                <s:param name="uid">${user.uid}</s:param>
                            </s:url>
                            <s:a href="%{#userChangeInfo}">Change Info</s:a>
                            </td>
                        </tr>

                    </table>
                    <div class="row">
                        <div class="col-lg-8">

                        </div>
                        <!-- /.container-fluid-->
                        <!-- /.content-wrapper-->
                    <%@include file="layout/footer.jsp" %>
                    <!-- Scroll to Top Button-->
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fa fa-angle-up"></i>
                    </a>

                    <!-- Bootstrap core JavaScript-->
                    <script src="vendor/jquery/jquery.min.js"></script>
                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                    <!-- Core plugin JavaScript-->
                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
                    <!-- Page level plugin JavaScript-->
                    <script src="vendor/chart.js/Chart.min.js"></script>
                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
                    <!-- Custom scripts for all pages-->
                    <script src="js/sb-admin.min.js"></script>
                    <!-- Custom scripts for this page-->
                    <script src="js/sb-admin-datatables.min.js"></script>
                    <script src="js/sb-admin-charts.min.js"></script>
                </div>
                </body>
                </html>
