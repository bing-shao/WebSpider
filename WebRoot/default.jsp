<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String webRoot = request.getContextPath() + "/";
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网络机器人-龙龙</title>

<link rel="stylesheet" type="text/css" href="<%=webRoot%>/css/admin_style.css" />

<script src="<%=webRoot%>/js/jquery-1.4.4.min.js"></script>
<script src="<%=webRoot%>/js/iframe.js"></script>
</head>
<body class="right_body">
	<div class="body">
		<div class="top_subnav" style="margin-top:-5px">网络机器人—龙龙 ＞ 首页</div>
		<div class="title">
			<div class="title_info zs" style="margin-top: 10px;">
				${user.user_name } 您好，网络机器人—龙龙 为您服务
			</div>
		</div>	
	</div>
	<div >
		<img src="images/wellcom.jpg" style="width: 92%;height: 83%;margin-left: 40px;margin-top: 12px;" scrolling="no">
	</div>
 	  
	
</body>
</html>

