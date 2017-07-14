<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆界面</title>
<style type="text/css">
.container{
    width:400px;
    height:200px;
    position:fixed;
    left:100px;
    top:50px;
}
.space{
  right:10px;
}
p{
font-size:16px;
line-height:1.6em;
}
h6{color:red;}
</style>
<script type="text/javascript">
 function reloadCode(){
	  var time = new Date().getTime();
	  document.getElementById("imagecode").src="<%=request.getContextPath()%>/servlet/ImageServlet?d="+time;	  
  }
</script>
</head>
<body>
<div id="container">
  <div class="logo">
     <a href="#"><img alt="" src="images/logo.jpg"></a>  
  </div>
  <div id="main">
   <form action="servlet/LoginServlet" method="post" >
         <p class="main">
				<label>用户名: </label>
				<input name="username" value="" />
				<label>密码: </label>
				<input type="password" name="password" value="">	
	     </p>
	     <p>
	                                     验证码：<input type="text" name="checkcode"/>
                <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
                <a href="javascript:reloadCode();">看不清楚</a>
	     </p>
	     <p>
	            <input type="submit" value="登陆">
	     </p>
   </form>
  </div>
  <div id="reg">
     <p>还没有账号？<a href="register.jsp">请点击注册</a></p>
  </div>
	     <% 
	        String showMessage = "";
	        if(session.getAttribute("showMessage")!=null)
	        {
		       showMessage = session.getAttribute("showMessage").toString();
		       session.setAttribute("showMessage",null);
	        }
          %>
	     <h6><%=showMessage %></h6>
</div>
</body>
</html>