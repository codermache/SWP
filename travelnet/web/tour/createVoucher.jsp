<%-- 
    Document   : createVoucher
    Created on : 25-02-2023, 08:37:45
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <meta name="author" content="https://www.Zerotheme.com">

        <title>TravelNet</title>

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
    </head>

    <body>
        <!--Top-->
        <nav id="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="top-link">
                            <li><a href="signup"><span class="glyphicon glyphicon-user"></span> My Account</a>
                                <ul class="sub-my-account">
                                    <li><a href="#"> My profile</a></li>
                                    <li><a href="#">Edit Profile</li>
                                    <li>View My Tour</li>
                                    <li>My Point</li>
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
                        <div id="logo"><img src="../image/Logo/logo.png" /></div>
                    </div>
                    <div class="col-md-6 text-right">
                        <form class="form-search" action="searchtour">  
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
                                        <c:forEach var="o" items="${lstTourCate}">                                        
                                            <li><a href="listtourbycategory?categoryid=${o.tour_category_id}">${o.tour_category_name}</a></li>
                                            </c:forEach>
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
                                        <li><a href="create">Create Tour</a></li>
                                        <li><a href="category.html">Edit Tour</a></li>
                                        <li><a href="category.html">Delete Tour</a></li>
                                        <li><a href="category.html">Text 304</a></li>
                                        <li><a href="category.html">Text 305</a></li>
                                    </ul>
                                    <ul class="list-unstyled">
                                        <li><a href="category.html">Create Voucher</a></li>
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
                        <li><a href="introduce?user_id=${sessionScope.post.user_id}">Introduce(Thanh)</a></li>
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Tour</title>
    </head>
    <body>
        <form action="createvoucher" method="POST">
        <h1>Create New Voucher</h1>
        Voucher Name<p><input type="text" name="name" value="" /></p>
        Start Time<p><input type="date" name="starttime" value="" /></p>
        End Time<p><input type="date" name="endtime" value="" /></p>
        Quantity<p><input type="number" name="quantity" value="" /></p>
        %discount<p><input type="number" name="discount" value="" /></p>
        Description<p><input type="text" name="description" value="" /></p>
        <input type="submit" value="Create">
        </form>
    </body>
</html>
