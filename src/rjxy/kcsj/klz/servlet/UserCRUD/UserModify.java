package rjxy.kcsj.klz.servlet.UserCRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.vo.User;

public class UserModify extends HttpServlet{ 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		User user=new User();
		User user2=new User();
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		int usernum=Integer.parseInt(request.getParameter("usernum"));
		String username2=request.getParameter("username2");
		String userpassword2=request.getParameter("userpassword2");
		 
		user.setUserName(username);
		user.setPassword(userpassword);
		user.setUserNum(usernum);
		user2.setUserName(username2);
		user2.setPassword(userpassword2);
		     //  PrintWriter out=response.getWriter();
		//out.print("<h1 aling='center'>");
		//out.print(user.getUserNum()+user2.getUserName()+user2.getPassword());
		//out.print("</h1>");
		//out.flush();
		//out.close();  
		String path="Success.jsp";
		try {
			if (UserDaofactory.getIUserinstance().Modify(user,user2)) {
				response.sendRedirect("Success.jsp");
			}else {
				response.sendRedirect("False.jsp");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}