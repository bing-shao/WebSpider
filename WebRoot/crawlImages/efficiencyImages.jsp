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
	<div id="chart1" style="margin-top:20px;width:99%;height:400px"></div>
	<div id="chart2" style="margin-top:20px;width:99%;height:400px"></div>
</body>
<script type="text/javascript">
$(document).ready(function() {
  	Histogram();
  	Polygram();
});

//柱状图
function Histogram() {
		$.ajax({
		       type: "post",
		       url : "EfficiencyImagesAction_efficiencyImages",
		       dataType : 'json',
		       data:{
		       		fn:"Histogram"
		       },
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   			var jsondata = response.data;
			   			var length = jsondata.length;
			   			var maxkey = 0; 
				   		var keys = new Array(parseInt(${imagesThreadCount}));
						var values = new Array(parseInt(${imagesThreadCount}));
						for(var i=0;i<length;i++){
						  var temp = parseInt(jsondata[i][0].substr(7));
						  keys[temp] = jsondata[i][0];
						  values[temp] =  parseInt(jsondata[i][1]);
						}
						for(var k=0;k<keys.length;k++){
							if(keys[k]==null){
							      keys[k]="thread-"+k;
							      values[k]=0;
							}
							if(values[k]>maxkey){
								  maxkey=values[k];
							}
						}
						var xingzh = 2;
						var data = [values]; 
						var data_max = parseInt(maxkey) * 2; //Y轴最大刻度 
						var line_title = ["线程利用率"]; //曲线名称 
						var y_label = "抓取个数"; //Y轴标题 
						var x_label = "线程名"; //X轴标题 
						var x = keys; //定义X轴刻度值 
						var title = "线程利用率统计图"; //统计图标标题 
						j.jqplot.diagram.base("chart1", data, line_title, title, x, x_label, y_label, data_max, xingzh);
				}
			});
}
//折线图
function Polygram() {
		$.ajax({
		       type: "post",
		       url : "EfficiencyImagesAction_efficiencyImages",
		       dataType : 'json',
		       data:{
		       		fn:"Polygram"
		       },
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   			var jsondata = response.data;
			   			var length = jsondata.length;
			   			var maxkey = 0; 
				   		var keys = new Array();
						var values = new Array();
			   			for(var i=0;i<length;i++){
						  keys[i] = jsondata[i][0];
						  values[i] =  parseInt(jsondata[i][1]);
						  if(values[i]>maxkey){
						  		maxkey=	values[i];
						  }
						}
				   		
						var xingzh = 1;
						var data = [values]; 
						var data_max = parseInt(maxkey) * 2; //Y轴最大刻度 
						var line_title = ["抓取效率趋势图"]; //曲线名称 
						var y_label = "抓取个数"; //Y轴标题 
						var x_label = "时间"; //X轴标题 
						var x = keys; //定义X轴刻度值 
						var title = "抓取效率趋势统计图"; //统计图标标题 
						j.jqplot.diagram.base("chart2", data, line_title, title, x, x_label, y_label, data_max, xingzh);
				}
			});
}
</script>
</html>

