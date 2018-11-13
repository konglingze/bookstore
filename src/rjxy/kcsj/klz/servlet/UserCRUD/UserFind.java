package rjxy.kcsj.klz.servlet.UserCRUD;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.vo.User;

public class UserFind extends HttpServlet{ 
	
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
		 /*       PrintWriter out=response.getWriter();
				out.print("<h1 aling='center'>");
				out.print(username+userpassword);
				out.print("</h1>");
				out.flush();
				out.close();   */ 
		user.setUserNum(usernum);
		String path="Success.jsp";
		String path2="Success2.jsp";
		//List<User> all=null;
		
		try {
			user=UserDaofactory.getIUserinstance().Find(user);
			 //request.setAttribute("all", all);
			 //Iterator<User> iter=all.iterator();
		     //while(iter.hasNext()){
		    	 // User e=iter.next();
			request.setAttribute("user", user);
			request.getRequestDispatcher(path2).forward(request, response);
			   // System.out.print(user.getUserNum());
		       //  System.out.print(user.getUserName());
		       // System.out.print(user.getPassword());
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HttpSession session=request.getSession();
		//session.setAttribute("all", all);
	}
}