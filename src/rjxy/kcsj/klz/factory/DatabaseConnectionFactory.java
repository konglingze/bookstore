package rjxy.kcsj.klz.factory;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.dbc.impl.MysqlDatabaseConnection;
public class DatabaseConnectionFactory {
  //ȡ��DatabaseConnection�ӿ�ʵ��
	public static DatabaseConnection getDatabaseConnection(){
		
		return new MysqlDatabaseConnection();
		
	}
}
