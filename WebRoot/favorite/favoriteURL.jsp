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
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/admin_style.css" />
<link rel="stylesheet" type="text/css" href="<%=webRoot%>css/pagination.css" />

<script src="<%=webRoot%>js/jquery-1.4.4.min.js"></script>
<script src="<%=webRoot%>js/iframe.js"></script>
<script src="<%=webRoot%>js/jquery.pagination.js"></script>
</head>
<body class="right_body">
	<div class="body">
		<div class="top_subnav" style="margin-top:-3px">网络机器人—龙龙 ＞找网址＞审核网址</div>
		<div class="title">
			<div class="title_info zs" style="margin-top: 10px;">
				${user.user_name } 您好，网络机器人—龙龙 为您服务</div>
		</div>
	</div>
	<div class="filed fl" style="margin-top: 6px;">
		<label>网址关键字：</label> <input type="text" id="condition" class="text" size="20" name="txt" style="margin-left: 70px">
	</div>
	<div class="filed fl" style="margin-top: 6px;">
		<button class="button" onclick="query()"></button>
	</div>
	<div class="tablelist" style="margin-top: 1px;">
		<table class="table">
			<thead>
				<tr>
					<th colspan="9" class="top_th">
					<a href="#" onclick="edit()" class="edit">编辑 </a> 
					<a href="#" onclick="del()" class="delete">删除</a> 
					<a href="#" onclick="re()" class="refresh">刷新</a>
					<a href="#" onclick="down()" class="download">下载</a>
					</th>
					
				</tr>
				<tr>
					<th width="10%"></th>
					<th width="10%">编号</th>
					<th width="50%">网址</th>
					<th width="20%">备注</th>
					<th width='10%'>收藏时间</th>
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
	initlist();
});
//下载
function down(){
	 var data ="";
	 var i = 0;
	 $("input:checkbox[name=chkb]:checked").each(function(){
	 	i++;
	 	var webpage_url = $(this).parent().parent().children().eq(2).children().text();
	 	$.ajax({
		 		type : "post",
		 		url  : "FavoriteURLAction_favoriteURLAction",
		 		dataType:'json',
		 		data : {
		 			fn : "downloadList",
		 			webpage_url : webpage_url
		 		},
		 		async: false,
		 		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		 		success : function(response) {
		 			data = response.data;
		 		}
		 	});
	 	});
	 if(i==0){
	 	alert("请选择至少一个选项");
	 }else{
	 	alert(data);
	 }
}
//编辑
function edit(){
	 var i = 0;
	 $("input:checkbox[name=chkb]:checked").each(function(){
	 		i++;
	 });
	 if(i==0){
	 	alert("请选择一个选项");
	 }else if(i>1){
	 			alert("只能选择一个选项");
	 	}else if(i==1){
	 		var html="<textarea id='texta' onblur='save();'></textarea>";
	 		$("input:checkbox[name=chkb]:checked").parent().parent().children().eq(3).html(html);
	 		}
}
function save(){
	var webpage_remark = $("#texta").val();
	var webpage_unid = $("#texta").parent().parent().children().eq(0).children().val();
	$.ajax({
		 		type : "post",
		 		url  : "FavoriteURLAction_favoriteURLAction",
		 		dataType:'json',
		 		data : {
		 			fn : "updateRemark",
		 			webpage_unid : webpage_unid,
		 			webpage_remark:webpage_remark
		 		},
		 		contentType : "application/x-www-form-urlencoded; charset=utf-8",
			    success : function(response) {
			    		if(response.data=="修改成功"){
		 		 			$("#texta").parent().html(webpage_remark);
		 		 			}else{
		 		 			alert(response.data);
		 		 			}
		 		 }
		 	});
	
}
//删除
function del(){
	 var data ="";
	 var i = 0;
	 $("input:checkbox[name=chkb]:checked").each(function(){
	 	i++;
	 	var webpage_unid = $(this).val();
	 	$.ajax({
		 		type : "post",
		 		url  : "FavoriteURLAction_favoriteURLAction",
		 		dataType:'json',
		 		data : {
		 			fn : "deleteList",
		 			webpage_unid : webpage_unid
		 		},
		 		async: false,
		 		contentType : "application/x-www-form-urlencoded; charset=utf-8",
			    success : function(response) {
		 		 		data=response.data;
		 		 }
		 	});
	 	});
	 if(i==0){
	 	alert("请选择一个选项");
	 }else{
	 	alert(data);
	 	}
	 if(data=="删除成功"){
	 window.location.href="<%=webRoot%>favorite/favoriteURL.jsp"
	 }
}
//查询
function queryList(currPage,jg){
	var condition = $("#condition").val();
	$.ajax({
		       type: "post",
		       url : "FavoriteURLAction_favoriteURLAction",
		       dataType : 'json',
		       data: {
		       		fn:"queryURLList",
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
							html=html+"<tr><td style=''><input type='checkbox'  name='chkb' value='"+jsondata[i].WEBPAGE_UNID+"'></td>"+
									  "<td>"+(i+1+currPage*12)+"</td>"+
									  "<td><a href='"+jsondata[i].WEBPAGE_URL+"' target='main'>"+jsondata[i].WEBPAGE_URL+"</a></td>"+
									  "<td>"+jsondata[i].WEBPAGE_REMARK+"</td>"+
									  "<td>"+jsondata[i].WEBPAGE_CREATE_TIME+"</td>"+
									  "</tr>";
						}else{
							html=html+"<tr><td  style='background:rgb(241, 241, 241);'><input type='checkbox'  name='chkb' value='"+jsondata[i].WEBPAGE_UNID+"'></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+(i+1+currPage*12)+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'><a href='"+jsondata[i].WEBPAGE_URL+"' target='main'>"+jsondata[i].WEBPAGE_URL+"</a></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].WEBPAGE_REMARK+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].WEBPAGE_CREATE_TIME+"</td>"+
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
		url: "FavoriteURLAction_favoriteURLAction",
		type: "post",
		dataType : 'json',
		data : {
			fn:"queryURLList",
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
		       url : "FavoriteURLAction_favoriteURLAction",
		       dataType : 'json',
		       data: {
		       		fn:"queryURLList",
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
							html=html+"<tr><td style=''><input type='checkbox'  name='chkb' value='"+jsondata[i].WEBPAGE_UNID+"'></td>"+
									  "<td>"+(i+1+currPage*12)+"</td>"+
									  "<td><a href='"+jsondata[i].WEBPAGE_URL+"' target='main'>"+jsondata[i].WEBPAGE_URL+"</a></td>"+
									  "<td>"+jsondata[i].WEBPAGE_REMARK+"</td>"+
									  "<td>"+jsondata[i].WEBPAGE_CREATE_TIME+"</td>"+
									  "</tr>";
						}else{
							html=html+"<tr><td style='background:rgb(241, 241, 241);'><input type='checkbox'  name='chkb' value='"+jsondata[i].WEBPAGE_UNID+"'></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+(i+1+currPage*12)+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'><a href='"+jsondata[i].WEBPAGE_URL+"' target='main'>"+jsondata[i].WEBPAGE_URL+"</a></td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].WEBPAGE_REMARK+"</td>"+
									  "<td style='background:rgb(241, 241, 241);'>"+jsondata[i].WEBPAGE_CREATE_TIME+"</td>"+
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
		url: "FavoriteURLAction_favoriteURLAction",
		type: "post",
		dataType : 'json',
		data : {
			fn:"queryURLList",
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

function re(){//刷新
 	window.location.href="<%=webRoot%>favorite/favoriteURL.jsp"
	}
</script>
</html>
