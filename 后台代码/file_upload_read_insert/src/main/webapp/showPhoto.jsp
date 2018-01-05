<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showPhoto</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<input type="file" id="uploadId" name="sourceFile" />
	<img id="imageview" width="300px" height="300px" />
	<script type="text/javascript">
		$(function() {
			$("#uploadId").change(function() {
				var $file = $(this);
				var objUrl = $file[0].files[0];
				//获得一个http格式的url路径:mozilla(firefox)||webkit or chrome  
				var windowURL = window.URL || window.webkitURL;
				//createObjectURL创建一个指向该参数对象(图片)的URL  
				var dataURL = windowURL.createObjectURL(objUrl);
				$("#imageview").attr("src", dataURL);
			});
		});
	</script>
</body>
</html>