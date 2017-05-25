<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/8/15
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="generator" content="sublime text" />
  <meta name="copyright" content="Donald">
  <meta name="author" content="Donald" >
  <meta name="keywords" content="login" />
  <link href="<c:url value='/jsps/css/user/login.css'/>" rel="stylesheet" type="text/css">
  <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
  <script src="<c:url value='/js/jquery-2.1.1.min.js'/>"></script>
  <script src="<c:url value='/js/bootstrap.min.js'/>"></script>


  <title>登录-地铁</title>

  <script type="text/javascript">
    $(function(){/*Map<String(Cookie名称), Cookie(Cookie本身)>*/
      var username = window.decodeURI("${cookie.username.value}");
      if("${requestScope.user.username}"){
        username = "${requestScope.user.username}";
      }
      $("#username").val(username);
    });
  </script>
</head>
<body>
<div class="yang">
  <div class="yang-head">
    <div class="container fn-clear">
      <ul class="container-left">
        <li class="container-left-item container-left-first">
          <a href="#" class="on">地铁APP</a>
        </li>
      </ul>
      <ul class="container-right">
        <li class="container-right-item">
          <a href="<c:url value='/jsps/main.jsp'/>" >首页</a>
        </li>
        <li class="container-seperator"></li>
        <li class="container-right-item">
          <a href="#">关于我们</a>
        </li>
        <li class="container-seperator"></li>
        <li class="container-right-item">
          <a href="#">提建议</a>
        </li>
      </ul>
    </div>
  </div>

  <div class="yang-body fn-clear">
    <h1 class="yang-body-logo">
      <a href="#" class="link">
        <img src="<c:url value='/image/logo-sub.png'/>"  class="alipy-logo" />
      </a>
    </h1>
    <div class="yang-body-login">
      <ul class="ui-nav">
        <li class data-status="show_qr">扫码登录</li>
        <li class="active">账密登录</li>
        <br class="clear-float">
      </ul>


      <div class="login login-modern">
        <form name="loginForm" method="post" class="ui-form" id="login" class="ui-form" action="<c:url value='/UserServlet'/>">
          <input type="hidden" name="method" value="login" />
          <fieldset>
            <c:if test="${ !empty msg  }" >
              <div class="sl-error sl-error-display">
                  <span class="sl-error-text">${msg}
                  </span>
              </div>
            </c:if>


            <div class="ui-form-item">
              <div class="input-group">
                   <span class="input-group-addon">
                      <i class="glyphicon glyphicon-user"></i>
                   </span>
                <input id="username" name="username" value="${user.username}" type="text" class="yang-form-control" placeholder="用户名">
              </div>
            </div>

            <div class="ui-form-item ui-form-item-20pd">
              <div class="input-group">
                     <span class="input-group-addon">
                        <i class="glyphicon glyphicon-list-alt"></i>
                     </span>
                <input id="userpasswd" name="userpasswd" value="${user.userpasswd}" type="password" class="yang-form-control" placeholder="">
              </div>

              <p class="ui-form-other ui-form-other-fg">
                <a href="#" class="textlink forgot" tabindex="5"  target="_blank">忘记登录密码？</a>
              </p>
            </div>

            <div class="ui-form-item ui-form-item-30pd">
              <input type="submit" name="" value="登 录" class="ui-button" tabindex="4">
              <p class="ui-form-other ui-form-other-fg">
                <a href="<c:url value='/jsps/user/regist.jsp'/>" class="register" target="_blank" title="免费注册" tabindex="6">
                  免费注册
                </a>
              </p>
            </div>

          </fieldset>
        </form>
      </div>
    </div>
  </div>

  <div class="yang-foot">
    <div class="yang-foot-container">
      <p class="yang-foot-link">
        <a href="#">地铁网络自助售票系统</a>
      </p>
      <div class="copyright">
        Copyright &copy;By Donald
      </div>
    </div>
  </div>

  <div class="yang-background" style="width:1903px; height:1189px;top: -265px;">
    <img src="<c:url value='/image/login-bg.png'/>" class="yang-bg yang-bg-show" style="width:1903px;  height:1189px; " >
  </div>

</div>

</body>

</html>