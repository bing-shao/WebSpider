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
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/admin_style.css" />

<script src="<%=webRoot%>js/jquery-1.10.2.min.js"></script>
<script src="<%=webRoot%>js/jqplot.js"></script>
</head>
<body class="right_body">
	<div class="body">
		<div class="top_subnav" style="margin-top:-5px">网络机器人—龙龙 ＞找网址 ＞本次效能分析</div>
		<div class="title">
			<div class="title_info zs" style="margin-top: 10px;">
				${user.user_name } 您好，网络机器人—龙龙 为您服务
			</div>
		</div>	
	</div>
	<div id="chart0" style="margin-top:20px;margin-left:4%;width:250%;height:400px"></div>
	<div id="chart1" style="margin-top:20px;margin-left:4%;width:250%;height:400px"></div>
</body>
<script type="text/javascript">
$(document).ready(function() {
  	queryURL();
  	queryImage();
});
//URL折线图
function queryURL() {
		$.ajax({
		       type: "post",
		       url : "EfficiencyAction_efficiency",
		       dataType : 'json',
		       data:{
		       		fn:"queryURL"
		       },
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   			var jsondata = response.data;
			   			if(jsondata==""||jsondata==null){
			   				$("#chart0").html("网址统计暂无数据");
			   			}
			   			else{
			   				var values = new Array();
				   			var keys = new Array();
				   			var length = jsondata.length;
				   			var maxkey = 0;
				   			for(var i=0;i<length;i++){
				   				keys[i] = jsondata[i].STATURL_CREATTIME;
				   				if(jsondata[i].STATURL_TOTALTIME=="0"){
				   					values[i]=0;
				   				}else{
				   					values[i] =  parseInt(jsondata[i].STATURL_TOTALNUM)/ parseInt(jsondata[i].STATURL_TOTALTIME);
				   				}
				   				if(maxkey<values[i]){
				   					maxkey=values[i];
				   				}
				   			}
				   			
							var xingzh = 1;
							var data = [values]; 
							var data_max = parseInt(maxkey) * 2; //Y轴最大刻度 
							var line_title = ["网址抓取效率折线"]; //曲线名称 
							var y_label = "网址抓取效率（网址总个数/总时间）"; //Y轴标题 
							var x_label = "时间"; //X轴标题 
							var x = keys; //定义X轴刻度值 
							var title = "抓取网址效率趋势统计图"; //统计图标标题 
							j.jqplot.diagram.base("chart0", data, line_title, title, x, x_label, y_label, data_max, xingzh);
			   			}
			   			
				}
			});
}
//image折线图
function queryImage() {
		$.ajax({
		       type: "post",
		       url : "EfficiencyAction_efficiency",
		       dataType : 'json',
		       data:{
		       		fn:"queryImage"
		       },
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   			var jsondata = response.data;
			   			if(jsondata==""||jsondata==null){
			   				$("#chart1").html("图片统计暂无数据");
			   			}
			   			else{
			   				var values = new Array();
				   			var keys = new Array();
				   			var length = jsondata.length;
				   			var maxkey = 0;
				   			for(var i=0;i<length;i++){
				   				keys[i] = jsondata[i].STATURL_CREATTIME;
				   				if(jsondata[i].STATURL_TOTALTIME=="0"){
				   					values[i]=0;
				   				}else{
				   					values[i] =  parseInt(jsondata[i].STATURL_TOTALNUM)/ parseInt(jsondata[i].STATURL_TOTALTIME);
				   				}
				   				if(maxkey<values[i]){
				   					maxkey=values[i];
				   				}
				   			}
							var xingzh = 1;
							var data = [values]; 
							var data_max = parseInt(maxkey) * 2; //Y轴最大刻度 
							var line_title = ["网址抓取效率折线"]; //曲线名称 
							var y_label = "网址抓取效率（网址总个数/总时间）"; //Y轴标题 
							var x_label = "时间"; //X轴标题 
							var x = keys; //定义X轴刻度值 
							var title = "抓取网址效率趋势统计图"; //统计图标标题 
							j.jqplot.diagram.base("chart1", data, line_title, title, x, x_label, y_label, data_max, xingzh);
			   			}	
				}
			});
}
</script>
</html>

