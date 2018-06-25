<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>List Book View</title>
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
    <%@include file="layout/headerUser.jsp" %>
    <div class="content-wrapper">
        <div class="container-fluid">
            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="redirectDashboardUser">Main menu</a>
                </li>
                <li class="breadcrumb-item active">BookList</li>
            </ol>
            <!-- Example DataTables Card-->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> Table List Book</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Description</th>
                                    <th>Cover</th>
                                   <!-- <th>Status</th> -->

                                    <th colspan="1">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listBook">
                                    <tr>
                                        <td><s:property value="%{title}" /></td>
                                        <td><s:property value="%{author}" /></td>
                                        <td><s:property value="%{description}" /></td>
                                        <td><img src="${pageContext.request.contextPath}/${image}" width="150px" height="230px" alt="Pic not found" ></td>
                                    <!--    <td><s:property value="%{status}" /></td>  -->

                                        <td>   
                                            <s:url var="bookDetail" action="redirectBookDetailUser">
                                                <s:param name="bid">${bid}</s:param>
                                            </s:url>
                                            <s:a href="%{#bookDetail}">Detail</s:a>
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
