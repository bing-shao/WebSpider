<%@page contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>网络爬虫系统</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="images/spider.ico" type="image/x-icon">
<link rel="bookmark" href="images/spider.ico" type="image/x-icon">

<style type="text/css">
body {
	font-size: 20px;
}

div {
	width: 250px;
	height: 250px;
	border: 1px solid black;
}
#div1{
position: relative;
top:100px;

}
#div2 {
	position: relative;
	top: -250px;
	left: 500px;
}

#testbtn {
	position: relative;
	top: -600px;
	left:-150px;
}

#p1 {
	position: relative;
	top: 20px;
}
#p2{
position: relative;
top:-250px;
left: 500px;
}
</style>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#testbtn").click(function() {
			var servlet = $("#servlet").val();
			var json = $("#json").val();
			var str = eval('(' + json + ')');
			$.ajax({
				url : "http://localhost:8080/SMS/" + servlet,
				Type : "post",
				data : str,
				dataType : "json",
				success : function(result) {
			      $("#div2").val(JSON.stringify(result, null, "\t"));
				}
			})
		});
	});
</script>
</head>
<body>
		<div id="div1" align="center">
			<p id="p1">
				Servlet:<input id="servlet" /><br>
				<br>
				<br>
			</p>
			Json参数:
			<textarea id="json" style="width: 200px;height: 80px"></textarea>
		</div>
		<p id="p2">返回参数：</p><textarea id="div2" style="width: 500px;height: 500px"></textarea>
		<input type="button" id="testbtn" value="测试" />
</body>
</html>
