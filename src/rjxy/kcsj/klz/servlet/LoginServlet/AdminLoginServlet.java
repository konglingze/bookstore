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
import javax.servlet.http.HttpSession;

import rjxy.kcsj.klz.factory.AdminDaofactory;
import rjxy.kcsj.klz.vo.Admin;
/**
 * Servlet implementation class LoginServlet
 */


public class AdminLoginServlet  extends HttpServlet {

       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String path="AdminLogin.jsp";
        String path2="Admin.jsp";
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String adminname=req.getParameter("adminname");
        String adminpass=req.getParameter("adminpassword");
        
       
/*	try {
		
    	admin.setAdminName(adminname);
    	admin.setPassword(adminpass);
        PrintWriter out=resp.getWriter();
        boolean a = AdminDaofactory.getIAdmininstance().findLogin(admin);
		out.print("<h1 aling='center'>");
		out.print(a);
	out.print("</h1>");
		out.flush();
		out.close();    
	} catch (Exception e1) {
		// TODO �Զ����ɵ� catch ��
		e1.printStackTrace();
	}
		*/
        
        List<String> info=new ArrayList<String>();
       // List<String> type=new ArrayList<String>();
        if(adminname==null||"".equals(adminname)){
        	info.add("�û�������Ϊ��!");
        	
        }
        if(adminpass==null||"".equals(adminpass)){
        	info.add("���벻��Ϊ��!");
        	
        }
        if(info.size()==0){
        	Admin admin=new Admin();
        	admin.setAdminName(adminname);
        	admin.setPassword(adminpass);
        	try{
        		if(AdminDaofactory.getIAdmininstance().findLogin(admin)){
        			info.add("����Ա��½�ɹ�����ӭ"+admin.getAdminName()+"����");
        	    //		type.add("true");
        		//	req.setAttribute("type", type); 
        			HttpSession session = req.getSession();
                    session.setAttribute("Adminnsme", adminname);
                    req.setAttribute("info", info);
        			req.getRequestDispatcher(path2).forward(req, resp);
        			
        		}else{
        			info.add("����Ա��½ʧ�ܣ��û������������");
        		       req.setAttribute("info", info);
        	        req.getRequestDispatcher(path).forward(req, resp);
        		}
        		
        	}catch (Exception e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
        }
 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

