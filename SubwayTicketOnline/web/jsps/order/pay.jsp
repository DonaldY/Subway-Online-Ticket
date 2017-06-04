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
    <meta charset="UTF-8" />
    <meta name="generator" content="sublime text" />
    <meta name="copyright" content="Donald">
    <meta name="author" content="Donald" >
    <meta name="keywords" content="desc" />
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/jsps/css/order/pay.css'/>" rel="stylesheet" type="text/css">

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
    <!-- /. Navigation -->


    <div class="pay-container">

        <div class="pay-order-info">

            <p>
                <span class="">支付金额：</span><span class="pay-order-info-RMB">&yen;${order.totalPrice}</span>
            </p>

            <p>
                <span class="">订单号：</span><span>${order.oid}</span>
            </p>


        </div>

        <form action="<c:url value='/OrderServlet'/>" method="post" id="payForm" target="_top">

            <input type="hidden" name="method" value="payment"/>
            <input type="hidden" name="oid" value="${order.oid }"/>

            <div class="pay-bank">

                <p class="pay-bank-title"><span>选择网上银行</span></p>

                <div class="pay-bank-detail">

                    <div class="pay-bank-detail-item">
                        <input id="ICBC-NET-B2C" type="radio" name="yh" value="ICBC-NET-B2C" checked="checked"/>
                        <img name="ICBC-NET-B2C" align="middle" src="<c:url value='/bank_img/icbc.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CMBCHINA-NET-B2C" type="radio" name="yh" value="CMBCHINA-NET-B2C"/>
                        <img name="CMBCHINA-NET-B2C" align="middle" src="<c:url value='/bank_img/cmb.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="ABC-NET-B2C" type="radio" name="yh" value="ABC-NET-B2C"/>
                        <img name="ABC-NET-B2C" align="middle" src="<c:url value='/bank_img/abc.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CCB-NET-B2C" type="radio" name="yh" value="CCB-NET-B2C"/>
                        <img name="CCB-NET-B2C" align="middle" src="<c:url value='/bank_img/ccb.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="BCCB-NET-B2C" type="radio" name="yh" value="BCCB-NET-B2C"/>
                        <img name="BCCB-NET-B2C" align="middle" src="<c:url value='/bank_img/bj.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="BOCO-NET-B2C" type="radio" name="yh" value="BOCO-NET-B2C"/>
                        <img name="BOCO-NET-B2C" align="middle" src="<c:url value='/bank_img/bcc.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CIB-NET-B2C" type="radio" name="yh" value="CIB-NET-B2C"/>
                        <img name="CIB-NET-B2C" align="middle" src="<c:url value='/bank_img/cib.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="NJCB-NET-B2C" type="radio" name="yh" value="NJCB-NET-B2C"/>
                        <img name="NJCB-NET-B2C" align="middle" src="<c:url value='/bank_img/nanjing.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CMBC-NET-B2C" type="radio" name="yh" value="CMBC-NET-B2C"/>
                        <img name="CMBC-NET-B2C" align="middle" src="<c:url value='/bank_img/cmbc.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CEB-NET-B2C" type="radio" name="yh" value="CEB-NET-B2C"/>
                        <img name="CEB-NET-B2C" align="middle" src="<c:url value='/bank_img/guangda.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="BOC-NET-B2C" type="radio" name="yh" value="BOC-NET-B2C"/>
                        <img name="BOC-NET-B2C" align="middle" src="<c:url value='/bank_img/bc.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="PINGANBANK-NET" type="radio" name="yh" value="PINGANBANK-NET"/>
                        <img name="PINGANBANK-NET" align="middle" src="<c:url value='/bank_img/pingan.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CBHB-NET-B2C" type="radio" name="yh" value="CBHB-NET-B2C"/>
                        <img name="CBHB-NET-B2C" align="middle" src="<c:url value='/bank_img/bh.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="HKBEA-NET-B2C" type="radio" name="yh" value="HKBEA-NET-B2C"/>
                        <img name="HKBEA-NET-B2C" align="middle" src="<c:url value='/bank_img/dy.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="NBCB-NET-B2C" type="radio" name="yh" value="NBCB-NET-B2C"/>
                        <img name="NBCB-NET-B2C" align="middle" src="<c:url value='/bank_img/ningbo.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="ECITIC-NET-B2C" type="radio" name="yh" value="ECITIC-NET-B2C"/>
                        <img name="ECITIC-NET-B2C" align="middle" src="<c:url value='/bank_img/zx.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="SDB-NET-B2C" type="radio" name="yh" value="SDB-NET-B2C"/>
                        <img name="SDB-NET-B2C" align="middle" src="<c:url value='/bank_img/sfz.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="GDB-NET-B2C" type="radio" name="yh" value="GDB-NET-B2C"/>
                        <img name="GDB-NET-B2C" align="middle" src="<c:url value='/bank_img/gf.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="SHB-NET-B2C" type="radio" name="yh" value="SHB-NET-B2C"/>
                        <img name="SHB-NET-B2C" align="middle" src="<c:url value='/bank_img/sh.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="SPDB-NET-B2C" type="radio" name="yh" value="SPDB-NET-B2C"/>
                        <img name="SPDB-NET-B2C" align="middle" src="<c:url value='/bank_img/shpd.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="POST-NET-B2C" type="radio" name="yh" value="POST-NET-B2C"/>
                        <img name="POST-NET-B2C" align="middle" src="<c:url value='/bank_img/post.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="BJRCB-NET-B2C" type="radio" name="yh" value="BJRCB-NET-B2C"/>
                        <img name="BJRCB-NET-B2C" align="middle" src="<c:url value='/bank_img/beijingnongshang.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="HXB-NET-B2C" type="radio" name="yh" value="HXB-NET-B2C"/>
                        <img name="HXB-NET-B2C" align="middle" src="<c:url value='/bank_img/hx.bmp'/>"/>
                    </div>

                    <div class="pay-bank-detail-item">
                        <input id="CZ-NET-B2C" type="radio" name="yh" value="CZ-NET-B2C"/>
                        <img name="CZ-NET-B2C" align="middle" src="<c:url value='/bank_img/zheshang.bmp'/>"/>
                    </div>


                </div>

                <div class="pay-bank-button">
                    <button type="submit" class="sub">下一步</button>
                </div>

            </div>


        </form>

    </div>

    <script type="text/javascript">
        $(function() {
            $("img").click(function() {
                $("#" + $(this).attr("name")).attr("checked", true);
            });
        });
    </script>

    <hr style="width: 780px">

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
