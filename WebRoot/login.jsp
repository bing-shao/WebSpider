<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>缃戠粶鐖櫕绯荤粺-鐧诲綍</title>
<%@include file="../taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="images/spider.ico" type="image/x-icon">
<link rel="bookmark" href="images/spider.ico" type="image/x-icon">
<script src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script> 
</head>
<body>
	<form id="login_form">
		<div class="login">
			<div class="login_form">
				
				<div class="form_info">
					<div class="field">
						<label style="color:white">鐢ㄦ埛鍚嶏細</label> <input id="txtuid" name="user.user_name" type="text" class="text" size="20">
					</div>
					<div class="field" >
						<label style="color:white">瀵�&nbsp&nbsp&nbsp鐮侊細</label> <input id="txtpwd" name="user.user_pwd" type="password" class="text" size="20">
					</div>

					<div class="field">
						<label style="color:white">楠岃瘉鐮侊細</label> <input id="txtcode" name="code" type="text"
							class="text" size="10"> <img src="code.jsp" align="absmiddle" style="margin-left:6px" id="yzm" alt="鐐瑰嚮鍒锋柊楠岃瘉鐮�"
							onclick="this.src='code.jsp?id='+Math.random();">
					</div>
					<div class="field">
						<span id="msg" style="margin-left: 55px;color:#00f6ff;"></span>
					</div>
					<div class="field">

						<input class="loginn" style="margin-left: 55px;" type="button" onclick="dosubmit()"></input>
						<input class="register" style="margin-left:5px;" type="button" onclick="register()"></input>
						<select id="sel" name="user.user_sex" style="margin-left: 56px;margin-top:14px;cursor:pointer" onchange="findPwd()">
						<option selected disabled="disabled">蹇樿瀵嗙爜锛�</option>
						<option value="0" >瀵嗕繚鎵惧洖</option>
						<option value="1">閭欢鎵惧洖</option></select>
<!-- 						<label style="margin-left: 60px; color:white; cursor:pointer;" onclick="findPwd()" >蹇樿瀵嗙爜锛�</label> -->
						<div style="margin-top:10px;float: right;height:30px;line-height: 30px;width: 80px;">
							<input id="chsave" type="checkbox" checked="checked" name="chsave" style="margin-left: -60px;margin-top: 8px;">
							<label style="margin-left: -5px; margin-top: -8px; color:white" >璁颁綇鎴�</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	$(document).ready(function(){
		if($.cookie('user_name_cookie')!=null){
			$("#txtuid").val($.cookie('user_name_cookie'));
			$("#txtpwd").val($.cookie('user_pwd_cookie'));
		}
	});
	$(document).keydown(function(){
		var theEvent = window.event; 
		if (theEvent.keyCode == 13) { 
				dosubmit();
		} 
	});
	function dosubmit(){
		if($("#txtuid").val()==""){
			$("#msg").empty(); 
			$("#msg").append("* 璇疯緭鍏ョ敤鎴峰悕锛�");
			return false;
		}
	    if($("#txtpwd").val()==""){
	    	$("#msg").empty(); 
			$("#msg").append("* 璇疯緭鍏ュ瘑鐮侊紒");
			return false;
		}
		if($("#txtcode").val()==""){
			$("#msg").empty(); 
			$("#msg").append("* 璇疯緭鍏ラ獙璇佺爜锛�");
			return false;
		}	
		$.ajax({
        type: "post",
        url : "LoginAction_login",
        dataType : 'json',
        data : $('#login_form').serialize(),
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(json) {
			if (json.data!=""&&json.data!=null) {
				 $("#msg").empty(); 
				 $("#msg").append("* "+json.data);
				 $("#yzm").attr("src",'code.jsp?id='+Math.random());
			} else{
				if($("#chsave").attr("checked")==true){
					$.cookie('user_name_cookie',$("#txtuid").val(), { expires: 7, path: '/' }); 
					$.cookie('user_pwd_cookie',$("#txtpwd").val(), { expires: 7, path: '/' });
				}
				window.location.href="main.jsp";
			}
		}
	});
		
	}
	function register(){
		window.location.href="register.jsp";
	}
	function findPwd(){
		var flag = $("#sel").val();
		if(flag=="0"){
			window.location.href="findPwdQ.jsp";
			}
		if(flag=="1"){
			window.location.href="findPwdE.jsp";
		}
	}
	
</script>
<script type="text/javascript">
	var msg='${msg}';
	if(msg!=''){
		alert(msg);
	}
</script>
</html>

