package rjxy.kcsj.klz.servlet.exit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Exit extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
	   String type=req.getParameter("type");
	   //退出系统
	   if("exit".equals(type)){
           HttpSession session = req.getSession(false);
           String sessionUser = (String) session.getAttribute("user");
           if(sessionUser!=null){
               session.removeAttribute("user");
               System.out.println("退出成功！");
           }else{
               System.out.println("退出失败，用户已经退出登录！");
           }
           try {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
       }
   }
   
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	   this.doPost(req,resp);
	}
}
