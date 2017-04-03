<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/12/9
  Time: 15:12
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
  <meta name="keywords" content="regist" />
  <link href="<c:url value='/jsps/css/user/regist.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/css/font-awesome.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" type="text/css">
  <script src="<c:url value='/js/jquery-2.1.1.min.js'/>"></script>
  <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/jsps/js/user/regist.js'/>"></script>

  <title>注册-地铁</title>
</head>
<body class="login1 signup">
  <!-- Login Screen -->
  <div class="login-wrapper">
    <div class="login-container">
      <a href="./"><img width="100" height="30" src="<c:url value='/image/logo-login@2x.png'/>" /></a>
      <form action="<c:url value='/UserServlet'/>" method="post" id="registForm">
        <input type="hidden" name="method" value="regist" />
        <div class="form-group">
          <input class="form-control input-email" type="text" value="" placeholder="输入您的邮箱地址" id="email" name="email" required="required">
        </div>
        <div class="form-group">
          <input class="form-control input-userpasswd" type="password" value="" placeholder="输入密码" id="userpasswd" name="userpasswd" required="required">
        </div>
        <div class="form-group">
          <input class="form-control input-reuserpasswd" type="password" value="" placeholder="确认密码" id="reuserpasswd" name="reuserpasswd" required="required">
          <input type="submit" class="input-submit" id="submit" value="&#xf054;"  >
        </div>
        <div class="form-options">
          <label class="checkbox">
            <input class="form-check-input" type="checkbox" id="checkboxId" required="required"><span>同意《注册条款》</span>
          </label>
        </div>
      </form>
      <div class="social-login clearfix">
        <a class="btn btn-primary pull-left weibo" href="#"><i class="icon-weibo">
        </i>微博 账户登录</a><a class="btn btn-primary pull-right renren" href="#">
        <i class="icon-renren"></i>人人 账户登录</a>
      </div>
      <p class="signup">
        已经有账户了？ <a href="<c:url value='/jsps/user/login.jsp'/>">立即登录</a>
      </p>

      <script type="text/javascript">

      </script>

    </div>
  </div>

</body>
</html>
