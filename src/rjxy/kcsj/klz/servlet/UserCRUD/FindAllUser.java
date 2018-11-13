package rjxy.kcsj.klz.servlet.UserCRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rjxy.kcsj.klz.factory.AdminDaofactory;
import rjxy.kcsj.klz.factory.UserDaofactory;
import  rjxy.kcsj.klz.vo.User;
public class FindAllUser extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
		      List<User> userlist=new ArrayList< User>() ;
		      String path="FindAllUser.jsp";
			userlist=UserDaofactory.getIUserinstance().findAll();
			request.setAttribute("userlist", userlist);
			/*     PrintWriter out=response.getWriter();
			out.print("<h1 aling='center'>");
			out.print(userlist);
			out.print("</h1>");
			out.flush();
			out.close();    */
			//response.sendRedirect(arg0);
			 request.getRequestDispatcher(path).forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		       doPost(request,response);
	}
	
	
	
	}

