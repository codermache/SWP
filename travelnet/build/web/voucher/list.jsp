<%-- 
    Document   : staffadd
    Created on : Mar 4, 2023, 9:50:44 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Free Bootstrap Themes by Zerotheme dot com - Free Responsive Html5 Templates">
        <meta name="author" content="https://www.Zerotheme.com">
        <title>Voucher</title>
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
        <style>
            .white_card card_height_100 mb_30{
                align-items: center;
            }
            .white_card_header{
                display: flex;
                justify-content: space-between;
            }
        </style>

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
                                    <li><a href="#">Edit Profile</a></li>
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
                        <li><a href="introduce?user_id=${sessionScope.post.user_id}">Introduce(Thanh)</a></li>
                        <li><a href="category.html">Hot Fashion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="main_content dashboard_part col-md-12" >

            <a href="list" data-bs-target="#addcategory""> <- Back </a>
            <div class="main_content_iner">
                <div class="container-fluid plr_30 body_white_bg pt_30">
                    <div class="row justify-content-center">
                        <div class="col-lg-12">
                            <div class="white_card card_height_100 mb_30">
                                <div class="white_card_header" >
                                    <div class="box_header m-0">
                                        <div class="main-title">
                                            <h3 class="m-0"> Voucher List </h3>
                                        </div>
                                    </div>
                                    <div class="box_right d-flex lms_block" ">
                                        <div class="serach_field_2">
                                            <div class="search_inner col-md-8">
                                                <input type="text" id="searchInput" placeholder="Tìm kiếm..." onkeyup="searchTable()">
                                            </div>
                                        </div>
                                        <div class="add_button ms-2">
                                            <button style="background-color:green" type="button" class="btn_1 btn-primary" data-toggle="modal" data-target="#myModal">
                                                Create Voucher 
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div class="white_card_body">
                                    <div class="card-body">
                                        <table class="table lms_table_active" id="productTable">
                                            <thead>
                                                <tr>

                                                    <th scope="col">ID</th>                                                  
                                                    <th scope="col" id="sortButton" onclick="sortTableByName()">Name</th>
                                                    <th scope="col">Quantity</th>
                                                    <th scope="col">Discount</th>
                                                    <th scope="col">Start Date</th>
                                                    <th scope="col">End Date</th>                                                    
                                                    <th scope="col">description</th>
                                                    <th scope="col">Point</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.vouchers}" var="v" varStatus="loop">
                                                    <tr>

                                                        <td>${v.voucher_id}</td>
                                                        <td class="name">${v.voucher_name}</td>                                                    
                                                        <td>${v.quantity}</td>
                                                        <td> ${v.discount}%</td>                                                   
                                                        <td>${v.create_date}</td>
                                                        <td>${v.end_date}</td>                                                       
                                                        <td>${v.description}</td> 
                                                        <td>${v.point}</td> 
                                                        <td>
                                                            <c:if test="${v.status}"> 
                                                                <button 
                                                                    id="${v.voucher_id}" 
                                                                    onclick="toggleButton('{v.voucher_id}')" 
                                                                    style="background-color: green" 
                                                                    type="button" 
                                                                    class="btn btn-primary" >On</button>
                                                            </c:if> 
                                                            <c:if test="${!v.status}"> 
                                                                <button 
                                                                    id="${v.voucher_id}" 
                                                                    onclick="toggleButton('{v.voucher_id}')" 
                                                                    style="background-color: Red" 
                                                                    type="button" 
                                                                    class="btn btn-primary" >Off</button>
                                                            </c:if> 
                                                        </td>
                                                        <td>
                                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#edit-${v.voucher_id}">
                                                                Edit 
                                                            </button>
                                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${v.voucher_id}-details">
                                                                i
                                                            </button>  
                                                        </td>

                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
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

        <!-- Modal create -->            
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="create" method="POST">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Create New Voucher</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>                        
                        <div class="modal-body">                                                     
                            <div>
                                <label class="form-label" for="inputAddress">ID</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="id" name="id"   minlength="1" maxlength="30"   required/>
                            </div>
                            <div>
                                <label class="form-label" for="inputAddress">Name</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="name" name="name" minlength="2" maxlength="30" required />
                            </div>
                            <div>
                                <label class="form-label" for="inputAddress">Quantity</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="quantity" name="quantity" minlength="1" maxlength="30" required/>
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Discount</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="sale" name="discount" minlength="1" maxlength="30" required/>
                            </div> 
                            <div>
                                <label class="form-label" for="inputDescription">Create Date</label>
                                <input type="date" class="form-control"  name="create_date" required/>
                            </div>
                            <div>
                                <label class="form-label" for="inputDescription">End Date</label>
                                <input type="date" class="form-control"  name="end_date" required/>
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Status</label>
                                <br/>
                                <input type="radio"  name="status" value ="on"/> ON
                                <input type="radio"  name="status" value="off"/> OFF
                            </div>
                            <div>
                                <label class="form-file" for="inputPhone">Description</label>
                                <textarea type="text" class="form-control" id="inputAddress"  name="description" minlength="3" maxlength="100" required> </textarea>
                            </div>                                                                      
                            <div>
                                <div>
                                    <label class="form-label" for="inputType">Point</label>
                                    <input type="text" class="form-control" id="inputType" placeholder="amout point to buy" name="point" minlength="0" maxlength="3" required/>
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
        <!-- Modal Edit -->     
        <c:forEach items="${requestScope.vouchers}" var="v" varStatus="loop">
            <div class="modal fade" id="edit-${v.voucher_id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="edit" method="POST">
                            <div class="modal-header">
                                <h4 class="modal-title" id="myModalLabel">Edit Voucher</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            </div>                        
                            <div class="modal-body">                                                     
                                <div>
                                    <label class="form-label" for="inputAddress">ID</label>
                                    <input type="hidden" class="form-control" value="${v.voucher_id}" id="inputAddress" placeholder="id" name="id"   minlength="1" maxlength="30"   required/>
                                </div>
                                <div>
                                    <label class="form-label" for="inputAddress">Name</label>
                                    <input type="text" class="form-control" value="${v.voucher_name}" id="inputAddress" placeholder="name" name="name" minlength="2" maxlength="30" required />
                                </div>
                                <div>
                                    <label class="form-label" for="inputAddress">Quantity</label>
                                    <input type="text" class="form-control" value="${v.quantity}" id="inputAddress" placeholder="quantity" name="quantity" minlength="1" maxlength="30" required/>
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Discount</label>
                                    <input type="text" class="form-control" value="${v.discount}" id="inputAddress" placeholder="sale" name="discount" minlength="1" maxlength="30" required/>
                                </div> 
                                <div>
                                    <label class="form-label" for="inputDescription">Create Date</label>
                                    <input type="date" class="form-control" value="${v.create_date}"  name="create_date" required/>
                                </div>
                                <div>
                                    <label class="form-label" for="inputDescription">End Date</label>
                                    <input type="date" class="form-control" value="${v.end_date}" name="end_date" required/>
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Status</label>
                                    <br/>
                                    <input type="radio" <c:if test="${v.status}">
                                           checked="checked"
                                        </c:if> name="status" value ="on"/> ON
                                    <input type="radio" <c:if test="${!v.status}">
                                           checked="checked"
                                        </c:if>  name="status" value="off"/> OFF
                                </div>
                                <div>
                                    <label class="form-file" for="inputPhone">Description</label>
                                    <textarea type="text" class="form-control"  id="inputAddress"  name="description" minlength="3" maxlength="100" required>${v.description} </textarea>
                                </div>                                                                      
                                <div>
                                    <div>
                                        <label class="form-label" for="inputType">Point</label>
                                        <input type="text" class="form-control" value="${v.point}" id="inputType" placeholder="amout point to buy" name="point" minlength="0" maxlength="3" required/>
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
        </c:forEach>
        <!-- JS -->
        <script>
            function toggleButton(cl) {
                var button = document.getElementById(cl);
                if (button.style.backgroundColor === "red") {
                    button.style.backgroundColor = "blue";
                    button.innerHTML = "on";
                } else {
                    button.style.backgroundColor = "red";
                    button.innerHTML = "off";
                }
            }
        </script>
        <!-- sort -->
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
                document.getElementById('sortButton').innerText = 'Name';
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
            });

        </script>

        <script>
            function searchTable() {
                const myInput = document.getElementById("searchInput");

                // Lấy giá trị từ khóa tìm kiếm
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("searchInput");
                var inputSearch = input.value;
                var info = input.value.trim();
                if (info === null) {
                    info -= " ";
                } else {
                    if ((inputSearch.length - info.length) >= 1)
                        info += " ";
                }
                input.value = info;
                filter = input.value.toUpperCase();
                table = document.getElementById("productTable");
                tr = table.getElementsByTagName("tr");
                // Lặp qua các hàng của bảng và ẩn hoặc hiển thị tùy thuộc vào kết quả tìm kiếm
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
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
    </body>
</html>
