<%-- 
    Document   : payment
    Created on : Feb 28, 2023, 9:52:52 AM
    Author     : admin
--%>

<%-- 
    Document   : reset_password
    Created on : Feb 24, 2023, 8:04:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <div class="form-gap"></div>
    <div class="container" style="margin-top: 20px">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3><i class="fa fa-lock fa-4x"></i></h3>
                            <h2 class="text-center">Tour Payment </h2>
                            <p>You can choose the payment method</p>
                            <button type="button"> Pay at the office</button>
                            <button type="button" onclick="chooseStatus(${requestScope.wallet.account_balance},${requestScope.tr.tour_price})"> Pay with your wallet</button>
                            <script>
                                function chooseStatus(acc_bl, price) {
                                        var result = confirm("Pay with your wallet");
                                        if (result){
                                        if (acc_bl >= price) {
                                            $.ajax({
                                                type: 'get',
                                                url: '/swp391_project/payment',
                                                data: {
                                                    a: acc_bl,
                                                    b: price
                                                },
                                                success: function (data) {
                                                    Console.log(data);
                                                }
                                            });
                                        } else
                                            document.getElementById("thongbao").innerHTML = "myValue";
                                    }
                                }
                            
                            </script>
                            <!--                  <div class="panel-body">
                                
                                                <form id="register-form" role="form" autocomplete="off" action="reset"class="form" method="post">
                                
                                                  <div class="form-group">
                                                    <div class="input-group">
                                                      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                                      <input id="email" value="${email}" name="email" placeholder="email address" class="form-control"  type="email">
                                                     
                                                    </div>
                                                       <label style="color: red">${msgEmail}</label>
                                                  </div>
                                                  <div class="form-group">
                                                    <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                                  </div>
                                                  
                                                  <input type="hidden" class="hide" name="token" id="token" value=""> 
                                                  <label style="color: green">${msgSuccess}</label>
                                                </form>
                                
                                              </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</html>


