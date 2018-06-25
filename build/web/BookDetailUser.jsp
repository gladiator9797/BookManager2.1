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
        <title>Book Detail User</title>
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
                    <li class="breadcrumb-item active">Book Detail User</li>
                </ol>

                <!-- Do something here -->
                <table class="table table-dark" >
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Image</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Description</th>

                    <!--    <th colspan="1">Action</th>   -->
                    </tr>
                    <s:iterator var="b" value="book" status="number">    
                        <tr>
                            <td><s:hidden value="#number.count" /></td>
                            <td><s:hidden value="%{book.bid}" /></td>
                            <td><img src="<s:property value="%{book.image}" />" width="200px" height="250px" alt="Pic not found" ></td>
                            <td><s:property value="%{book.title}" /></td>
                            <td><s:property value="%{book.author}" /></td>
                            <td><s:property value="%{book.price}" /> VNĐ</td>
                            <td><s:property value="%{book.description}" /></td>



                    <!--        <td>
                                <s:url var="bookComment" action="bookComment">
                                    <s:param name="bid">${bid}</s:param>
                                </s:url>
                                <s:a href="%{#bookComment}">Comment</s:a>
                                </td>
                            </tr>    -->
                    </s:iterator>

                    <%--Show List Comment--%>
                    <table class="table table-hover" >
                        <tr>
                            <th>No</th>
                            <th></th>
                            <th>Avatar</th>
                            <th>Username</th>
                            <th>Comment</th>
                            <th>Date</th>

                        </tr>
                        <s:iterator var="C" value="listComment" status="number">    
                            <tr>
                                <td><s:property value="#number.count" /></td>
                                <td><s:hidden value="%{bid}" /></td>
                                <td><img src="<s:property value="%{avatar}" />" width="50px" height="50px" alt="Pic not found" ></td>
                                <td><s:property value="%{username}" /></td>
                                <td><s:property value="%{comment}" /></td>
                                <td><s:property value="%{createdDate}" /></td>

                            </tr>
                        </s:iterator>

                    </table>  
                    <%--End Show List Comment--%>


                </table> 
                <%--End Show Book Detail--%>

                <!--Begin comment box -->
                <center>
                    <s:form action="addComment" method="POST" cssClass="form-horizontal" >
                        <s:hidden name = "bid" value="%{listComment.bid}" />
                        <div class="form-group">
                            <div class="col-sm-10">
                                <s:textarea name = "comment" label = "Comment" cssClass="form-control" placeholder="Type your comment" rows="3" cols="100"></s:textarea>
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                <s:div cssClass="input-group">
                                    <s:div cssClass="wrapper">
                                        <s:div cssClass="group-btn">
                                            <s:param value="listBook" name="bid">${bid}</s:param>
                                            <s:submit value ="Submit" cssClass="btn btn-default"/>
                                        </s:div>
                                    </s:div>
                                </s:div>
                            </div>
                        </div>
                    </s:form>
                </center> 
                <!--End comment box -->
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
