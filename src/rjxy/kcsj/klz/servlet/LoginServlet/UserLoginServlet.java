package rjxy.kcsj.klz.servlet.LoginServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.vo.User;
/**
 * Servlet implementation class LoginServlet
 */

public class UserLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String path="UserLogin.jsp";
        String userpath="Userinfo.jsp";
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
      String username=req.getParameter("username");
        String userpass=req.getParameter("userpassword");
      /*      PrintWriter out=resp.getWriter();
		out.print("<h1 aling='center'>");
		out.print(username+userpass);
		out.print("</h1>");
		out.flush();
		out.close();    */
        List<String> info=new ArrayList<String>();
        if(username==null||"".equals(username)){
        	info.add("用户名不能为空!");
        	
        }
        if(userpass==null||"".equals(userpass)){
        	info.add("密码不能为空!");
        	
        }
        if(info.size()==0){
        	User user=new User();
        	user.setUserName(username);
        	user.setPassword(userpass);
       /* 	try {
				boolean a= UserDaofactory.getIUserinstance().findLogin(user);
				 	    PrintWriter out=resp.getWriter();
		    		out.print("<h1 aling='center'>");
		    		out.print(a);
		    		out.print("</h1>");
		    		out.flush();
		    		out.close();   
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
        
        	*/

        	try{
        		if(UserDaofactory.getIUserinstance().findLogin(user)){
        		//	PrintWriter out=resp.getWriter();
        		//	out.print("<h1 aling='center'>");
        		//	out.print(" 欢迎  "+user.getUserName()+" , "+"注册登陆成功!");
        		//	out.print("</h1>");
        		//	out.flush();
        		//	out.close();
        			info.add("用户登陆成功，欢迎"+user.getUserName()+"光临");
        			
        
        		}else{
        			info.add("用户登陆失败，用户名或密码错误！");
        		}
        		
        	}catch (Exception e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
        }
        req.setAttribute("info", info);
        req.getRequestDispatcher(path).forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
