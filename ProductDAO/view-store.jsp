<%-- 
    Document   : view-store
    Created on : Feb 3, 2024, 10:25:14 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .button{
                border: 1px solid #ccc;
                border-radius: 4px;
                font-weight: 500;
                height: 34px;
                font-size: 14px;
            }

            .button:active{
                background-color: #D10024;
                color: white;
            }

            .myshop{
                padding: 20px;
            }

            #responsive-nav-left{
                background-color: rgba(0,0,0,.3);
                border-radius: 4px;
            }

            #responsive-nav-right .col-md-4 {
                list-style-type: none; /* Remove bullets */
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>


        <c:set value="${requestScope.user}" var="user"/>
        <!-- container -->
        <div class="container myshop">
            <!-- responsive-nav -->
            <div id="responsive-nav-left" class="col-md-4">
                <!-- NAV -->
                <img src="${user.image}" height="90px" alt="avatar-of-${user.username}" class="img-fluid"/>
                <h5>${user.username}</h5>
                <!-- /NAV -->
            </div>
            <div id="responsive-nav-right" class="col-md-8">
                <div class="col-md-4">
                    <li><a><i class="fa fa-product-hunt"></i>   Product: <span style="color: red">${requestScope.totalProduct}</span></a></li>
                </div>
                <div class="col-md-4">
                    <li><a href="view-feedback-store?uid=${user.id}"><i class="fa fa-star"></i>   Assess: <span style="color: red">${requestScope.rating} (${requestScope.feedbacks} feedbacks)</span></a></li>
                </div>
                <div class="col-md-4">
                    <li><a><i class="fa fa-user"></i>   Participate: <span style="color: red">${requestScope.participate}</span></a></li>
                </div>
            </div>
            <!-- /responsive-nav -->
        </div>
        <!-- /container -->

        <form action="filter-view-store">
            <div class="section">
                <div class="container">
                    <!-- row -->
                    <div class="row">  
                        <div id="aside" class="col-md-3">
                            <div class="aside">
                                <h3 class="aside-title">Services</h3>
                                <div class="checkbox-filter">
                                    <c:set value="${requestScope.service}" var="service"/>
                                    <c:set value="${requestScope.services}" var="services"/>
                                    <c:forEach begin="0" end="${services.size()-1}" var="i">
                                        <div class="input-checkbox">
                                            <input type="checkbox" id="brand-${i}" name="service" value="${services.get(i).id}" ${service[i]?'checked':''} onclick="this.form.submit()">
                                            <label for="brand-${i}">
                                                <span>
                                                    ${services.get(i).serviceName}
                                                </span>
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                        <div class="row" style ="margin: -0.75rem; flex-wrap: wrap; display: flex;">
                            <div class="col-md-12 pb-4" style="background-color: gainsboro;padding: 10px;">
                                <input type="hidden" name="uid" value="${user.id}"/>
                                <div class="col-md-2">
                                    <p style="font-weight: bold; margin-top: 4px;">SORT BY: </p>
                                </div>
                                <div class="col-md-2">
                                    <button class="button" name="buttonType" value="featured" type="submit">Featured</button>
                                </div>
                                <div class="col-md-2">
                                    <button class="button" name="buttonType" value="hot_selling" type="submit">Hot Selling</button>
                                </div>
                                <!--                                <div class="col-md-3">
                                                                    <select name="sortPrice" class="form-control">
                                                                        <option value="0">Price:</option>
                                                                        <option value="1" >Low to high</option>
                                                                        <option value="2" >High to low</option>
                                                                    </select>
                                                                </div>-->
                            </div>

                            <c:forEach var="product" items="${requestScope.productList}">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product" >
                                        <div class="product-img">
                                            <!-- Assuming you have an image URL property in your Product class -->
                                            <img src="<c:out value="${product.imageProduct}" />" alt="<c:out value="${product.productName}"/> " width ="100" height ="270">
                                            <div class="product-label">
                                                <span class="sale">${product.sold}</span>
                                                <span class="new">sold</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="product_detail?id=${product.id}&pkId=-1"><c:out value="${product.productName}"/></a></h3>
                                            <div class="product-rating">
                                                <!-- You can add rating stars here if applicable -->
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="store-filter clearfix">
                            <ul class="store-pagination">
                                <c:set value="${requestScope.page}" var="page"/>
                                <c:set value="${requestScope.urlpath}" var="urlpat" />
                                <c:if test="${urlpat ne 'filterPath'}">
                                    <c:forEach begin="${1}" end="${requestScope.numPage}" var="i">
                                        <li class="${i==page?"active":""}"> <a href="view-store?userid=${user.id}&page=${i}">${i}</a></li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${urlpat eq 'filterPath'}">
                                        <c:forEach begin="${1}" end="${requestScope.numPage}" var="i">
                                        <li class="${i==page?"active":""}"> <a href="filter-view-store?${requestScope.listServices}buttonType=${requestScope.buttonType}&uid=${user.id}&page=${i}">${i}</a></li>
                                        </c:forEach>
                                    </c:if>
                            </ul>
                        </div>
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
        </form>

        <%@include file="footer.jsp" %>

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
