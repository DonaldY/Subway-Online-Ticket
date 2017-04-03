<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/12/10
  Time: 10:31
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
  <meta name="keywords" content="msg" />
  <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/css/msg/msg.css'/>" rel="stylesheet" type="text/css">
    <title>消息-地铁</title>
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
                <a href="" >关于我们</a>
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

  <div class="container-msg">
    <div class="header-msg">
      <br class="cbt">
      <div class="logo-msg">
        <a href="/" >
          <h1 class="tagline">Subway-Ticket-Online</h1>
        </a>
      </div>
      <hr>
    </div>


    <div  class="content-msg">

      <div class="mainbar-full-msg">
        <div class="page-description">
          <c:choose>
            <c:when test="${code eq 'success'}">
              <div class="val-message val-success">

                <span class="glyphicon glyphicon-ok" title="success" id="icon-msg-success"> </span>

                <p>${msg}</p>
              </div>
            </c:when>
            <c:otherwise>
              <div class="val-message val-default">

                <span class="glyphicon glyphicon-remove" title="default" id="icon-msg-default"> </span>

                <p>${msg}</p>
              </div>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>

  </div>

  <div class="footer-msg">
    <hr>
    <p align="center">Copyright &copy;By Donald</p>
  </div>
</body>
</html>
