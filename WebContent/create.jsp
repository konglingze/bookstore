<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>用户注册界面</title>
</head>
<body>
	<form action="UserCreate" method="post">
	<table>
	
<tr>	<td align="right">	用&nbsp户&nbsp姓&nbsp名：<input type="text" name="userid"><br></td></tr>
<tr>	<td align="right">	用&nbsp户&nbsp密&nbsp码：<input type="password" name="userpwd"><br></td></tr>
<tr>	<td align="right">	确&nbsp认&nbsp密&nbsp码：<input type="password" name="userpwd"><br></td></tr>
<tr>	<td align="right">	联&nbsp系&nbsp电&nbsp话:<input type="text" name="tel"><br></td></tr>
<tr>	<td align="right">	地&nbsp址:<input type="text" name="address"><br></td></tr>
<tr>	<td align="right">	Q&nbspQ&nbsp:<input type="text" name="QQ"><br></td></tr>
<tr>	<td align="right">	密&nbsp码&nbsp找&nbsp回&nbsp问&nbsp题:<input type="text" name="question"><br></td></tr>
<tr>	<td align="right">	答&nbsp案:<input type="text" name="answer"><br></td></tr>
		
<tr>	 <td align="right">	<input type="submit" value="注册"></td>
	     <td align="right">	<input type="reset" value="重置"></td>
	     </tr>
		</table>
	</form>
</body>

</html>