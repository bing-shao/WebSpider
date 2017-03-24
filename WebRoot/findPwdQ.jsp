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
<title>密码找回-密保问题找回</title>
<%@include file="../taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="images/spider.ico" type="image/x-icon">
<link rel="bookmark" href="images/spider.ico" type="image/x-icon">
<script type="text/javascript" src="js/Calendar3.js"></script>
<script src="js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<form id="register_form">
		<div class="Register">
			<div class="register_form">
				<div class="register_info">
					<div class="field">
						<label><font color="#00f6ff">*</font><font color="white">用户名：</font></label> <input id="txtuid" name="user.user_name" type="text" style="margin-right: 2%;margin-left: 1%" class="text" size="20"><font id="uid" color="#00f6ff"></font>
					</div>
					<div class="field" >
						<label><font color="#00f6ff">*</font><font color="white">密&nbsp&nbsp&nbsp码：</font></label> <input id="txtpwd" name="user.user_pwd" type="password"  disabled="true" style="margin-right: 2%;margin-left: 1%" class="text" size="20"><font id="pwd" color="#00f6ff">*当前不可编辑</font>
					</div>
					<div class="field" >
						<label><font color="#00f6ff">*</font><font color="white">重复密码：</font></label> <input id="txtrpwd" name="user_repwd" type="password"  disabled="true" style="margin-right: 2%" class="text" size="20"><font id="rpwd" color="#00f6ff">*当前不可编辑</font>
					</div>
					<div class="field" >
						<label ><font color="#00f6ff">*</font><font color="white">密保问题：</font></label> <input id="txtrequsetion" name="user.user_qustion" disabled="true" style="margin-right: 2%" type="text" class="text" size="20"><font id="qusetion" color="#00f6ff">*当前不可编辑</font>
					</div>
					<div class="field" >
						<label ><font color="#00f6ff">*</font><font color="white">密保答案：</font></label> <input id="txtanswer" name="user.user_answer" disabled="true" style="margin-right: 2%" type="text" class="text" size="20"><font id="answer" color="#00f6ff">*当前不可编辑</font>
					</div>
					<div class="field">
						<button class="register_ensure" style="margin-left: 1%;" type="button" onclick="save()"></button>
						<button class="register_quit" style="margin-left:4%;" type="button" onclick="quit()"></button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	//校验
	var aswer="";
	var unid ="";
	$("#txtuid").blur(function(){
		if($("#txtuid").val()==""){
			$("#uid").html("*用户名不能为空");
		}else{
			var userName = $("#txtuid").val();
			$.ajax({
	        type: "post",
	        url : "LoginAction_getUserByName",
	        dataType : 'json',
	        data : {userName:userName},
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			success : function(json) {
				if(json.data[0]==null){
					$("#uid").html("*用户名不存在");
				}else{
					var question = json.data[0].user_question;
					var trueanswer = json.data[0].user_answer;
					$("#txtrequsetion").val(question);
					$("#uid").empty();
					$("#qusetion").empty();
					$("#answer").empty();
					$("#txtanswer").attr("disabled",false);
					answer = trueanswer;
					unid = json.data[0].user_unid;
				}
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
	$("#txtanswer").blur(function(){
		if($("#txtanswer").val()==""){
			$("#answer").html("*密保答案不能为空");
		}else{
			$("#answer").empty();
			if($("#txtanswer").val()==answer){
				$("#pwd").html("*密码不能为空");
				$("#rpwd").html("*重复密码不能为空");
				$("#txtpwd").attr("disabled",false);
				$("#txtrpwd").attr("disabled",false);
				$("#txtuid").attr("disabled",true);
				$("#txtanswer").attr("disabled",true);
			}
		}
	});
	function save(){
		//提交校验
		if($("#uid").html()==""&&$("#pwd").html()==""&&$("#rpwd").html()==""&&$("#qusetion").html()==""&&
		   $("#answer").html()==""&&$("#txtuid").val()!=""
		   &&$("#txtpwd").val()!=""&&$("#txtrpwd").val()!=""&&$("#txtrequsetion").val()!=""&&$("#txtanswer").val()!=""){
		   	 $.ajax({
			        type: "post",
			        url : "LoginAction_updateUser?user.user_unid="+unid,
			        dataType : 'json',
			        data :$('#register_form').serialize(),
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					success : function(json) {
						alert("密码修改成功");
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

