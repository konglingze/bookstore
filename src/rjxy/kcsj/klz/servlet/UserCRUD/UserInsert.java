package rjxy.kcsj.klz.servlet.UserCRUD;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.vo.User;

public class UserInsert extends HttpServlet{ 
	
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
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpassword");
		 /*       PrintWriter out=response.getWriter();
				out.print("<h1 aling='center'>");
				out.print(username+userpassword);
				out.print("</h1>");
				out.flush();
				out.close();   */ 
		user.setUserName(username);
		user.setPassword(userpassword);
	
		try {
			if (UserDaofactory.getIUserinstance().Insert(user)) {
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
