<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page import="rjxy.kcsj.klz.vo.User"%> 
<%@ page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body>
<h3 align="center">查询结果</h3>

<table>
<%

List <User> userlist= new ArrayList <User>();
 userlist =(List<User>) request.getAttribute("userlist");
 %>
       <%-- =userlist  --%>
       <% 
 if(userlist!=null){
	 Iterator <User> iter=userlist.iterator();
	 while(iter.hasNext()){
		   User user =new User();
		 user=iter.next();
	 
		 %>	 
		 
		 <tr><td>用户编号:</td><td><%=user.getUserNum()  %></td></tr>		 
		 <tr><td>用户名:</td><td><%=user.getUserName() %></td></tr>
		 <tr><td>用户密码:</td><td><%=user.getPassword() %></td></tr>
		 <%
	 }
 }
		 %>

    </table>
  </body>
</html>