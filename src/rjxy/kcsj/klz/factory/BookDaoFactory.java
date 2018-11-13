package rjxy.kcsj.klz.factory;
import  rjxy.kcsj.klz.dao.IBookDAO;
import  rjxy.kcsj.klz.dao.proxy.BookDaoProxy;
public class BookDaoFactory {
	//通过工厂类取得DAO接口的实例化对象
 public static IBookDAO getEmpDAOinstance()throws Exception{
	return new BookDaoProxy();
			
		}
	}


