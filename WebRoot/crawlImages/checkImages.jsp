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
<title>网络机器人-龙龙</title>
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/pagination.css" />
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/admin_style.css" />

<script src="<%=webRoot%>js/jquery-1.4.4.min.js"></script>
<script src="<%=webRoot%>js/iframe.js"></script>
<script src="<%=webRoot%>js/jquery.pagination.js"></script>
</head>
<body class="right_body">
	<div class="body">
		<div class="top_subnav" style="margin-top:-3px">网络机器人—龙龙 ＞找图片＞审核图片</div>
		<div class="title">
			<div class="title_info zs" style="margin-top: 10px;">
				${user.user_name } 您好，网络机器人—龙龙 为您服务</div>
		</div>
	</div>
	<div class="filed fl" style="margin-top: 6px;">
		<label>图片关键字：</label> <input type="text" id="condition" class="text" size="20" name="txt" style="margin-left: 70px">
	</div>
	<div class="filed fl" style="margin-top: 6px;">
		<button class="button" onclick="query()"></button>
	</div>
	<div class="tablelist" style="margin-top: 1px;">
		<table class="table">
			<thead>
				<tr>
					<th colspan="9" class="top_th">
					<a href="#" class="add" onclick="favorite()">收藏</a> 
					<a href="#" onclick="re()" class="refresh">刷新</a></th>
				</tr>
				<tr>
					<th width="5%"></th>
					<th width="5%">编号</th>
					<th width="35%">图片地址</th>
					<th width="5%">图片格式</th>
					<th width="35%">图片来源</th>
					<th width="5%">抓取深度</th>
					<th width='10%'>抓取时间</th>
				</tr>
				
			</thead>
			<tbody id="tbody" class="page" width="100%">
			</tbody>
		</table>
		<div class="pagination" id="page" style="margin-left: 58%"></div>
		</div>

	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {//页面加载时
	check();
	initlist();
});
//校验
function check(){
	$.ajax({
			   type: "post",
		       url : "SpiderImagesAction_check",
		       dataType : 'json',
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
			   		alert(response.data);
			   }
	});
}
//查询
function queryList(currPage,jg){
	var condition = $("#condition").val();
	$.ajax({
		       type: "post",
		       url : "SpiderImagesAction_queryImagesList",
		       dataType : 'json',
		       data: {
		       		currPage:currPage,
		       		condition:condition
		       }, 
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
					var jsondata=response.data;
					var length = jsondata.length;
					var html="";
					for(var i=0;i<length;i++){
						if(i%2==0){
							html=html+"<tr><td style=''><input type='checkbox'  name='chkb'></td>"+
									  "<td>"+(i+1+currPage*12)+"</td>"+
									  "<td><a href='"+jsondata[i].IMAGES_URL+"' target='main'>"+jsondata[i].IMAGES_URL+"</a></td>"+
									  "<td>"+jsondata[i].IMAGES_TYPE+"</td>"+
									  "<td>"+jsondata[i].IMAGES_SOURCE+"</td>"+
									  "<td>"+jsondata[i].IMAGES_DEPTH+"</td>"+
									  "<td>"+jsondata[i].IMAGES_CRAWL+"</td>"+
									  "</tr>";
						}else{
							html=html+"<tr><td  style='background:rgb(241, 241, 241);'><input type='checkbox'  name='chkb'></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+(i+1+currPage*12)+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'><a href='"+jsondata[i].IMAGES_URL+"' target='main'>"+jsondata[i].IMAGES_URL+"</a></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_TYPE+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_SOURCE+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_DEPTH+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_CRAWL+"</td>"+
									  "</tr>";
						}
					}
					$("#tbody").html(html);
				}
			});
}
//分页工具
var query = function(){
	var condition = $("#condition").val();
	$.ajax({
		url: "SpiderImagesAction_queryImagesList",
		type: "post",
		dataType : 'json',
		data : {
			currPage:"0",
			condition:condition
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success:function(response){
			if(response.size!=undefined && response.size>0){
				$("#page").pagination(response.size, {
					items_per_page : 12,
					num_edge_entries: 1,
					num_display_entries: 8,
					callback: queryList  //回调函数
				});
				queryList(0,null);
			}else{
				$("#tbody").html("暂无数据!");
			}
		}
	});  
}



//加载页面
function initList(currPage,jg){
	$.ajax({
		       type: "post",
		       url : "SpiderImagesAction_queryImagesList",
		       dataType : 'json',
		       data: {
		       		currPage:currPage,
		       		condition:""
		       }, 
			   contentType : "application/x-www-form-urlencoded; charset=utf-8",
			   success : function(response) {
					var jsondata=response.data;
					var length = jsondata.length;
					var html="";
					for(var i=0;i<length;i++){
						if(i%2==0){
							html=html+"<tr><td style=''><input type='checkbox'  name='chkb'></td>"+
										  "<td>"+(i+1+currPage*12)+"</td>"+
										  "<td><a href='"+jsondata[i].IMAGES_URL+"' target='main'>"+jsondata[i].IMAGES_URL+"</a></td>"+
										  "<td>"+jsondata[i].IMAGES_TYPE+"</td>"+
										  "<td>"+jsondata[i].IMAGES_SOURCE+"</td>"+
										  "<td>"+jsondata[i].IMAGES_DEPTH+"</td>"+
										  "<td>"+jsondata[i].IMAGES_CRAWL+"</td>"+
										  "</tr>";
						}else{
							html=html+"<tr><td  style='background:rgb(241, 241, 241);'><input type='checkbox'  name='chkb'></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+(i+1+currPage*12)+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'><a href='"+jsondata[i].IMAGES_URL+"' target='main'>"+jsondata[i].IMAGES_URL+"</a></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_TYPE+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_SOURCE+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_DEPTH+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].IMAGES_CRAWL+"</td>"+
									  "</tr>";
						}
					}
					$("#tbody").html(html);
				}
			});
}
//分页工具
var initlist = function(){
	$.ajax({
		url: "SpiderImagesAction_queryImagesList",
		type: "post",
		dataType : 'json',
		data : {
			currPage:"0",
			condition:""
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success:function(response){
			if(response.size!=undefined && response.size>0){
				$("#page").pagination(response.size, {
					items_per_page : 12,
					num_edge_entries: 1,
					num_display_entries: 8,
					callback: initList  //回调函数
				});
				initList(0,null);
			}else{
				$("#tbody").html("暂无数据!");
			}
		}
	});  
}
//收藏
function favorite(){
		 var data ="";
		 $("input:checkbox[name=chkb]:checked").each(function(){
		 	var images_url = $(this).parent().parent().children().eq(2).children().text();
		 	var images_type= $(this).parent().parent().children().eq(3).text();
		 	var images_source = $(this).parent().parent().children().eq(4).text();
		 	$.ajax({
		 		type : "post",
		 		url  : "SpiderImagesAction_favorite",
		 		dataType:'json',
		 		data : {
		 			images_url	 :  images_url,
		 			images_type  :	images_type,
		 			images_source:	images_source
		 		},
		 		async: false,
		 		contentType : "application/x-www-form-urlencoded; charset=utf-8",
			    success : function(response) {
		 		 		data=response.data;
		 		 }
		 	});
		 });
		 alert(data);
		 
}
function re(){//刷新
 	window.location.href="<%=webRoot%>crawlImages/checkImages.jsp";
	}
</script>
</html>
