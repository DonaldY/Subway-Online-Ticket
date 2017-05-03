<%--
  Created by IntelliJ IDEA.
  User: Donald
  Date: 2016/8/9
  Time: 22:56
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
    <meta name="keywords" content="main" />
    <link href="<c:url value='/css/main/main.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/css/business-frontpage.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" type="text/css">


    <script src="<c:url value='/js/jquery-2.1.1.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap-datetimepicker.js'/>" charset="UTF-8"></script>
    <script src="<c:url value='/js/bootstrap-datetimepicker.fr.js'/>" charset="UTF-8"></script>
    <script src="<c:url value='/js/main/main.js'/>"></script>
    <title>首页-地铁</title>
  </head>
  <body onload="loadCity()">
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

    <!-- Image Background Page Header -->
    <!-- Note: The background image is set within the business-casual.css file. -->
    <header class="business-header">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="tagline">The Subway Ticket Online</h1>
          </div>
        </div>
        <div id = "js-search-box" class="m-search-box">
          <div class="m-search-box-inner clrfix" id="js-search-form">
            <form  class="form-inline" role="form" action="<c:url value='/UserServlet'/>" method="post"
                   id="createOrder">
              <div class="form-appearance">

                <div class="location-button">
                    <div class="input-group ">
                      <div class="input-group-btn" >
                        <button type="button" class="btn btn-default
                                                         dropdown-toggle" data-toggle="dropdown">
                          <i class="glyphicon glyphicon-tree-deciduous"></i>
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="cityId">
                          <li  value="">城市</li>
                        </ul>
                      </div>
                      <input type="text" class="yang-form-control"   placeholder="所在城市" value="" id="inputCity"
                             onchange="loadParent()" readonly>
                      <input type="hidden" id="inputCategoryParent" value="" /><br/>
                    </div>
                </div>

                <div class="between-bar-city">

                </div>


                <div class="location-button">
                  <div class="input-group input-group-ticket">
                    <div class="input-group-btn" >
                      <button type="button" class="btn btn-default
                                                       dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-th"></i>
                        <span class="caret"></span>
                      </button>
                      <ul class="dropdown-menu" id="ticket">
                        <li  value="1">1</li>
                        <li  value="2">2</li>
                        <li  value="3">3</li>
                        <li  value="4">4</li>
                        <li  value="5">5</li>
                        <li  value="6">6</li>
                        <li  value="7">7</li>
                        <li  value="8">8</li>
                      </ul>
                    </div>
                    <input type="text" class="yang-form-control-ticket"   placeholder="请选择所需票数" value="" id="ticketNum" readonly>
                    <span class="input-group-addon-ticket">张</span>
                    <input type="hidden" id="inputTicketNum" value="" /><br/>
                  </div>
                </div>



                <div class="row-operate">
                  <div class="input-from">



                    <div class="input-group ">
                      <div class="input-group-btn" >
                        <button type="button" class="btn btn-default
                                                             dropdown-toggle" data-toggle="dropdown">
                          <i class="glyphicon glyphicon-map-marker"></i>
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="fromPath">
                          <li value="">请选择城市</li>

                        </ul>
                      </div>
                      <input type="text" class="yang-form-control"   placeholder="出发线路" value="" id="inputFromPath"
                             onchange="loadChildren1()" readonly>
                      <input type="hidden" id="inputCategoryChild1" value="" /><br/>
                    </div>

                    <div class="input-group">
                      <div class="input-group-btn" >
                        <button type="button" class="btn btn-default
                                                             dropdown-toggle" data-toggle="dropdown">
                          <i class="glyphicon glyphicon-map-marker"></i>
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="fromStation">
                          <li value="请选择出发站点">请选择出发站点</li>
                        </ul>
                      </div>
                      <input type="text" class="yang-form-control"   placeholder="出发站点" value=""
                             id="inputFromStation" readonly >
                      <input type="hidden" id="inputStation1" value="" /><br/>
                    </div>




                  </div>

                  <div class="exchange-logo">
                    <a href="#">
                      <i class="glyphicon glyphicon-transfer" style="color: rgb(212, 106, 64);" ></i>
                    </a>
                  </div>

                  <div class="input-to">


                    <div class="input-group ">
                      <div class="input-group-btn" >
                        <button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown">
                          <i class="glyphicon glyphicon-map-marker"></i>
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="toPath">
                          <li value="请选择到达线路">请选择到达线路</li>
                        </ul>
                      </div>
                      <input type="text" class="yang-form-control"   placeholder="到达线路" value="" id="inputToPath"
                             onchange="loadChildren2()" readonly>
                      <input type="hidden" id="inputCategoryChild2" value="" /><br/>
                    </div>

                    <div class="input-group ">
                      <div class="input-group-btn" >
                        <button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown">
                          <i class="glyphicon glyphicon-map-marker"></i>
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" id="toStation">
                          <li value="请选择到达站点">请选择到达站点</li>
                        </ul>
                      </div>
                      <input type="text" class="yang-form-control"   placeholder="到达站点"  value="" id="inputToStation"
                             readonly>
                      <input type="hidden" id="inputStation2" value="" /><br/>
                    </div>


                  </div>


                  <div class="input-date">
                    <div class="input-group ">
                      <div class="form-group">
                        <div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd"
                             data-link-field="inputDate" data-link-format="yyyy-mm-dd" >

                          <span class="input-group-addon input-date-logo"><span class="glyphicon glyphicon-calendar"></span></span>
                          <input class="form-control-date "  type="text" value="" placeholder="yy-mm-dd" readonly>
                          <span class="input-group-addon .input-date-logo"><span class="glyphicon glyphicon-remove"></span></span>

                        </div>
                        <input type="hidden" id="inputDate" value="" /><br/>
                      </div>
                    </div>
                  </div>

                  <script type="text/javascript">
                    $('.form_date').datetimepicker({
                      //language:  'fr',
                      weekStart: 1,
                      todayBtn:  1,
                      autoclose: 1,
                      todayHighlight: 1,
                      startView: 2,
                      minView: 2,
                      forceParse: 0
                    });
                  </script>


                  <div class="between-bar">

                  </div>

                  <div class="submit-btn-appearance">
                    <button type="submit" class="btn btn-default" style="font-size: 20px " disabled="disabled" id="submit">
                      <span class="glyphicon glyphicon-check"></span> 　购　买　
                    </button>
                  </div>
                </div>


              </div>
            </form>
          </div>
        </div>

      </div>
    </header>

    <!-- Page Content -->
    <div class="container">

      <hr>

      <div class="row">
        <div class="col-sm-4">
          <img class="img-circle img-responsive img-center" src="<c:url value='/image/njdt3.png'/>" alt="">
          <h2> 网上购票好处</h2>
          <p>　　在人潮涌动的地铁站，地铁网上购票可以让您更快速的取票进站和出站，并提供一次购多张操作，
          更快捷方便多人出行，同时解决零钱难得问题。</p>
        </div>
        <div class="col-sm-4">
          <img class="img-circle img-responsive img-center" src="<c:url value='/image/tb4.png'/>" alt="">
          <h2> 操作指导</h2>
          <p>　　浏览选择所需路线通过网上银行完成支付,系统会生成领取订单号和二维码，用户可凭订单号或二维码至地铁站自动取票机上自助取票</p>
        </div>
        <div class="col-sm-4">
          <img class="img-circle img-responsive img-center" src="<c:url value='/image/tb3.png'/>" alt="">
          <h2> 使用App</h2>
          <p>　　使用App，可以在便捷的同时下了解地铁的到达时间、线路等，并提供地图引导功能，各个出入口都有特殊
          标识，方便寻找，</p>
        </div>
      </div>
      <!-- /.row -->

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

    </div>

  </body>
</html>