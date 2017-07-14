<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%  
    String path = request.getContextPath();  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
</head>
<body>
   <p>注册成功！<span id="time">5</span>秒后<a href="Login.jsp">返回登录界面</a></p>
   <script type="text/javascript">
        var num = document.getElementById("time").innerHTML
        var i = setInterval("clock()", 1000);
        function clock()
        {
        	if(num > 1)
        	{
        		document.getElementById('time').innerHTML = --num;
        	}else
        	{
        		location.assign('login.jsp');
        	}
        }
    </script>
</body>
</html>