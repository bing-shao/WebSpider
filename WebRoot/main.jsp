<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String webRoot = request.getContextPath() + "/";
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网络机器人—龙龙</title>
<%@include file="../taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=webRoot%>/css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="<%=webRoot%>/css/skins/tpphp.css" />
<script src="<%=webRoot%>/js/jquery-1.4.4.min.js"></script>
<script>
	function show(num) {
		$("#me"+num+"").toggle();
	}
</script>
</head>
<body style="overflow:hidden;">
	<div class="top">
		<div class="admin_logo">
			<img src="images/admin_logo.png">
		</div>
	</div>
	<div class="side_switch" id="side_switch"></div>
	<div class="side_switchl" id="side_switchl"></div>
	<div class="right">
		<IFRAME style="OVERFLOW: visible" id="main" name="main" src="default.jsp" frameBorder=0 width="100%" scrolling="yes" height="100%"></IFRAME>
	</div>

	<div class="left">
		<div class="top_member" style="margin-top: 12%;font-weight: bold;float: left;margin-left:35%;">
			<font color="white">欢迎您，${user.user_name }</font>
		</div>
		<div class="member_info">
			<div class="member_ico">
				<img src="images/a.png" width="43" height="43">
			</div>
			<a href="clearSession.jsp" class="system_log" style="float: left;margin-left: 93px;letter-spacing: 2px;">注销</a>
			<a href="main.jsp" src="images/index_ico.jpg" class="system_log" style="float: left;margin-left: 33px;letter-spacing: 2px;">首页</a>
		</div>
		<div class="left_title" onclick="show(1);">网络机器人—龙龙</div>
		<ul class="side" id="me1">
			<li ><a style="cursor: pointer;" onclick="show(2);">找网址</a></li>
			<ul class="side" id="me2">
			<li style="margin-left: 20px;width: 185px;" ><a href="<%=webRoot%>crawlURL/crawlURL.jsp" target="main" >网址抓取</a></li>
			<li style="margin-left: 20px;width: 185px;"><a href="<%=webRoot%>crawlURL/checkURL.jsp" target="main" >审核网址</a></li>
			<li style="margin-left: 20px;width: 185px;"><a href="<%=webRoot%>crawlURL/efficiencyURL.jsp" target="main" >本次效能分析</a></li>
			</ul>
			<li ><a style="cursor: pointer;" onclick="show(3);">找图片</a></li>
			<ul class="side" id="me3">
			<li style="margin-left: 20px;width: 185px;" ><a href="<%=webRoot%>crawlImages/crawlImages.jsp" target="main" >图片抓取</a></li>
			<li style="margin-left: 20px;width: 185px;"><a href="<%=webRoot%>crawlImages/checkImages.jsp" target="main" >审核图片</a></li>
			<li style="margin-left: 20px;width: 185px;"><a href="<%=webRoot%>crawlImages/efficiencyImages.jsp" target="main" >本次效能分析</a></li>
			</ul>
			<li ><a style="cursor: pointer;" onclick="show(4);">收藏夹</a></li>
			<ul class="side" id="me4">
			<li style="margin-left: 20px;width: 185px;" ><a href="<%=webRoot%>favorite/favoriteURL.jsp" target="main" >网址收藏夹</a></li>
			<li style="margin-left: 20px;width: 185px;" ><a href="<%=webRoot%>favorite/favoriteImages.jsp" target="main" >图片收藏夹</a></li>
			</ul>
			<li ><a href="<%=webRoot%>efficiency/efficiency.jsp" target="main" >用户抓取效能分析</a></li>
		</ul>
	</div>
<script type="text/javascript">
		$(function(){
			$("a").click(function(){
				$(this).attr("class","selected");
				$(this).parent().siblings().children().removeAttr("class");
			})
			$("#side_switch").click(function(){
				$(".top_member").hide();
				$(".left").hide();
				$(".right").css('left',5);
				$(this).hide();
				$("#side_switchl").show();
			})
			$("#side_switchl").click(function(){
				$(".top_member").show();
				$(".left").show();
				$(".right").css('left',205);
				$(this).hide();
				$("#side_switch").show();
			})
		})
</script>
</body>
</html>

