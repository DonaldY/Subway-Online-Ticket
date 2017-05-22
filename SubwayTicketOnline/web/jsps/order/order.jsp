<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/12/19
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="generator" content="sublime text" />
    <meta name="copyright" content="Donald">
    <meta name="author" content="Donald" >
    <meta name="keywords" content="desc" />
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/jsps/css/order/order.css'/>" rel="stylesheet" type="text/css">

    <title>订单-地铁</title>
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

    <!-- container -->
    <div class="center-wrap order-wrap">

      <div class="order-left">
        <div class="clear-fix">
          <div class="station-container" style="height: 361.163px;">

            <div class="station-hd s-hd">
              <img src="<c:url value='/image/order/hdt.png'/>" />
              <span class="s-title">雨花台</span>
              <span style="font-size: 12px">至</span>
              <span class="s-title">仙林中心</span>
              <span>途径站点</span>
              <span class="s-title-num">共15站</span>
            </div>

            <div class="station-mn">

              <div class="routeMap">

                <ul class="s-clear">
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南</a>
                  </li>
                  <li class="ride">
                    <a href="" class="cl-station">南京南南京南南京南南京南</a>
                  </li>

                </ul>

              </div>

              <div class="s-info">
                <dl>
                  <dt style="width: auto; height: auto">
                    <img src="<c:url value='/image/order/changeS.png'/>" style="height: 80px; width: 80px;"/>

                  </dt>

                  <dd>
                    <ul>

                      <li>
                        <span>新街口</span>
                        <span>-></span>
                        <span>3号线</span>
                      </li>

                    </ul>
                  </dd>
                </dl>
              </div>

            </div>

          </div>

        </div>

        <div class="order-choose-info">
          <ul class="clear-fix">
            <li>中转站点</li>
            <li>中转站点</li>
            <li>中转站点</li>
            <li>中转站点</li>
          </ul>

        </div>

      </div>


      <div class="order-right">

        <div class="order-ad clear-fix">
          <img src="<c:url value='/image/order/title-ad.png'/>" />
        </div>

        <div class="order-content">
          <ul>
            <li>
              <label>目标城市：</label>
              <strong>南京</strong>
            </li>
            <li>
              <label>出发线路：</label>
              <strong>南京</strong>
            </li>
            <li>
              <label>出发站点：</label>
              <strong>南京</strong>
            </li>
            <li>
              <label>目的线路：</label>
              <strong>南京</strong>
            </li>
            <li>
              <label>目的站点：</label>
              <strong>南京</strong>
            </li>
            <li>
              <label>使用时间：</label>
              <em>2017-5-20</em>
            </li>
            <li class="line">
              <label>座位：</label>
              <strong>老、幼、病、残先坐</strong>
            </li>
            <li>
              <label>单价：</label>
              <span>¥ 2.00 　✖ 　2</span>
            </li>
            <li class="total">
              <label>总计：</label>
              <div>¥ 4.00</div>
            </li>
          </ul>
          <div class="order-submit">
            <a href="" class="sub">确认信息,下单</a>
          </div>
        </div>

      </div>

    </div>

    <div class="center-wrap order-foot">

      <div class="order-tips">
        <h4>特别提示：</h4>
        <ul>
          <li>1、下单前请仔细核对城市、线路、站点、时间等信息。</li>
          <li>2、下单后请于5分钟内完成支付，超时系统将取消订单。</li>
          <li>3、出发站点和目的站点为一样，则按2元票价。</li>
          <li>4、地铁票售出后暂不支持退换。</li>
        </ul>
      </div>

      <div class="order-info">
        <h4>友情信息：</h4><br/>

        <p>http://blog.csdn.net/fanfan4569</p>
        <p>客服电话：1111-12345678</p>
      </div>

    </div>

    <br/>

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
