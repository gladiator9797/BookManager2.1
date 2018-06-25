<%-- 
    Document   : login
    Created on : Jun 18, 2018, 11:17:45 PM
    Author     : gladi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
                <!-- Favicon -->
        <link rel="icon" type="image/png" href="image/imgweb/favicon.png">
        <title>Login Book Manager</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body class="bg-dark">
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Book Manager System</div>
                <div class="card-body">
                    <s:form action="loginSession" method="POST" cssClass="form-group">
   
                        <s:textfield name = "username" label = "Username " cssClass="form-control" placeholder="Your username"></s:textfield>
                        <s:password name = "password" label = "Password " cssClass="form-control" placeholder="Your password"></s:password>

                        
                        <s:submit value ="Login" cssClass="btn btn-default"/>
                    </s:form>
                    <div class="text-center">
                    <!--    <a class="d-block small mt-3" href="register.html">Register an Account</a>
                        <a class="d-block small" href="forgot-password.html">Forgot Password?</a>   -->
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    </body>
</html>
