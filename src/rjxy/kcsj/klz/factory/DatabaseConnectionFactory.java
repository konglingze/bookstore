package rjxy.kcsj.klz.factory;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.dbc.impl.MysqlDatabaseConnection;
public class DatabaseConnectionFactory {
  //取得DatabaseConnection接口实例
	public static DatabaseConnection getDatabaseConnection(){
		
		return new MysqlDatabaseConnection();
		
	}
}
