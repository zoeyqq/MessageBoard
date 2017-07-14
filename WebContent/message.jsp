<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.Message"%>
<%@ page import="po.Pager"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言信息</title>
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
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>

<script type="text/javascript">
// 当前第几页数据
var currentPage = ${result.currentPage};

// 总页数
var totalPage = ${result.totalPage};

function submitForm(actionUrl){
	var formElement = document.getElementById("messageForm");
	formElement.action = actionUrl;
	formElement.submit();
}

// 第一页
function firstPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context %>/servlet/MessagePageServlet?pageNum=1");
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context %>/servlet/MessagePageServlet?pageNum=" + (currentPage+1));
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context %>/servlet/MessagePageServlet?pageNum=" + (currentPage-1));
		return true;
	}
}

// 尾页
function lastPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context %>/servlet/MessagePageServlet?pageNum=" + (totalPage));
		return true;
	}
}


function dosubmit() {  
    var th = document.myMessage;  
    if (th.message.value == "") {  
        alert("留言不能为空");  
        th.message.focus();  
        return;  
    }  
} 
</script>
<body>
  
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
  
  <div>
	   <form action="servlet/MessagePageServlet" id="messageForm"  method="post">
	      <p>需要查询某个用户的留言？</p>
          <p>用户名： <input type="text" name="username">
           <input type="submit" value="查询"></p>
           
		</form>
		<table class="hovertable">
		   <tr>
            <th colspan="5" align="center">历史留言记录</th>
           </tr>
          <tr>
            <th>留言人</th>
            <th>留言时间</th>
            <th>留言信息</th>
          </tr>
          <%
          Pager<Message> pagerList= null;
          List<Message> list = null;
          if(session.getAttribute("result") != null){
            //得到数据表
            pagerList = (Pager<Message>)session.getAttribute("result");
            list = pagerList.getDataList();
            if(list.size()>0)
            {
            	Message m;
            	for(int i=0;i<list.size();i++)
            	{
            		m = new Message();
            		m = (Message)list.get(i);           		
            		%>           		
            	 <tr>
            	  <td><%=m.getUsername() %></td>
            	  <td><%=m.getIndate() %></td>
            	  <td><%=m.getMessage() %></td>
            	 </tr>
            <% 		
            	}           	
            }
            }
        
        %>
	    </table>
	        <br> 共${result.totalRecord }条记录&nbsp;&nbsp;共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			<a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp; 
			<a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp; 
			<a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
			<a href="#" onclick="lastPage();">尾页</a>	
  </div>
</body>
</html>