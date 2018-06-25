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
        <title>Admin Book Manager System</title>
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
        <%@include file="layout/header.jsp" %>
        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="redirectDashboard">Dashboard</a>
                    </li>
                    <li class="breadcrumb-item active">My Dashboard</li>
                </ol>
                <h2 class="breadcrumb-item active">Welcome back, <i>${sessionScope.fullname}</i></h2></br>
                <!-- Icon Cards-->
                <div class="row">
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-primary o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-id-card-o"></i>
                                </div>
                                <div class="mr-5">User Management</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="showListUser">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-warning o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-book"></i>
                                </div>
                                <div class="mr-5">Book Management</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="showAllListBook">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-success o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-user-secret"></i>
                                </div>
                                <div class="mr-5">Admin Information</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="showInfoAdmin">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-3 col-sm-6 mb-3">
                        <div class="card text-white bg-danger o-hidden h-100">
                            <div class="card-body">
                                <div class="card-body-icon">
                                    <i class="fa fa-fw fa-support"></i>
                                </div>
                                <div class="mr-5">Backup Project</div>
                            </div>
                            <a class="card-footer text-white clearfix small z-1" href="redirectBackUp">
                                <span class="float-left">View Details</span>
                                <span class="float-right">
                                    <i class="fa fa-angle-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
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
                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
                    <!-- Custom scripts for all pages-->
                    <script src="js/sb-admin.min.js"></script>
                    <!-- Custom scripts for this page-->
                    <script src="js/sb-admin-datatables.min.js"></script>
                </div>
                </body>
                </html>
