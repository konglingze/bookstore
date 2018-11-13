package rjxy.kcsj.klz.factory;
import rjxy.kcsj.klz.dao.IAdminDAO;
import rjxy.kcsj.klz.dao.proxy.AdminDaoProxy;;
public class AdminDaofactory {
public static IAdminDAO getIAdmininstance() throws Exception{
	return new AdminDaoProxy();
}
}
