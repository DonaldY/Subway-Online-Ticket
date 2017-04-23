<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/12/18
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="generator" content="sublime text" />
  <meta name="copyright" content="Donald">
  <meta name="author" content="Donald" >
  <meta name="keywords" content="desc" />
  <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/jsps/css/order/order.css'/>" rel="stylesheet" type="text/css">


    <title>订单详情-地铁</title>
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class = "sr-only">Donald</span>
        <span class = "icon-bar"></span>
        <span class = "icon-bar"></span>
        <span class = "icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Subway</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <c:choose>
          <c:when test="${empty sessionScope.sessionUser}">
            <li>
              <a href="<c:url value='/jsps/user/login.jsp'/>" ><span class="glyphicon glyphicon-user"></span> 登录</a>
            </li>
            <li>
              <a href="<c:url value='/jsps/user/regist.jsp'/>">注册</a>
            </li>
            <li>
              <a href="#">关于我们</a>
            </li>
          </c:when>
          <c:otherwise>
            <li>
              <a href="#"><span class="glyphicon glyphicon-user div-user"></span> ${sessionScope.sessionUser.username}</a>
            </li>
            <li>
              <a href="#">我的订单</a>
            </li>
            <li>
              <a href="<c:url value='/UserServlet?method=quit'/> ">退出</a>
            </li>
          </c:otherwise>
        </c:choose>

      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
</nav>
<!-- Page Content -->
<div class="order-container" style="background: url(<c:url value="/image/payBj.png" />)">

  <div class="order-row" >

    <div class="order-content-up">

      <div class="order-thumbnail">
          <img src="<c:url value='/image/erweima.png'/>" >
      </div>

      <div class="order-thumbnail">
        <spen class="order-text-serial-number">序列号：1704201205XXXX</spen>
      </div>

    </div>

    <div class="order-content-down">

      <div class="order-text">

        <div class="order-text-row-headline">
          <div class="order-text-city">
            城市：南京
          </div>

          <div class="order-text-time">
            时间：2017-4-23 10:13:23
          </div>
        </div>

        <div class="order-text-row text-station">
          <div class="order-text-from">
            出发点：仙林中心
          </div>

          <div class="order-text-to">
            目的地：雨花台
          </div>
        </div>


        <div class="order-text-orderItem" style="background: url(<c:url value="/image/payBj-2.png" />) no-repeat">
          <div class="order-text-row">
            <div class="order-text-number">
              单价：¥ 3
            </div>
          </div>
          <div class="order-text-row">
            <div class="order-text-price">
              <span>✖  　　　8</span>
            </div>
          </div>
          <div class="order-text-row">
            <div class="order-text-pay">
              小计：<span style="color: orangered" > ¥ <span style="font-size: 17px">24</span></span>
            </div>
          </div>
        </div>


      </div>

      <div class="order-text-button">
        <button type="button" class="btn btn-success" style="font-size: 20px;font-weight: 700;font-family: Microsoft
        YaHei;width: 342px;">
          <span class="glyphicon glyphicon-check"></span>　直接支付
        </button>
      </div>

    </div>

  </div>

</div>
<!-- Page Content -->
<%--<div class="container">

  <div class="row">

    <div class="col-md-9">

      <div class="thumbnail">
        <img class="img-responsive" src="http://placehold.it/800x300" alt="">
        <div class="caption-full">
          <h4 class="pull-right">$24.99</h4>
          <h4><a href="#">Product Name</a>
          </h4>
          <p>See more snippets like these online store reviews at <a target="_blank" href="http://bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
          <p>Want to make these reviews work? Check out
            <strong><a href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this building a review system tutorial</a>
            </strong>over at maxoffsky.com!</p>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
        </div>
        <div class="ratings">
          <p class="pull-right">3 reviews</p>
          <p>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span>
            4.0 stars
          </p>
        </div>
      </div>


    </div>

  </div>

</div>
<!-- /.container -->--%>
  <hr>

  <!-- Footer -->
  <footer>
    <div class="row">
      <div class="col-lg-12">
        <p align="center">Copyright &copy;By Donald</p>
      </div>
    </div>
    <!-- /.row -->
  </footer>

</body>

</html>
