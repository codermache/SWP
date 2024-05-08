

<%-- 
    Document   : hotellist
    Created on : Feb 21, 2023, 7:51:16 AM
    Author     : Hainhi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <meta name="author" content="https://www.Zerotheme.com">
        <title>Staff List</title>
        <link href="../css1/style.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../fonts/font-slider.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery and Modernizr-->
        <script src="../js/jquery-2.1.1.js" type="text/javascript"></script>
        <!-- Core JavaScript Files -->  	 
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->

        <script>
            function removeStaff(id)
            {
                var result = confirm("Do you want to delate this staff?");
                if (result)
                    window.location.href = "delete?id=" + id;
            }
        </script>
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
            .avatar {
                width: 100px;
                height: 100px;
                border-radius: 50%;
            }
            .im{
                margin-left: 190px;
            }
        </style>
        <script src="https://kit.fontawesome.com/a3a7a1da42.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    </head>
    <body>

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
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Management Service</a>
                            <div class="dropdown-menu">
                                <div class="dropdown-inner">
                                    <ul class="list-unstyled">
                                        <li><a href="list">Hotel</a></li>
                                        <li><a href="../restaurant/list">Restaurant</a></li>
                                        <li><a href="category.html">Vehicle</a></li>
                                        <li><a href="../voucher/list">Voucher</a></li>
                                    </ul>
                                </div> 
                            </div>
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Booking</a>
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
                        <li><a href="introduce?user_id=${sessionScope.post.user_id}">Introduce</a></li>
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="a" >
            <div class="a2">
                <span>
                    <a href='../home'>Home</a> >
                    <a href='#'>Staff List</a>
                </span>
            </div>
        </div>



        <section class="main_content dashboard_part col-md-12">
            <div class="main_content_iner ">
                <div class="container-fluid plr_30 body_white_bg pt_30">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="QA_section">
                                <div class="white_box_tittle list_header">
                                    <h4>Staff List</h4>
                                    <div class="box_right d-flex lms_block">
                                        <div class="serach_field_2">
                                            <div class="search_inner col-md-8">
                                                <button id="searchBtn" onclick="search()">Search</button>
                                                <input type="text" oninput="searchByName(this)" id="searchInput" placeholder="Tìm kiếm..." onkeyup="searchTable()">                                               
                                            </div>
                                        </div>
                                        <div class="add_button ms-2">
                                            <button style="background-color:green" type="button" class="btn_1 btn-primary" data-toggle="modal" data-target="#myModal">
                                                <i class="fa-solid fa-circle-plus"></i> &nbsp; Add Staff 
                                            </button>
                                        </div>
                                    </div>
                                </div>

                                <div class="QA_table ">

                                    <table class="table lms_table_active" id="productTable">
                                        <thead>
                                            <tr>
                                                <th scope="col">No.</th>
                                                <th scope="col">Staff ID</th>
                                                <th scope="col">User Name</th>
                                                <th scope="col" id="sortButton" onclick="sortTableByName()">Name</th>
                                                <th scope="col">Gender</th>
                                                <th scope="col">Address</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="contentSearch">
                                            <c:forEach items="${requestScope.staffs}" var="h" varStatus="loop">
                                                <tr>
                                                    <th scope="row"> <a href="#" class="question_content">${loop.index+1}</a></th>
                                                    <td>${h.user_id}</td>
                                                    <td class="name">${h.username}</td>                                                    

                                                    <td>${h.firstname} ${h.lastname}</td>

                                                    <td>                                                      
                                                        <c:if test="${h.gender}">Male</c:if>
                                                        <c:if test="${!h.gender}">Female</c:if> 
                                                        </td>
                                                        <td>${h.address}</td>
                                                    <td>${h.phone_number}</td>
                                                    <td>${h.email}</td>   
                                                    <td>
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${h.user_id}">
                                                            <i class="fa-solid fa-pen-to-square" ></i>
                                                        </button>
                                                        <button style="background-color: red" type="button" class="btn btn-primary" onclick="removeStaff(${h.user_id})" >
                                                            <i class="fa-regular fa-trash-can"></i>
                                                        </button>
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${h.user_id}-details">
                                                            i
                                                        </button>  
                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>




                                    <!-- Style modal -->
                                    <style>
                                        .modal-dialog {
                                            width: 40%;
                                        }
                                        .modal-body{
                                            padding: 20px;
                                        }
                                        .im{
                                            padding: 20px;
                                        }
                                    </style>

                                    <script>
                                        function showNotification() {
                                            // Lấy phần tử div chứa thông báo
                                            var notification = document.getElementById("notification");

                                            // Hiển thị thông báo
                                            notification.style.display = "block";

                                            // Đặt thời gian chờ 2 giây và ẩn thông báo
                                            setTimeout(function () {
                                                notification.style.display = "none";
                                            }, 2000);
                                        }
                                    </script>

                                    <!-- Sort danh sach -->
                                    <script>
                                        let isSorted = false;
                                        const sortTableByName = () => {
                                            const tbody = document.querySelector('table tbody');
                                            const rows = Array.from(tbody.querySelectorAll('tr'));
                                            rows.sort((a, b) => {
                                                const nameA = a.querySelectorAll('td')[2].textContent;
                                                const nameB = b.querySelectorAll('td')[2].textContent;
                                                return nameA.localeCompare(nameB);
                                            });
                                            rows.forEach(row => tbody.appendChild(row));
                                            isSorted = true;
                                            document.getElementById('sortButton').innerText = 'Name^';
                                            document.getElementById('sortButton').onclick = resetSort;
                                        };
                                        const resetSort = () => {
                                            const tbody = document.querySelector('table tbody');
                                            const rows = Array.from(tbody.querySelectorAll('tr'));
                                            rows.reverse();
                                            rows.forEach(row => tbody.appendChild(row));
                                            isSorted = false;
                                            document.getElementById('sortButton').innerText = 'Name';
                                            document.getElementById('sortButton').onclick = sortTableByName;
                                        };
                                    </script>

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

        <!-- Modal add new staff-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="add" method="POST">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Add New Staff</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>                        
                        <div class="modal-body">                          
                            <div class="im">      
                                <img class="avatar" id="avatarPreview" src="../image/Avatar/defaultAvatar.webp">
                                <input  type="file" id="avatarInput" name="avatar">                               
                            </div>
                            <div>
                                <label class="form-label" for="inputAddress">UserName</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="username" name="username"   minlength="5" maxlength="30"   required/>
                            </div>
                            <div>
                                <label class="form-label" for="inputAddress">Password</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="First name" name="password" minlength="5" maxlength="30" required />
                            </div>
                            <div>
                                <label class="form-label" for="inputAddress">First Name</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="First name" name="firstname" minlength="1" maxlength="30" required/>
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Last Name</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="Last name" name="lastname" minlength="1" maxlength="30" required/>
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Gender</label>
                                <br/>
                                <input type="radio"  name="gender" value ="male"/> Male
                                <input type="radio"  name="gender" value="female"/> Female
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Address</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="address" name="address" minlength="10" maxlength="255" required/>
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Email</label>
                                <input type="email" class="form-control" id="inputAddress" placeholder="Email" name="email" minlength="10" maxlength="100" required/>
                            </div>                                           
                            <div>
                                <label class="form-label" for="inputPhone">Phone</label>
                                <input type="text" class="form-control" id="inputPhone" placeholder="Phone Number" name="phone" required/>
                            </div>

                            <div>
                                <label class="form-label" for="inputDescription">Date of birth</label>
                                <input type="date" class="form-control"  name="dob" required/>
                            </div>
                            <div>
                                <div>
                                    <label class="form-label" for="inputType">Nationality</label>
                                    <input type="text" class="form-control" id="inputType" placeholder="Country" name="nationality" minlength="2" maxlength="30" required />
                                </div>
                            </div> 
                            <div>
                                <div>
                                    <label class="form-label" for="inputType">National ID</label>
                                    <input type="text" class="form-control" id="inputType" placeholder="NationalID" name="national_id" minlength="10" maxlength="15" required/>
                                </div>
                            </div>
                        </div>               
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script>
            function updatePreviewImage(input, preview) {
                if (input.files && input.files[0]) {
                    const reader = new FileReader();

                    reader.addEventListener('load', function () {
                        preview.src = reader.result;
                    });

                    reader.readAsDataURL(input.files[0]);
                }
            }

            const inputImage = document.getElementById('inputImage');
            const previewImage = document.getElementById('previewImage');

            inputImage.addEventListener('change', function () {
                updatePreviewImage(this, previewImage);
            });
        </script>
        <!-- Modal edit user -->
        <c:forEach items="${requestScope.staffs}" var="h">
            <div class="modal fade" id="${h.user_id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="edit" method="POST">
                            <div class="modal-header">
                                <h4 class="modal-title" id="myModalLabel">Edit Staff</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            </div>                  
                            <div class="modal-body">
                                <input type="hidden" value="${h.user_id}" name="user_id"/>
                                <div class="im">      
                                    <img class="avatar" src="../image/Avatar/${h.avatar}" id="previewImage">
                                    <input name="avatar" type="file" id="inputImage" onchange="updatePreviewImage(this, document.getElementById('previewImage'))">                               
                                </div>
                                <div>
                                    <label class="form-label" for="inputAddress">UserName</label>
                                    <input type="text" value="${h.username}" class="form-control" id="inputAddress" placeholder="username" name="username" minlength="5" maxlength="30" required/>
                                </div>
                                <div>
                                    <label class="form-label" for="inputAddress">Password</label>
                                    <input type="text" value="${h.password}" class="form-control" id="inputAddress" placeholder="First name" name="password" minlength="7" maxlength="30" required />
                                </div>
                                <div>
                                    <label class="form-label" for="inputAddress">First Name</label>
                                    <input type="text" value="${h.firstname}" class="form-control" id="inputAddress" placeholder="First name" name="firstname" minlength="2" maxlength="30" required/>
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Last Name</label>
                                    <input type="text" value="${h.lastname}" class="form-control" id="inputAddress" placeholder="Last name" name="lastname" minlength="2" maxlength="30" required/>
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Gender</label>
                                    <br/>
                                    <input type="radio"
                                           <c:if test="${h.gender}">
                                               checked="checked"
                                           </c:if>
                                           name="gender" value ="male"/> Male
                                    <input type="radio" 
                                           <c:if test="${!h.gender}">
                                               checked="checked"
                                           </c:if>
                                           name="gender" value="female"/> Female
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Address</label>
                                    <input type="text" value="${h.address}" class="form-control" id="inputAddress" placeholder="address" name="address" minlength="10" maxlength="30" required/>
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Email</label>
                                    <input type="email" value="${h.email}" class="form-control" id="inputAddress" placeholder="Email" name="email" required/>
                                </div>                                           
                                <div>
                                    <label class="form-label" for="inputPhone">Phone</label>
                                    <input type="text" value="${h.phone_number}" class="form-control" id="inputPhone" placeholder="Phone Number" name="phone" pattern="((\+84)|0)(9[0-9]|3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5])+([0-9]{7})" required/>
                                </div>

                                <div>
                                    <label class="form-label" for="inputDescription">Date of birth</label>
                                    <input type="date" value="${h.dob}" class="form-control"  name="dob" required/>
                                </div>
                                <div>
                                    <div>
                                        <label class="form-label" for="inputType">Nationality</label>
                                        <input type="text" value="${h.nationality}" class="form-control" id="inputType" name="nationality" minlength="5" maxlength="30" required />
                                    </div>
                                </div> 
                                <div>
                                    <div>
                                        <label class="form-label" for="inputType">National ID</label>
                                        <input type="text" value="${h.national_id}" class="form-control" id="inputType" name="national_id" minlength="5" maxlength="30" required/>
                                    </div>
                                </div>
                            </div>    
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" onclick="showNotification()"  class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!-- Modal staff details -->
        <c:forEach items="${requestScope.staffs}" var="h">
            <div class="modal fade" id="${h.user_id}-details" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Staff information details</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>
                        <div class="modal-body">
                            <div class="im">      
                                <img class="avatar" id="avatarPreview" src="../image/Avatar/${h.avatar}">                                                         
                            </div>
                            <br/>
                            ID: ${h.user_id}<br/>
                            UserName: ${h.username}  <br/>
                            Password: ${h.password} <br/>
                            First Name:  ${h.firstname} <br/>
                            Last Name: ${h.lastname} <br/>
                            Address: ${h.address} <br/>
                            Gender: ${h.gender} <br/>
                            Phone Number: ${h.phone_number} <br/>
                            Date of birth ${h.dob} <br/>
                            Email: ${h.email}<br/>
                            Nationality: ${h.nationality} <br/>
                            National ID: ${h.national_id} <br/>
                        </div>             
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                        </div>                     
                    </div>
                </div>
            </div>
        </c:forEach>


        <!-- JS -->
        <!-- thay doi anh -->
        <script>
            // Lấy thẻ input và thẻ img
            const avatarInput = document.getElementById('avatarInput');
            const avatarPreview = document.getElementById('avatarPreview');

            // Thêm sự kiện change vào thẻ input
            avatarInput.addEventListener('change', () => {
                // Kiểm tra xem người dùng đã chọn tệp chưa
                if (avatarInput.files && avatarInput.files[0]) {
                    // Tạo một đối tượng FileReader mới
                    const reader = new FileReader();

                    // Thiết lập sự kiện load cho FileReader
                    reader.addEventListener('load', () => {
                        // Đặt thuộc tính src của thẻ img bằng đường dẫn của tệp được chọn
                        avatarPreview.setAttribute('src', reader.result);
                    });

                    // Đọc tệp được chọn bằng FileReader
                    reader.readAsDataURL(avatarInput.files[0]);
                }
            });
        </script>
        
        <!-- search by name -->
        <script>
            function search() {
                $.ajax({
                    url: "/swp391_project/staff/search",
                    type: "get",
                    success: function (data) {
                        var row = document.getElementById("contentSearch");
                        row.innerHTML = data;
                    },
                    error: function () {

                    }
                });


            }
        </script>

        <script>
            function searchByName(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: "/swp391_project/staff/search",
                    type: "get",
                    data: {
                        txt: txtSearch
                    },
                    success: function (data) {
                        var row = document.getElementById("contentSearch");
                        row.innerHTML = data;
                    },
                    error: function () {

                    }
                });


            }
        </script>
        <script>
            $(document).ready(function () {
                $(".nav-tabs a").click(function () {
                    $(this).tab('show');
                });
                $('.nav-tabs a').on('shown.bs.tab', function (event) {
                    var x = $(event.target).text(); // active tab
                    var y = $(event.relatedTarget).text(); // previous tab
                    $(".act span").text(x);
                    $(".prev span").text(y);
                });
            }
            );
        </script>
    </body>
</html>
