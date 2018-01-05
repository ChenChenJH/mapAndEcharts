<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.net.*"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%  
    String name="";  
    String pwd="";  
    String checked="";  
    Cookie[] cookies=request.getCookies();  
    if(cookies!=null&&cookies.length>0){   
        //遍历Cookie  
        for(int i=0;i<cookies.length;i++){  
            Cookie cookie=cookies[i];  
            //此处类似与Map有name和value两个字段,name相等才赋值,并处理编码问题   
            if("name".equals(cookie.getName())){  
                name=URLDecoder.decode(cookie.getValue(),"utf-8");  
                //将"记住我"设置为勾选   
                checked="checked";  
            }  
            if("pwd".equals(cookie.getName())){  
                pwd=cookie.getValue();  
            }  
        }  
    }  
 %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
   <p>用户名：<input name="name" type="text" value="<%=name%>" id="name"/></p>
    <p>密码:<input name="password" type="password" value="<%=pwd%>" id="password"></p>
   <p>记住我 <input name="rememberMe" type="checkbox" id="rememberMe" class="checkbox" <%=checked%>></p>
   <input type="submit" value="登录" />
</form>
</body>
</html>