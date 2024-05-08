<%-- 
    Document   : hotellist
    Created on : Feb 21, 2023, 7:51:16 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <!--<meta name="author" content="https://www.Zerotheme.com">-->

        <title>TRAVELNET | Always with you on the road</title>
<link href="../css1/style.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="../css/bootstrap.min.css"  type="text/css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="../css/style.css">


        <!-- Custom Fonts -->
        <link rel="stylesheet" href="https://cdnj s.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
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
                padding: 11px 22px;
                margin: 2px 0;
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
        <%
       Cookie[] listCookie = request.getCookies();
       String user = "";
       String pass = "";
           int co = 0;
           if(listCookie != null){
       while(co < listCookie.length){
             if(listCookie[co].getName().equals("user")){
              user = listCookie[co].getValue();
       }
             if(listCookie[co].getName().equals("pass")){
              pass = listCookie[co].getValue();
       }
       co++;
       }
       }
        %>
        <!--Top-->
        <nav id="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="top-link">
                            <c:if test="${sessionScope.user == null}">
                                <button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Login</button>           
                            </c:if>



                            <div id="id01" class="modal">

                                <form class="modal-content animate" action="home" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                                        <img src="img_avatar2.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container">
                                        <label for="uname"><b>Email</b> ${usermessage}</label>
                                        <input type="text" style="color:black;" placeholder="Enter Email" name="email" value="<%out.print(user);%>" required>
                                        <div style="color:red;">${usermessage}</div>
                                        <br>
                                        <label for="psw"><b>Password</b></label>
                                        <input type="password" style="color:black;" placeholder="Enter Password" name="password" value="<%out.print(pass);%>" required>
                                        <span class="show-btn"><i class="fas fa-eye"></i></span>
                                        <div style="color:red;"> ${passmessage}</div> 
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
                            <c:if test="${sessionScope.user != null}">
                                <li><span class="glyphicon glyphicon-user"></span> My Account</a>
                                    <ul class="sub-my-account">
                                        <li><a href="../profile/view"> My profile</a></li>
                                        <li><a href="../profile/edit">Edit Profile</a></li>
                                        <li><a href="../mytour">View My Tour</li>
                                        <li><a href="../logout">Log Out</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.user == null}">
                                <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
                                </c:if>

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

<!--                    <input type="text" class="input-medium search-query" name="search" 
                           id="myInput" onkeyup="myFunction()"   placeholder="Search hotel here...">  -->


                    <div class="col-md-6" >
                        <form class="form-search" style="display:flex;" action ="searchtour" method="get">  
                            <input  type="text" style="margin-top:2px;" name="search"  id="myInput" onkeyup="myFunction()" placeholder="Enter Keywords?" class="input-medium search-query">
                            <div> 
                                <button style="margin-left:5px; "type="submit" class="glyphicon glyphicon-search"></button>  </div>
                            <div style="margin-left: 30px; margin-top: 20px;"> <a href="cart.html"><span class="glyphicon glyphicon-shopping-cart"></span>CART</a> </div>
                        </form>
                    </div>


                    <script>
                        function myFunction() {
                            var input, filter, table, tr, td, i, txtValue;
                            input = document.getElementById("myInput");
                            filter = input.value.toUpperCase();
                            table = document.getElementById("myTable");
                            tr = table.getElementsByTagName("tr");
                            for (i = 0; i < tr.length; i++) {
                                td = tr[i].getElementsByTagName("td")[0];
                                td = tr[i].getElementsByTagName("td")[3];
                                if (td) {
                                    txtValue = td.textContent || td.innerText;
                                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                        tr[i].style.display = "";
                                    } else {
                                        tr[i].style.display = "none";
                                    }
                                }
                            }
                        }
                    </script>
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
                                            <li><a href="../restaurant/list">Restaurant</a></li>
                                             <li><a href="../vehicle/list">Vehicle</a></li>
                                        </ul>
                                    </div> 
                                </div>
                            </li>
                        </c:if>
                            
                             <c:if test="${sessionScope.user.role_id == 4}">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Tour Management</a>
                                <div class="dropdown-menu">
                                    <div class="dropdown-inner">
                                        <ul class="list-unstyled">
                                           <li><a href="create">Create Tour</a></li>
                                            <li><a href="category.html">Edit Tour</a></li>
                                            <li><a href="category.html">Delete Tour</a></li>
                                            <li><a href="cartoverview">Booking Request</a></li>
                                        </ul>
                                    </div> 
                                </div>
                            </li>
                        </c:if>
                            
                              <c:if test="${sessionScope.user.role_id == 4}">
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Tour Management</a>
                                <div class="dropdown-menu">
                                    <div class="dropdown-inner">
                                        <ul class="list-unstyled">
                                            <li><a href="../staff/list">Add Staff</a></li> 
                                         
                                        </ul>
                                    </div> 
                                </div>
                            </li>
                        </c:if>
                            
                            
                            
                      
                          
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="a" >
            <div class="a2">
                <span>
                    <a href='../home'>Home</a> >
                    <a href='#'>Hotel</a>
                </span>
            </div>
        </div>
        <style>
            .a {
                margin-top:5px;
                margin: 5px;
                padding: 2px;

            }
            .a1 a, .a1 span {
                border: none;
                outline: none;
                padding: 4px;
                color: white;
                background-color: #0fcc45;
                border-radius: 5px;
            }

            .a2 {
                text-decoration: none;
            }
        </style>


        <section class="main_content dashboard_part col-md-12">

            <div class="main_content_iner ">
                <div class="container-fluid plr_30 body_white_bg pt_30">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="QA_section">
                                <div class="white_box_tittle list_header">
                                    <h4>Hotels List</h4>

                                    <div class="box_right d-flex lms_block">
                                        <div class="serach_field_2">
                                            <div class="search_inner col-md-8">
                                                <form class="form-search">  
                                                    <input value="${search}" type="text" class="input-medium search-query" name="search" 
                                                        id="myInput"   placeholder="Search hotel here...">  
                                                    <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>  
                                                </form>
                                            </div>
                                        </div>
                                        <div class="add_button ms-2">
                                            <a href="add" data-bs-toggle="modal" data-bs-target="#addcategory" class="btn_1">Add New Hotel</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="QA_table ">

                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">No.</th>
                                                <th scope="col">Province</th>
                                                <th scope="col">Hotel ID</th>
                                                <th scope="col">Image</th>
                                                <th scope="col">Hotel Name</th>
                                                <th scope="col">Type</th>
                                                <th scope="col">Address</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Rate</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.hotels}" var="h" varStatus="loop">
                                                <tr>

                                                    <th scope="row"> <a href="#" class="question_content">${loop.index+1}</a></th>
                                                    <td>${h.place.conscious.c_name}</td>

                                                    <td>${h.hotel_id}</td>
                                                    <td><img src="${h.hotel_img}" alt="#"/></td>
                                                    <td>${h.hotel_name}</td>
                                                    <td>${h.hotel_type}</td>
                                                    <td>${h.hotel_address}</td>
                                                    <td>${h.hotel_phone}</td>
                                                    
                                                    <c:if test="${h.hotel_rate} " >
                                                        <td></td>                                                
                                                    </c:if>
                                                    <c:if test="${h.hotel_rate == 1} " >
                                                        <td><img src="../image(Nhi)/1 star.png" alt="alt"/></td>                                                
                                                        </c:if>
                                                        <c:if test="${h.hotel_rate == 2}">
                                                        <td><img src="../image(Nhi)/2 star.png" alt="alt"/></td>                                                
                                                        </c:if>
                                                        <c:if test="${h.hotel_rate == 3}">
                                                        <td><img src="../image(Nhi)/3 star.png" alt="alt"/></td>                                                
                                                        </c:if>
                                                        <c:if test="${h.hotel_rate == 4}">
                                                        <td><img src="../image(Nhi)/4 star.jpg" alt="alt"/></td>                                                
                                                        </c:if>
                                                        <c:if test="${h.hotel_rate == 5}">
                                                        <td><img src="../image(Nhi)/5 star.jpg" alt="alt"/></td>                                                
                                                        </c:if>
                                                        <td>
                                                        <a href="detail?id=${h.hotel_id}"><img src="https://icons-for-free.com/download-icon-detail+details+ellipses+more+icon-1320183138163966322_512.png" ></a>
                                                    </td>
                                                    <td>
                                                        <a href="update?id=${h.hotel_id}"><img src="https://icons.veryicon.com/png/o/miscellaneous/linear-small-icon/edit-246.png" ></a>
                                                    </td>
                                                    <td>
                                                        <a href="#" onclick="removeHotel(${h.hotel_id})"><img src="https://cdn2.iconfinder.com/data/icons/medical-and-health-2-16/65/64-512.png" ></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            <div class="brand">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-xs-6">
                            <a href="#"><img src="../image/brand1-250x100.jpg" /></a>
                        </div>
                        <div class="col-lg-3 col-xs-6">
                            <a href="#"><img src="../image/brand2-250x100.jpg" /></a>
                        </div>
                        <div class="col-lg-3 col-xs-6">
                            <a href="#"><img src="../image/brand4-250x100.jpg" /></a>
                        </div>
                        <div class="col-lg-3 col-xs-6">
                            <a href="#"><img src="../image/brand1-250x100.jpg" /></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="top-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 text-right">
                            <h4>Subcribe Email</h4>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                        </div>
                        <div class="col-md-6">
                            <form name="subcribe-email" action="subcribe.php">
                                <div class="subcribe-form form-group">
                                    <input class="form-inline" type="text" name="email" value="1"><button href="#" class="btn btn-4" type="submit">Subcribe</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="wrap-footer">
                    <div class="row">
                        <div class="col-md-3 col-footer footer-1">
                            <img src="../image/logo.png" />
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                        </div>
                        <div class="col-md-3 col-footer footer-2">
                            <div class="heading"><h4>Customer Services</h4></div>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Delivery Information</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Terms & Conditions</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-footer footer-3">
                            <div class="heading"><h4>My Account</h4></div>
                            <ul>
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Brands</a></li>
                                <li><a href="#">Gift Vouchers</a></li>
                                <li><a href="#">Specials</a></li>
                                <li><a href="#">Site Map</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3 col-footer footer-4">
                            <div class="heading"><h4>Contact Us</h4></div>
                            <ul>
                                <li><span class="glyphicon glyphicon-home"></span>California, United States 3000009</li>
                                <li><span class="glyphicon glyphicon-earphone"></span>+91 8866888111</li>
                                <li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            Your Store ?? 20xx - Designed by <a href="https://www.Zerotheme.com" target="_blank">Zerotheme</a>
                        </div>
                        <div class="col-md-6">
                            <div class="pull-right">
                                <ul>
                                    <li><img src="images/visa-curved-32px.png" /></li>
                                    <li><img src="images/paypal-curved-32px.png" /></li>
                                    <li><img src="images/discover-curved-32px.png" /></li>
                                    <li><img src="images/maestro-curved-32px.png" /></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- JS -->
        <script>
            $(document).ready(function () {
                $(".nav-tabs a").click(function () {
                    $(this).tab('show');
                });
                $('.nav-tabs a').on('shown.bs.tab', function (event) {
                    var x = $(event.target).text();         // active tab
                    var y = $(event.relatedTarget).text();  // previous tab
                    $(".act span").text(x);
                    $(".prev span").text(y);
                });
            });
        </script>
    </body>
</html>
