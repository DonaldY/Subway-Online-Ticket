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
    <link href="<c:url value='/jsps/css/order/desc.css'/>" rel="stylesheet" type="text/css">


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
          <a class="navbar-brand" href="<c:url value='/jsps/main.jsp'/>">Subway</a>
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
                  <a href="<c:url value='/OrderServlet?method=showOrderList&status=0'/>">我的订单</a>
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
            <spen class="order-text-serial-number">序列号：${order.serialNum}</spen>
          </div>

        </div>

        <div class="order-content-down">

          <div class="order-text">

            <div class="order-text-row-headline">
              <div class="order-text-city">
                <span>城市：</span><span>${order.city}</span>
              </div>

              <div class="order-text-time">
                <span>时间：</span><span>${order.orderTime}</span>
              </div>
            </div>

            <div class="order-text-row text-station">
              <div class="order-text-from">
                <span>出发路线：</span><span>${order.fromPath}</span>
              </div>

              <div class="order-text-to">
                <span>目的路线：</span><span>${order.toPath}</span>
              </div>
            </div>

            <div class="order-text-row text-station">
              <div class="order-text-from">
                <span>出发站点：</span><span>${order.fromStation}</span>
              </div>

              <div class="order-text-to">
                <span>目的站点：</span><span>${order.toStation}</span>
              </div>
            </div>


            <div class="order-text-orderItem" style="background: url(<c:url value="/image/payBj-2.png" />) no-repeat">
              <div class="order-text-row">
                <div class="order-text-number">
                  单价：¥ <span>${order.price}</span>
                </div>
              </div>
              <div class="order-text-row">
                <div class="order-text-price">
                  <span>✖  　　　</span><span>${order.ticketNum}</span>
                </div>
              </div>
              <div class="order-text-row">
                <div class="order-text-pay">
                  小计：<span style="color: orangered" > ¥ <span style="font-size: 17px">${order.totalPrice}</span></span>
                </div>
              </div>
            </div>


          </div>




          <div class="order-text-button">


            <c:if test="${order.status eq 1 and btn eq 'pay'}">
              <a href="<c:url value='/OrderServlet?method=paymentPre&oid=${order.oid }'/>">
                <button type="button" class="btn btn-success" style="font-size: 20px;font-weight: 700;font-family: Microsoft
            YaHei;width: 439.23px;">
                  <span class="glyphicon glyphicon-check"></span>　直接支付
                </button>
              </a>
            </c:if>

            <c:if test="${order.status eq 1 and btn eq 'cancel'}">
              <a id="cancel" href="<c:url value='/OrderServlet?method=cancel&oid=${order.oid }'/>">
                <button type="button" class="btn btn-warning" style="font-size: 20px;font-weight: 700;font-family: Microsoft
            YaHei;width: 439.23px;">
                  <span class="glyphicon glyphicon-check"></span>　取消订单
                </button>
              </a>
            </c:if>

          </div>

        </div>

      </div>

    </div>

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
