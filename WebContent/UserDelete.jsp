<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户信息</title>
</head>
<h3>删除用户信息</h3>
<body>
      <form action="UserDelete" method="post" >
			 				请输入需要删除的用户的编号：
			 					<input type="text" name="usernum" ><br>
			 				请输入需要删除的用户名：
			 					<input type="text" name="username" ><br>		 				
			 				<input type="submit" value="提交" >
			 				<input type="reset" value="重置" ><br>			     
			     		</form>
  </body>
</html>