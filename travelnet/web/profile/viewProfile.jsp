<%-- 
    Document   : viewProfile
    Created on : Feb 8, 2023, 9:43:49 AM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin khách hàng</title>
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
            .toplink .top-link{
                float: right;
            }
        </style>

        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <meta name="author" content="https://www.Zerotheme.com">

        <title>Fashion Shop | Free Bootstrap Themes by Zerotheme.com</title>

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
    </head> 
    <body> 

        <nav id="top" >
            <div class="container toplink" >
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="top-link">
                            <li><a href="login"><span class="glyphicon glyphicon-user"></span> My Account</a>
                                <ul class="sub-my-account">
                                    <li><a href="view"> My profile</a></li>
                                    <li><a href="edit">Edit Profile</a></li>
                                    <li>View My Tour</li>
                                    <li>Log Out</li>
                                </ul>
                            </li>
                            <li><a href="contact.html"><span class="glyphicon glyphicon-envelope"></span> Contact</a></li>
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
                        <div id="logo"><img src="../image/logo.png" /></div>
                    </div>
                    <div class="col-md-6 text-right">
                        <form class="form-search">  
                            <input type="text" class="input-medium search-query">  
                            <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>  
                        </form>
                    </div>
                    <div id="cart"><a class="btn btn-cart" href="cart.html"><span class="glyphicon glyphicon-shopping-cart"></span>CART<strong>0</strong></a></div>
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
                                        <li><a href="category.html">Text 101</a></li>
                                        <li><a href="category.html">Text 102</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Service(Nhi)</a>
                            <div class="dropdown-menu">
                                <div class="dropdown-inner">
                                    <ul class="list-unstyled">
                                        <li><a href="category.html">Text 201</a></li>
                                        <li><a href="category.html">Text 202</a></li>
                                        <li><a href="category.html">Text 203</a></li>
                                        <li><a href="category.html">Text 204</a></li>
                                        <li><a href="category.html">Text 205</a></li>
                                    </ul>
                                </div> 
                            </div>
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Booking(Kien)</a>
                            <div class="dropdown-menu" style="margin-left: -203.625px;">
                                <div class="dropdown-inner">
                                    <ul class="list-unstyled">
                                        <li><a href="category.html">Text 301</a></li>
                                        <li><a href="category.html">Text 302</a></li>
                                        <li><a href="category.html">Text 303</a></li>
                                        <li><a href="category.html">Text 304</a></li>
                                        <li><a href="category.html">Text 305</a></li>
                                    </ul>
                                    <ul class="list-unstyled">
                                        <li><a href="category.html">Text 306</a></li>
                                        <li><a href="category.html">Text 307</a></li>
                                        <li><a href="category.html">Text 308</a></li>
                                        <li><a href="category.html">Text 309</a></li>
                                        <li><a href="category.html">Text 310</a></li>
                                    </ul>
                                    <ul class="list-unstyled">
                                        <li><a href="category.html">Text 311</a></li>
                                        <li><a href="category.html">Text 312</a></li>
                                        <li><a href="category.html#">Text 313</a></li>
                                        <li><a href="category.html#">Text 314</a></li>
                                        <li><a href="category.html">Text 315</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="introduce?user_id=${sessionScope.post.user_id}">Introduce(Thanh)</a></li>
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="heading"><h2>Thông tin khách hàng</h2></div>
        <div class="container">
            <div class="menu">
                <ul>
                    <li><a href="view">Thông tin khách hàng</a></li>
                    <li><a href="../voucher/view">Voucher</a></li>
                    <li><a href="!!!!">Lịch sử đi tour</a></li>
                </ul>
            </div>
            <div class="info">
                <h3>I. Thông tin tài khoản</h3>

                <div class="name">
                    <p>Username: ${requestScope.user.username}</p>                   
                </div>  
                <div class="name">
                        <p>Password: ******</p>                   
                    </div>  
                <div class="name">
                    <p>Accumulated points : ${requestScope.user.point} </p>
                </div> 
                <div class="name">
                    <p>Account balance : ${requestScope.user.account_balance} </p>
                </div> 
                <br/>
                <h3>I. Thông tin cá nhân</h3>
                <div class="name">
                    <p> <img style="height:50px; weight:50px;" src="${requestScope.user.avatar}" />  </p>
                </div>
              
                
                <div class="name">
                    <p> Name: ${requestScope.user.firstname} ${requestScope.user.lastname}   </p>
                </div>
                <div class="name">
                    <p> Gender: 
                        <c:if test="${requestScope.user.gender}">Male</c:if>
                        <c:if test="${!requestScope.user.gender}">Female</c:if> 
                        </p>
                    </div>
                <div class="name">
                    <p>Address: ${requestScope.user.address}</p>                       
                </div>
                <div class="name">
                    <p>Email: ${requestScope.user.email}</p>
                </div>
                <div class="name">
                    <p>Phone Number: ${requestScope.user.phone_number}</p>
                </div>
                <div class="name">
                    <p>Date of Birth: ${requestScope.user.dob}</p>
                </div>
                <div class="name">
                    <p>Nationality: ${requestScope.user.nationality} </p>
                </div>
                <div class="name">
                    <p>National ID: ${requestScope.user.national_id} </p>
                </div>
                <div class="editprofile">
                    <button class="btn btn-4" style="color: whitesmoke;" > <a href="edit">Edit Profile</a>  </button>
                </div>
            </div>  
        </div>
    </body>
</html>
