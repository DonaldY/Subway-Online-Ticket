<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/12/19
  Time: 21:16
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
  <link href="<c:url value='/jsps/css/order/orderlist.css'/>" rel="stylesheet" type="text/css">


      <title>订单列表-地铁</title>
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
    <div class="container">

      <div class="row">

        <div class="col-md-3">
          <p class="lead">Subway-Order-List</p>
          <div class="list-group">
            <a href="#" class="list-group-item active">Category 1</a>
            <a href="#" class="list-group-item">Category 2</a>
            <a href="#" class="list-group-item">Category 3</a>
          </div>
        </div>

        <div class="col-md-9">

          <div class="thumbnail">

            <br>

            <!-- 导航 -->
            <ul class="nav nav-tabs">
              <li class="active"><a href="#">全部订单</a></li>
              <li ><a href="#">未付款订单</a></li>
              <li ><a href="#">已付款订单</a></li>
              <li ><a href="#">已取消订单</a></li>
              <li ><a href="#">已失效订单</a></li>
            </ul>

            <!-- Title -->
            <div class="order-item-title">

              <div class="order-item-title-col-1">
                <span>小票子</span>
              </div>

              <div class="order-item-title-col-2">
                <span>单价</span>
              </div>

              <div class="order-item-title-col-3">
                <span>数量</span>
              </div>

              <div class="order-item-title-col-4">
                <span>交易状态</span>
              </div>

            </div>
            <!-- / Title -->

            <!-- Item -->
            <div class="order-item-detail" onclick="">

              <div class="order-item-detail-time">
                　<span style="font-weight: 700;">2017-5-2</span>　　<span>订单号：123456789</span>
              </div>

              <div class="order-item-detail-items">

                <div class="order-item-detail-items-img">
                  <img src="<c:url value='/QR-Code_img/test_b.png'/>" >
                </div>

                <div class="order-item-detail-items-station">
                  <p><span>城市：</span><span>南京</span></p>
                  <p class="station-row"><span >出发站：</span><span>仙林中心</span></p>
                  <p class="station-row"><span>目的站：</span><span>雨花台</span></p>
                </div>

                <div class="order-item-detail-items-price">
                  <p class="price-row">
                    <span style="">￥</span><span>4</span>
                  </p>
                </div>

                <div class="order-item-detail-items-num">
                  <p class="num-row">
                    <span>2</span>
                  </p>
                </div>

                <div class="order-item-detail-items-status">
                  <p class="status-row">
                    <span>未付款</span>
                  </p>
                  <%--<p class="status-row">
                    <span>已付款</span>
                  </p>
                  <p class="status-row">
                    <span>已取消</span>
                  </p>
                  <p class="status-row">
                    <span>已失效</span>
                  </p>--%>

                </div>
              </div>
              <!-- /Item -->

            </div>

            <!-- Pagination -->

            <nav style="text-align:center;">
              <ul class="pagination" >
                <li class="page-item disabled">
                  <span class="page-link">Previous</span>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active">
                    <span class="page-link">
                      2
                    <span class="sr-only">(current)</span>
                    </span>
                </li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">Next</a>
                </li>
              </ul>
            </nav>

            <!-- /Pagination -->




        </div>

      </div>

    </div>
    <!-- /.container -->

    <div class="container">

      <hr>

      <!-- Footer -->
      <footer>
        <div class="row">
          <div class="col-lg-12">
            <p align="center">Copyright &copy;By Donald</p>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.container -->

    <%--<!-- Page Content -->
    <div class="order-container">



    </div>
--%>


  </body>
</html>
