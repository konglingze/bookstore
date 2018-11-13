package rjxy.kcsj.klz.dao.proxy;
import rjxy.kcsj.klz.vo.Admin;
import rjxy.kcsj.klz.dao.IAdminDAO;
import rjxy.kcsj.klz.dao.impl.AdminDAOimpl;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.factory.DatabaseConnectionFactory;
public class AdminDaoProxy implements IAdminDAO{
	private DatabaseConnection dbc=null;
	private IAdminDAO dao =null;
	public AdminDaoProxy()throws Exception{
	try {
		this.dbc=DatabaseConnectionFactory.getDatabaseConnection();
		this.dao=new AdminDAOimpl(this.dbc.getConnection());
	}catch (Exception e){
		e.printStackTrace();
	}
	
}
	@Override
	public boolean findLogin(Admin admin) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.findLogin(admin);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			this.dbc.close();
		}
			
		return flag;
	}
	
}
