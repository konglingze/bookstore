package rjxy.kcsj.klz.factory;
import  rjxy.kcsj.klz.dao.IBookDAO;
import  rjxy.kcsj.klz.dao.proxy.BookDaoProxy;
public class BookDaoFactory {
	//ͨ��������ȡ��DAO�ӿڵ�ʵ��������
 public static IBookDAO getEmpDAOinstance()throws Exception{
	return new BookDaoProxy();
			
		}
	}


