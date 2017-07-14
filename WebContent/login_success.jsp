<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="po.Message"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言版</title>
<style type="text/css">
span{
color:blue;
font-size 12px;
}
h1{text-align:center;color:blue;}
h5{text-align:right;color:blue;}

 table.hovertable {
            font-family: verdana, arial, sans-serif;
            font-size: 13px;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
        }
         
        table.hovertable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
         
         
        table.hovertable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }

</style>

<script type="text/javascript">  
    function dosubmit() {  
        var th = document.myMessage;  
        if (th.message.value == "") {  
            alert("留言不能为空");  
            th.message.focus();  
            return;  
        }  
    }  
</script> 

</head>
<body>
 <div id="message">
  <div class="top">
   <h5><a href="login.jsp">退出登陆</a></h5> 
  <h1>留言板</h1>
  <hr>
  </div>
  <div id="message">
   <% 
	String loginUser = "";
	if(session.getAttribute("loginUser")!=null)
	{
		loginUser = session.getAttribute("loginUser").toString();
	}
  %>
          欢迎您<font color="red">${loginUser}</font>！
          <!--  %>欢迎您<font color="red"><%=loginUser%></font>！  -->
    <form action="servlet/MessageServlet"  name = "myMessage" method="post" >    
     <textarea name="message" cols="80" rows="10"></textarea>
     <input type="submit" value="提交"  name="submit" onclick="dosubmit()"/>
     <input type="reset" value="重置"  name="reset" />
   </form>
  </div>
  <hr>
  <div id="report">
    <br>
     <form action="servlet/MessageListServlet" method="post">
       <input type="submit" value="刷新留言"/><br>
     </form>
     <table class="hovertable">
       <tr>
         <th colspan="5" align="center">历史留言记录</th>
       </tr>
       <tr>
            <th>留言人</th>
            <th>留言时间</th>
            <th>留言信息</th>
            <th>删除</th>
        </tr>
        <%
          List<Message> list = null;
          
          if(session.getAttribute("REPORT") != null){
            //得到数据表
            list = (List<Message>)session.getAttribute("REPORT");
            if(list.size()>0)
            {
            	Message m;
            	for(int i=list.size()-1;i>=0;i--)
            	{
            		m = new Message();
            		m = (Message)list.get(i);            		
            		%>            		
            	 <tr>
            	  <td><%=m.getUsername() %></td>
            	  <td><%=m.getIndate() %></td>
            	  <td><%=m.getMessage() %></td>
            	  <td><a href="javascript:doRemove();">删除</a></td>
            	 </tr>
            <% 		
            	}           	
            }
            }
        
        %>
     </table>
  </div>
 </div>
</body>
</html>