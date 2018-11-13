package rjxy.kcsj.klz.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import rjxy.kcsj.klz.dao.IUserDAO;
import rjxy.kcsj.klz.dao.impl.UserDAOimpl;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.factory.DatabaseConnectionFactory;
import rjxy.kcsj.klz.vo.User;

public class UserDaoProxy implements IUserDAO{

	private DatabaseConnection dbc=null;
	private IUserDAO dao =null;
	public DatabaseConnection getDatabseConnection(){
		return dbc;
	}
	public  UserDaoProxy(){
	try {	
		this.dbc=DatabaseConnectionFactory.getDatabaseConnection();
		this.dao=new UserDAOimpl(this.dbc.getConnection());
	}catch (Exception e){
		e.printStackTrace();
	}
	     getDatabseConnection();
}
	
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.findLogin(user);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
			
		return flag;
	}
	@Override
	public boolean Delete(User user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		try{
			flag=this.dao.Delete( user);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	public boolean Modify(User user, User user2) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		try{
			flag=this.dao.Modify(user,user2);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public boolean Insert(User user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		try{
			this.dao.Insert( user);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	@Override
	public User Find(User user) throws Exception {
		// TODO 自动生成的方法存根
		//List< User> abc=new ArrayList< User>();
		//List <User> abc=new List <User>;
		User abc =new User();
		try{
			
			abc=this.dao.Find( user);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
		return abc;
	}
	@Override
	public List<User> findAll() throws Exception {
		// TODO 自动生成的方法存根
		List<User> all=new ArrayList<User>();
		all=dao.findAll();
		return all;
	}
	
}
