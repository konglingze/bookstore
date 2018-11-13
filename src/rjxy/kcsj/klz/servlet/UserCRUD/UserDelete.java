package rjxy.kcsj.klz.servlet.UserCRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.vo.User;

public class UserDelete extends HttpServlet{ 
	
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
		int usernum=Integer.parseInt(request.getParameter("usernum"));

		String username=request.getParameter("username");
		user.setUserNum(usernum);
		user.setUserName(username);
		String path="Success.jsp";
		String path2="False.jsp";
	    /*   PrintWriter out=response.getWriter();
	out.print("<h1 aling='center'>");
	out.print(user.getUserNum());
	out.print("</h1>");
	out.flush();
	out.close();   */ 
		try {
			if (UserDaofactory.getIUserinstance().Delete(user)) {
				response.sendRedirect(path);
			}else {
				response.sendRedirect(path2);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}