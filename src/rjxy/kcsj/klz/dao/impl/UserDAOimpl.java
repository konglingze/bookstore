package rjxy.kcsj.klz.dao.impl;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rjxy.kcsj.klz.dao.IUserDAO;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.vo.User;
public class UserDAOimpl implements IUserDAO{
private Connection conn =null;
private PreparedStatement pstmt =null;
public UserDAOimpl(Connection conn){
	this.conn=conn;
}

public boolean findLogin(User user)throws Exception{
	
	boolean flag =false;
	try{
		String sql="SELECT UserName FROM useraccess WHERE UserName=?AND Password=?";
		this.pstmt =this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getPassword());
		ResultSet re=this.pstmt.executeQuery();
		
		if(re.next()){
			user.setUserName(re.getString(1));
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

@Override
public DatabaseConnection getDatabseConnection() {
	// TODO 自动生成的方法存根
	return null;
}

@Override
public boolean Delete(User user) throws Exception {
	// TODO 自动生成的方法存根
	boolean flag =false;
	int num=user.getUserNum();
	try{

		String sql="delete from useraccess where usernum=?";
		// delete from useraccess where usernum=1 ;
		this.pstmt =this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, num);
		//this.pstmt.setString(2, user.getUserName());
		int a=this.pstmt.executeUpdate();
		this.pstmt.close();
		if(a>0){

			flag =true;
		}
		else{
			flag =false;
		}
	}catch (Exception e) {
		// TODO: handle exception
		throw e;
	}
	return flag ;

}

@Override
public boolean Modify(User user,User user2) throws Exception {
	// TODO 自动生成的方法存根

	boolean flag =false;
	try{
		
		
		String sql="UPDATE useraccess set UserName=? , Password=?  WHERE UserNum=?";
		this.pstmt =this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user2.getUserName());
		this.pstmt.setString(2, user2.getPassword());
		this.pstmt.setInt(3, user.getUserNum());
		int re = this.pstmt.executeUpdate();
		
		if(re>0){
			flag =true;
		} else{
			flag =false;
		}
	}catch (Exception e) {
		// TODO: handle exception
		throw e;
	}
	return flag ;
}

@Override
public boolean Insert(User user) throws Exception {
	// TODO 自动生成的方法存根

	boolean flag =false;
	try{
		String sql="insert into useraccess (UserName,Password) values(?,?)";
		this.pstmt =this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2, user.getPassword());
		boolean re=this.pstmt.execute();
		   this.pstmt.close();
		if(re){
			
			flag =true;
		}
		else{
			flag =false;
		}
	}catch (Exception e) {
		// TODO: handle exception
		throw e;
	}
	return flag ;
}

@Override
public User Find(User user) throws Exception {
	// TODO 自动生成的方法存根
	
	try{
		String sql="SELECT * FROM useraccess WHERE UserNum=?";
		this.pstmt =this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, user.getUserNum());
		//this.pstmt.setString(2, user.getPassword());
		ResultSet re=this.pstmt.executeQuery();
		
		if(re.next()){			
			user.setUserNum(re.getInt(1));
			user.setUserName(re.getString(2));
            user.setPassword(re.getString(3));
            
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
return user;
}

public List<User> findAll() throws Exception {
	// TODO 自动生成的方法存根
	List< User> blist=new ArrayList< User>();
	 
	String sql="select * from useraccess";
	this.pstmt =this.conn.prepareStatement(sql);
	ResultSet re=this.pstmt.executeQuery();
	while (re.next()) {
		User user=new User();
		user.setUserNum(re.getInt(1));
		user.setUserName(re.getString(2));
		user.setPassword(re.getString(3));
		blist.add(user);		
	}

	re.close();
	this.pstmt .close();
	return blist;
}
}
