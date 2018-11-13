package rjxy.kcsj.klz.servlet.Create;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rjxy.kcsj.klz.factory.UserDaofactory;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.factory.DatabaseConnectionFactory;
public class UserCreate extends HttpServlet {
	
	private Connection conn= UserDaofactory.getIUserinstance().getDatabseConnection().getConnection();

  //this.conn=UserDaofactory.getIUserinstance().getDatabseConnection().getConnection();
	public void init() throws ServletException{		
			try{			
				
	//this.conn=DatabaseConnectionFactory.getDatabaseConnection().getConnection();
	//DatabaseConnectionFactory.getDatabaseConnection().DatabaseConnection()
				
	   if(this.conn!=null){
		   System.out.println("���ݿ����ӳɹ�");
		   
	   }else{
		   System.out.println("���ݿ�����ʧ��");
	   }
			}	
			catch(Exception e){				
				e.printStackTrace();					
			}		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String path="create.jsp";
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username=req.getParameter("userid");
        String userpwd=req.getParameter("userpwd");
        String address=req.getParameter("address");
        String question=req.getParameter("question");
        String answer=req.getParameter("answer");
        String QQ=req.getParameter("QQ");
        List<String> info=new ArrayList<String>();
        if(username==null||"".equals(username)){
        	info.add("�û�������Ϊ��!");
        }
        if(userpwd==null||"".equals(userpwd)){
        	info.add("���벻��Ϊ��!");
      }       
        if(conn!=null){    	
        	try{
        		String sql ="INSERT INTO useraccess(UserName,Password,address,question,answer,QQ) VALUES(?,?,?,?,?,?)";
        		sql = "insert into useraccess values(null, ?, ?, null, ?, ?, ?, ?)";
        		//sql = "INSERT INTO useraccess(UserName,Password,address,question,answer,QQ) VALUES ('"+username+"','"+userpwd+"','"+address+"','"+question+"','"+answer+"','"+QQ+"')";
        		PreparedStatement ps =this.conn.prepareStatement(sql);
        		//System.out.println(username + " - " + userpwd + " - " + address + " - " + question + " - " + answer + " - " + QQ);
        		ps.setString(1, username);
        		ps.setString(2, userpwd);
        		ps.setString(3, address);
        		ps.setString(4, question);
        		ps.setString(5, answer);
        		ps.setString(6, QQ);
        		ps.executeUpdate();
        		PrintWriter out=resp.getWriter();
        		out.print("<h1 aling='center'>");
        		out.print(" ��ӭ  "+username+" , "+"ע��ɹ�!");
        		out.print("</h1>");
        		out.flush();
        		out.close();
        		}
        	catch(Exception e){
        		e.printStackTrace();
        		
        	}
        }else{
         resp.sendError(500,"���ݿ����Ӵ��� ,(-_-)?");        	
        }
        
    /*    if(info.size()==0){11
        	Admin admin=new Admin();
        	admin.setAdminName(adminname);
        	admin.setPassword(adminpass);
        	try{
        		if(AdminDaofactory.getIAdmininstance().findLogin(admin)){
        			info.add("����Ա��½�ɹ�����ӭ"+admin.getAdminName()+"����");
        		}else{
        			info.add("����Ա��½ʧ�ܣ��û������������");
        		}

        	}catch (Exception e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
        }
        req.setAttribute("info", info);
        req.getRequestDispatcher(path).forward(req, resp);
        */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}