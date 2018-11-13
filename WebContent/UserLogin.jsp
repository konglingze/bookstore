<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<script type="text/javascript">

function validate(f) {
	if(!(/^\w{5,15}$/.test(f.username.value))){
		alert("用户名必须为5-15位!");
		f.username.focus();
		return false ;
	}
	if(!(/^\w{5,15}$/.test(f.userpassword.value))){
		alert("密码必须为5-15位!");
		f.userpassword.focus();
		return false ;
	}
	return true;
}
</script>
<body>
<h2>用户登录界面</h2>

<% 
     request.setCharacterEncoding("UTF-8");
%>

<%
    List<String> info=(List<String>)request.getAttribute("info");//取得属性
    if(info!=null){
    	Iterator<String>iter=info.iterator();
    	while(iter.hasNext()){
    		
 %>  		
    	<h4><%=iter.next() %>></h4>
 <% 
    }
  }
%>
<form action="UserLogin" method="post" onsubmit="returm validate(this)">
用户名:<input type="text" name="username"><br>
密&nbsp;&nbsp;码:<input type="password" name="userpassword"><br>
<input type="submit" value="登陆">
<input type="reset" value="重置">
 </form>
 </body>
</html>