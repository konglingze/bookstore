<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加信息</title>
</head>
<h3>添加用户信息</h3>
<body>
      <form action="UserInsert" method="post" >
			 				请输入添加的用户名：
			 					<input type="text" name="username" ><br>
			 				请输入添加的用户密码：
			 					<input type="text" name="userpassword" ><br>			 				
			 				<input type="submit" value="添加" >
			 				<input type="reset" value="重置" ><br>			     
			     		</form>
  </body>
</html>