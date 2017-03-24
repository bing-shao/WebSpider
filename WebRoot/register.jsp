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
<title>用户注册</title>
<%@include file="../taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="images/spider.ico" type="image/x-icon">
<link rel="bookmark" href="images/spider.ico" type="image/x-icon">
<script type="text/javascript" src="js/Calendar3.js"></script>
<script src="js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<form id="register_form">
		<div class="register1">
			<div class="register_form">
				<div class="register1_info">
					<div class="field">
						<label><font color="#00f6ff">*</font><font color="white">用户名：</font></label> <input id="txtuid" name="user.user_name" type="text" style="margin-right: 2%;margin-left: 2%" class="text" size="20"><font id="uid" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label><font color="#00f6ff">*</font><font color="white">密&nbsp&nbsp&nbsp码：</font></label> <input id="txtpwd" name="user.user_pwd" type="password" style="margin-right: 2%;margin-left: 2%" class="text" size="20"><font id="pwd" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label><font color="#00f6ff">*</font><font color="white">重复密码：</font></font></label> <input id="txtrpwd" name="user_repwd" type="password" style="margin-right: 2%" class="text" size="20"><font id="rpwd" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label ><font color="#00f6ff">*</font><font color="white">密保问题：</font></label> <input id="txtrequsetion" name="user.user_qustion" style="margin-right: 2%" type="text" class="text" size="20"><font id="qusetion" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label ><font color="#00f6ff">*</font><font color="white">密保答案：</font></label> <input id="txtanswer" name="user.user_answer" style="margin-right: 2%" type="text" class="text" size="20"><font id="answer" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label ><font color="#00f6ff">*</font><font color="white">邮&nbsp&nbsp&nbsp箱：</font></label> <input id="txtemail" name="user.user_email" type="text" style="margin-right: 2%;margin-left: 2.5%" class="text" size="20"><font id="email" color="#00f6ff"></font>
					</div>	
					<div class="field" >
						<span style="margin-left: 3%"><font color="white">性&nbsp&nbsp&nbsp别：</font></span><select name="user.user_sex" style="margin-left: 3.5%"><option value="0" selected>男</option><option value="1">女</option></select>
					</div>
					<div class="field" >
						<label style="margin-left: 1.5%"> <font color="white">地&nbsp&nbsp&nbsp址：</font></label> <input id="txtadr" name="user.user_adr" type="text" style="margin-right: 2%;margin-left: 2.5%" class="text" size="20">
					</div>
					<div class="field" >
						<label style="margin-left: 1%" > <font color="white">出生日期：</font></label> <input id="txtbirth" name="user.user_birth" type="text" style="margin-right: 2%;margin-left: 0.5%" class="text" size="20" onfocus="new Calendar().show(this)" readonly>
					</div>
					<div class="field" >
						<label style="margin-left: 1.5%"> <font color="white">电&nbsp&nbsp&nbsp话：</font></label> <input id="txtphone" name="user.user_phone" type="text"  style="margin-right: 2%;margin-left: 2.5%" class="text" size="20"><font id="phone" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label style="margin-left: 1.5%"> <font color="white">备&nbsp&nbsp&nbsp注：</font></label> 
						<textarea id="txtremark" name="user.user_remark"  class="textarea" style="resize: none;height: 160px;width: 400px;margin-left: 1.5%"></textarea>
					</div>
					<div class="field">
						<button class="register_ensure" style="margin-left: 10%;" type="button" onclick="save()"></button>
						<button class="register_quit" style="margin-left:30%;" type="button" onclick="quit()"></button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	//校验
	$("#txtuid").blur(function(){
		if($("#txtuid").val()==""){
			$("#uid").html("*用户名不能为空");
		}else{
			var userName = $("#txtuid").val();
			$.ajax({
	        type: "post",
	        url : "LoginAction_checkUser",
	        dataType : 'json',
	        data : {userName:userName},
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(json) {
				$("#uid").html(json.data);
			}
		});
		}
	});
	$("#txtpwd").blur(function(){
		if($("#txtpwd").val()==""){
			$("#pwd").html("*密码不能为空");
		}else{
			$("#pwd").empty();
		}
	});
	$("#txtrpwd").blur(function(){
		if($("#txtrpwd").val()==""){
			$("#rpwd").html("*重复密码不能为空");
		}else if($("#txtrpwd").val()!=$("#txtpwd").val()){
			$("#rpwd").html("*两次密码不匹配");
		}else{
			$("#rpwd").empty();
		}
	});
	$("#txtrequsetion").blur(function(){
		if($("#txtrequsetion").val()==""){
			$("#qusetion").html("*密保问题不能为空");
		}else{
			$("#qusetion").empty();
		}
	});
	$("#txtanswer").blur(function(){
		if($("#txtanswer").val()==""){
			$("#answer").html("*密保答案不能为空");
		}else{
			$("#answer").empty();
		}
	});
	$("#txtemail").blur(function(){
		if($("#txtemail").val()==""){
			$("#email").html("*邮箱不能为空");
		}else if(!(/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/.test($("#txtemail").val()))){
			$("#email").html("*请填写正确的邮箱地址");
		}else{
			$("#email").empty();
		}
	});
	$("#txtphone").blur(function(){
		if($("#txtphone").val()==""){
		}else if(!(/^[1][358][0-9]{9}$/.test($("#txtphone").val()))){
			$("#phone").html("*请输入正确的手机号");
		}else{
			$("#phone").empty();
		}
	});
	function save(){
		//提交校验
		if($("#uid").html()==""&&$("#pwd").html()==""&&$("#rpwd").html()==""&&$("#qusetion").html()==""&&
		   $("#answer").html()==""&&$("#email").html()==""&&$("#phone").html()==""&&$("#txtuid").val()!=""
		   &&$("#txtpwd").val()!=""&&$("#txtrpwd").val()!=""&&$("#txtrequsetion").val()!=""&&$("#txtanswer").val()!=""&&
		   $("#txtemail").val()!=""){
		   	 $.ajax({
			        type: "post",
			        url : "LoginAction_register",
			        dataType : 'json',
			        data :$('#register_form').serialize(),
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					success : function(json) {
						alert("注册成功");
						window.location.href="login.jsp";
					}
				});
		   }
	}
	function quit(){
		window.location.href="login.jsp";
	}
</script>
</html>

