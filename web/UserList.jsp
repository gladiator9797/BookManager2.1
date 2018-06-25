<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>User List View</title>
    <!-- Favicon -->
    <link rel="icon" type="image/png" href="image/imgweb/favicon.png">
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
                    <a href="index.jsp">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">User List</li>
            </ol>
            <!-- Example DataTables Card-->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> User Data List</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <!-- Search User Form-->
                        <s:form action="searchUser" method="POST" cssClass="form-inline my-2 my-lg-0 mr-lg-2">
                            <s:textfield name = "searchString" cssClass="form-control" placeholder="Search for user..."></s:textfield>
                            <s:submit value = "Search" cssClass="btn btn-primary" type="button"/>
                        </s:form>
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Fullname</th>
                                    <th>Role</th>
                                    <th>Email</th>
                                    <th>Status</th>
                                    <th>Avatar</th>
                                    <th colspan="3">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listUser">
                                    <tr>
                                        <td><s:property value="%{username}" /></td>
                                        <td><s:property value="%{fullname}" /></td>
                                        <td><s:property value="%{role}" /></td>
                                        <td><s:property value="%{email}" /></td>
                                        <td><s:property value="%{status}" /></td>
                                        <td><img src="${pageContext.request.contextPath}/${avatar}" width="120px" height="120px" alt="Pic not found" ></td>
                                        <td>   
                                            <s:url var="userUpdate" action="redirectUserUpdateByAdmin">
                                                <s:param name="uid">${uid}</s:param>
                                            </s:url>
                                            <s:a href="%{#userUpdate}">Update</s:a>
                                            </td>


                                            <td>
                                            <s:url var="deactiveUser" action="deactiveUserAction">
                                                <s:param name="uid">${uid}</s:param>
                                            </s:url>
                                            <s:a href="%{#deactiveUser}">Delete</br>(Deactive)</s:a>
                                            </td>

                                            <td>
                                            <s:url var="activeUser" action="activeUserAction">
                                                <s:param name="uid">${uid}</s:param>
                                            </s:url>
                                            <s:a href="%{#activeUser}">Active</s:a>
                                            </td>
                                        </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
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
