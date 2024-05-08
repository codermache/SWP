<%-- 
    Document   : viewVoucher
    Created on : Feb 24, 2023, 7:57:46 AM
    Author     : win
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <meta name="author" content="https://www.Zerotheme.com">

        <title>Thông tin khách hàng</title>

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css"  type="text/css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="../css/style.css">


        <!-- Custom Fonts -->
        <link rel="stylesheet" href="../font-awesome/css/font-awesome.min.css"  type="text/css">
        <link rel="stylesheet" href="../fonts/font-slider.css" type="text/css">

        <!-- jQuery and Modernizr-->
        <script src="../js/jquery-2.1.1.js"></script>

        <!-- Core JavaScript Files -->  	 
        <script src="../js/bootstrap.min.js"></script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
            }

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
            label{
                color: black;
            }

            /* Set a style for all buttons */
            button {
                background-color: #04AA6D;
                color: white;
                padding: 8px 20px;
                margin: 7px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 80%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {
                    -webkit-transform: scale(0)
                }
                to {
                    -webkit-transform: scale(1)
                }
            }

            @keyframes animatezoom {
                from {
                    transform: scale(0)
                }
                to {
                    transform: scale(1)
                }
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>

    <body>
        <!--Top-->
        <nav id="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="top-link">
                            <c:if test="${sessionScope.user == null}">
                                <button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Login</button>           
                            </c:if>
                            <c:if test="${sessionScope.user != null}">
                                <a href="../logout"> Log Out | </a>  
                            </c:if>


                            <div id="id01" class="modal">

                                <form class="modal-content animate" action="home" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                                        <img src="img_avatar2.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container">
                                        <label for="uname"><b>Email</b></label>
                                        <input type="text" style="color:black;" placeholder="Enter Email" name="email" required>

                                        <label for="psw"><b>Password</b></label>
                                        <input type="password" style="color:black;" placeholder="Enter Password" name="password" required>

                                        <button type="submit">Login</button>
                                        <label>
                                            <input type="checkbox" checked="checked" name="remember"> Remember me
                                            </br>
                                            <span style="color:black;">Do not have an account? <a style="color:black;" href="signup">Sign up now</a></span>
                                        </label>
                                    </div>

                                    <div class="container" style="background-color:#f1f1f1">
                                        <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Cancel</button>
                                        <span style="color:black;" class="psw" >Forgot <a style="color:black;" href="reset">password?</a></span>
                                    </div>
                                </form>
                            </div>

                            <script>
                                // Get the modal
                                var modal = document.getElementById('id01');

                                // When the user clicks anywhere outside of the modal, close it
                                window.onclick = function (event) {
                                    if (event.target == modal) {
                                        modal.style.display = "none";
                                    }
                                }
                            </script>

                            <li><a href="login"><span class="glyphicon glyphicon-user"></span> My Account</a>
                                <ul class="sub-my-account">
                                    <li><a href="../profile/view"> My profile</a></li>
                                    <li><a href="../profile/edit">Edit Profile</a></li>
                                    <li>View My Tour</li>
                                    <li>Log Out</li>
                                </ul>
                            </li>
                            <li><a href="../travelnet/contact"><span class="glyphicon glyphicon-envelope"></span> Contact</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <!--Header-->
        <header >
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div id="logo"><img src="../image/Logo/logo.png" /></div>
                    </div>
                    <div class="col-md-6" >
                        <form class="form-search" style="display:flex;">  
                            <input style="margin-top:2px;" type="text" class="input-medium search-query">
                            <div> 
                                <button style="margin-left:5px;"type="submit" class="glyphicon glyphicon-search"></button>  </div>
                            <div style="margin-left: 30px; margin-top: 20px;"> <a href="cart.html"><span class="glyphicon glyphicon-shopping-cart"></span>CART</a> </div>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <!--Navigation-->
        <nav id="menu" class="navbar">
            <div class="container">
                <div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
                    <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Category</a>
                            <div class="dropdown-menu">
                                <div class="dropdown-inner">
                                    <ul class="list-unstyled">
                                        <c:forEach var="o" items="${lstCate}">                                                                              
                                            <li> <a href="listtourbycategory?categoryid=${o.tour_category_id}">${o.tour_category_name}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <c:if test="${sessionScope.user.role_id == 4}">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Service</a>
                                <div class="dropdown-menu">
                                    <div class="dropdown-inner">
                                        <ul class="list-unstyled">
                                            <li><a href="../hotel/list">Hotel</a></li>
                                            <li><a href="">Restaurant</a></li>
                                            <li><a href="category.html">Vehicle</a></li>
                                            <!--                                        <li><a href="category.html">Text 204</a></li>
                                                                                    <li><a href="category.html">Text 205</a></li>-->
                                        </ul>
                                    </div> 
                                </div>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user.role_id == 4}">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Booking(Kien)</a>
                                <div class="dropdown-menu" style="margin-left: -203.625px;">
                                    <div class="dropdown-inner">
                                        <ul class="list-unstyled">
                                            <li><a href="create">Create Tour</a></li>
                                            <li><a href="category.html">Edit Tour</a></li>
                                            <li><a href="category.html">Delete Tour</a></li>
                                            <li><a href="category.html">Text 304</a></li>
                                            <li><a href="category.html">Text 305</a></li>
                                        </ul>
                                        <ul class="list-unstyled">
                                            <li><a href="createvoucher">Create Voucher</a></li>
                                            <li><a href="category.html">Edit Voucher</a></li>
                                            <li><a href="category.html">Delete Voucher</a></li>
                                            <li><a href="category.html">Text 309</a></li>
                                            <li><a href="category.html">Text 310</a></li>
                                        </ul>
                                        <ul class="list-unstyled">
                                            <li><a href="category.html">User List</a></li>
                                            <li><a href="category.html">Text 312</a></li>
                                            <li><a href="category.html#">Text 313</a></li>
                                            <li><a href="category.html#">Text 314</a></li>
                                            <li><a href="category.html">Text 315</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.user.role_id == 3}">
                            <li><a href="introduce?user_id=${sessionScope.post.user_id}">Introduce(Thanh)</a></li>
                            </c:if>
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Thông tin khách hàng</title>-->
        <style>
            *{

                padding: 0px;

            }
            .container{
                margin-left: 10%;
                margin-right: 10%;
                display: flex;
            }
            .name {

            }
            .info{
                margin-left:10px;
                padding: 10px;
            }
            .info h3 {
                margin-top: 3px;
                color: blue;
            }
            .heading h2{
                text-align: center;
            }
            .menu{
                width: 20%;
                margin-right: 2%;
                background-color: #EEEEEE;
                height: 310px;
            }
            .menu ul li{
                list-style: none;
                width: 100%;
                padding: 3px;
                text-align: left;

            }
            .editprofile{
                float: right;
            }
            .editprofile a{
                text-decoration: none;
            }
            td {
                border: 1px solid;
                text-align: center;
                padding: 100px;
            }

        </style>

    </head>
<body>    
    <div class="heading"><h2>Thông tin khách hàng</h2></div>

    <a href="../view/home">Home</a>
    <div class="container">
        <div class="menu">
            <ul>
                <li><a href="./profile/view">Thông tin khách hàng</a></li>
                <li><a href="voucher">Voucher</a></li>
                <li><a href="!!!!">Lịch sử đi tour</a></li>
            </ul>
        </div>
        <div class="info">
            <h3>I. Thông tin Voucher</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">End Date</th>
                        <th scope="col">Discount</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.voucherlist}" var="s" varStatus="status">
                    <tr>
                        <th scope="row">${status.index + 1}</th>
                        <td>${s.voucher_id}</td>
                        <td>${s.voucher_name}</td>
                        <td>${s.end_date}</td>
                        <td>${s.discount}%</td>
                        <td>${s.description}</td>
                    </tr>
                     </c:forEach>
                </tbody>
            </table>
        </div>  
    </div>        

</body>
</html>
