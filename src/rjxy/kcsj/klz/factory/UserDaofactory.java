package rjxy.kcsj.klz.factory;
import rjxy.kcsj.klz.dao.IUserDAO;
import rjxy.kcsj.klz.dao.proxy.UserDaoProxy;

public class UserDaofactory {
		public static IUserDAO getIUserinstance() {
			
			return new UserDaoProxy();
		}
		
	}
