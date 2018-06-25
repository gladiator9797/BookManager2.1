<%-- 
    Document   : header
    Created on : Jun 18, 2018, 11:08:22 PM
    Author     : gladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <a class="navbar-brand" href="redirectDashboard">Book Manager</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Main Menu">
                        <a class="nav-link" href="redirectDashboard">
                            <i class="fa fa-fw fa-dashboard"></i>
                            <span class="nav-link-text">Dashboard</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="List Book">
                        <a class="nav-link" href="showAllListBook">
                            <i class="fa fa-book"></i>
                            <span class="nav-link-text">List Book</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="List User">
                        <a class="nav-link" href="showListUser">
                            <i class="fa fa-fw fa-table"></i>
                            <span class="nav-link-text">List User</span>
                        </a>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
                            <i class="fa fa-book"></i>
                            <span class="nav-link-text">Book</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseComponents">
                            <li>
                                <a href="redirectAddBook">Add New Book</a>
                            </li>
                            <li>
                                <a href="showAllListBook">View List Book</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
                            <i class="fa fa-user-o"></i>
                            <span class="nav-link-text">User</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                            <li>
                                <a href="redirectAddUser">Add New User</a>
                            </li>
                            <li>
                                <a href="showListUser">View List User</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                        <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
                            <i class="fa fa-user-secret"></i>
                            <span class="nav-link-text">Admin Zone</span>
                        </a>
                        <ul class="sidenav-second-level collapse" id="collapseMulti">
                            <li>
                                <a href="showInfoAdmin">Admin Information</a>
                            </li>
                            <li>
                                <a href="redirectAdminChangePassword">Change Password</a>
                            </li>
                            <li>
                                <a href="redirectBackUp">Backup Code</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
                        <a class="nav-link" href="#">
                            <i class="fa fa-fw fa-link"></i>
                            <span class="nav-link-text">Link</span>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item">
                        <a class="nav-link text-center" id="sidenavToggler">
                            <i class="fa fa-fw fa-angle-left"></i>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <!--drop down component-->

                    <li class="nav-item">
                        <a class="btn btn-primary" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>
