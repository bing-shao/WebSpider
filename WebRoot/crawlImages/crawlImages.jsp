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
<link type="text/css" rel="stylesheet" href="<%=webRoot%>css/zzsc.css" />
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/admin_style.css" />

<script src="<%=webRoot%>/js/jquery-1.4.4.min.js"></script>
<script src="<%=webRoot%>/js/iframe.js"></script>
</head>
<body class="right_body">
	<div class="body">
		<div class="top_subnav" style="margin-top:-5px">网络机器人—龙龙 ＞找图片 ＞图片抓取</div>
		<div class="title">
			<div class="title_info zs" style="margin-top: 10px;">
				${user.user_name } 您好，网络机器人—龙龙 为您服务
			</div>
		</div>	
	</div>
	<div style="margin-left: 33%;margin-top: 7%;">
	   <div style="margin: 12px;margin-left: 5%;"><label style="font-size: 40;font-family: '微软雅黑'"><b>嗨！来找一找图片吧！<b></label></div>
	   <div>
	   	<img alt="网络机器人—龙龙" src="<%=webRoot%>/images/logo.png"/>
	   </div>
	   <div class="filed fl" style="margin-top: 20px;padding-left: 1px">
	   	<label style="font-size: 10;margin-left:27px;margin-top: -4px;letter-spacing:1px;">顶级网址:</label>
	   	<input type="text" id="text_url"  class="text" size="20" style="margin-left: 95px;"/><br><br>
	   	<label style="font-size: 10;margin-left:27px;margin-top: -4px;letter-spacing:1px;">搜索深度:</label>
	   	<input type="text" id="text_depth"  class="text" size="20" style="margin-left: 95px;"/><br><br>
	   	<label style="font-size: 10;margin-left:27px;margin-top: -4px;letter-spacing:1px;">线程数量:</label>
	   	<input type="text" id="text_num"  class="text" size="20" style="margin-left: 95px;"/>
	   </div>
	   <div class="filed fl" style="margin-top: 21px;">
				<button class="btn" id="btn"></button>
		</div>
	 </div>
	
</body>
<script type="text/javascript">
	$("#btn").click(function(){
		var url=$("#text_url").val();
		var depth=$("#text_depth").val();
		var num=$("#text_num").val();
		$.ajax({
		       type: "post",
		       url : "SpiderImagesAction_crawlImages",
		       dataType : 'json',
		       data : {
		       		  url:url,
		       		  depth:depth,
		       		  num:num
		       },
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   		window.location.href="checkImages.jsp";
				}
			});
		});
</script>
</html>

