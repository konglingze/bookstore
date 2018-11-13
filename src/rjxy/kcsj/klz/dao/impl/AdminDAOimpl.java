package rjxy.kcsj.klz.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import rjxy.kcsj.klz.dao.IAdminDAO;
import rjxy.kcsj.klz.vo.Admin;
public class AdminDAOimpl implements IAdminDAO{
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	public AdminDAOimpl(Connection conn){
		this.conn=conn;

	}
	public boolean findLogin(Admin admin)throws Exception{
		
		boolean flag =false;
		try{
			String sql="SELECT AdminName FROM adminaccess WHERE AdminName=?AND Password=?";
			this.pstmt =this.conn.prepareStatement(sql);
			this.pstmt.setString(1, admin.getAdminName());
			this.pstmt.setString(2, admin.getPassword());
			ResultSet re=this.pstmt.executeQuery();
			if(re.next()){
				admin.setAdminName(re.getString(1));
				flag =true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(this.pstmt!=null){
				try{
					this.pstmt.close();
				}catch (Exception e) {
					// TODO: handle exception
					throw e;
				}
			}
			
		}
		return flag ;
	  }
	}
