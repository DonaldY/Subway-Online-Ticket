<%--
  Created by IntelliJ IDEA.
  User: donal
  Date: 2017/6/2
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>地铁-支付</title>
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
                                <a href="#" >关于我们</a>
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


</body>


</html>
