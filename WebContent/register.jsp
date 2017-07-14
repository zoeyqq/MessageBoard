<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%  
    String path = request.getContextPath();  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<style type="text/css">   
DIV {  
    WIDTH: 200px;  
}  
  
BODY {  
    MARGIN-TOP: 50px;  
    FONT-SIZE: 16px;  
 
}  
</STYLE>   
<script type="text/javascript">  
    function dosubmit() {  
        var th = document.form1;  
        if (th.username.value == "") {  
            alert("用户名不能为空");  
            th.username.focus();  
            return;  
        }  
  
        if (th.realname.value == "") {  
            alert("姓名 不能为空");  
            th.realname.focus();  
            return;  
        }  
  
        if (th.password.value == "") {  
            alert("密码不能为空");  
            th.password.focus();  
            return;  
        }  
        th.action="<%=path%>/servlet/RegisterServlet"  
        th.submit();  
 
    }  
</script> 
</head>
<body>
<div id="container">
  <div class="logo">
     <a href="#"><img alt="" src="images/logo.jpg"></a>  
  </div>
   <div id="box">
      <form action="" name="form1" method="post">  
        <table height=60  width=580 > 
          <tr></tr> 
           <tbody>
              <tr>
                <td width=14%>用户名：</td>
                <td width=24%><input class=text2 maxlength=20 size=18 name="username"></td>
                <td width=62%><span> 必须填写！</span></td>
              </tr>
              <tr>
                <td width=14%>姓名：</td>
                <td width=24%><input class=text2 maxlength=20 size=18 name="realname"></td>
                <td width=62%><span> 必须填写！</span></td>
              </tr>
              <tr>
                <td width=14%>密码：</td>
                <td width=24%><input type="password" class=text2 maxlength=20 size=18 name="password"></td>
                <td width=62%><span> 必须填写！</span></td>
              </tr>
           </tbody> 
           <tr> 
             <TD width=14%></TD> 
             <TD width=24%></TD>
             <TD width=62% height=20 align="center">
             <a  href="javascript:dosubmit();">
             <img src="<%=path%>/images/ok_1.jpg" name="Image8" width="60" height="22" border="0">
             </a>               
             </TD>  
             <TD></TD>  
           </tr>               
        </table>  
    </form> 
   </div> 

</div>
</body>
</html>