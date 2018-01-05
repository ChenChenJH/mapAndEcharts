<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>
</head>
<body>
<input type="button" value="添加文件" /><br/><br/>
<form id="ff" enctype="multipart/form-data" method="post" action="txtReader">
	<input id="file" type="file" name="file"/><br/>
	<input type="submit" value="读取文件" />
	<input type="button" value="插件异步读取" onclick="upload()"/>
	<input type="button" value="使用FormData读取" onclick="formDataSubmit()" />
</form>
<script>
	function upload(){
		if($('#file').val() == ""){
			alert('你没有选中文件!');
			return ;
		}
		  var options = {
             	type: "post",
                 url : "txtReaderAjax",
                 dataType: "text",
                 success : function(data) {
                 	if(data == 'true'){
                     	alert("读取成功!");
                 	}else{
                 		alert("读取失败!");
                 	}
                 }
         }; 
         //jquery-form用插件异步提交
          $('#ff').ajaxSubmit(options);  
	}
	
	function formDataSubmit(){
		var form = document.getElementById('ff');  
		var formdata = new FormData(form);  
		$.ajax({
            type: "POST",
            url:"txtReaderAjax",
            data:formdata,
            async: false, //禁止异步往下执行，默认是true
            contentType : false,  //禁止jQuery设置Content-Type请求头 信息
            processData : false,  //禁止jQuery处理请求的数据
            success: function(data) {
            	if(data == 'true'){
                 	alert("读取成功!");
             	}else{
             		alert("读取失败!");
             	}
            }
        });
	}
</script>
</body>
</html>