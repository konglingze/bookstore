package rjxy.kcsj.klz.dbc.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
public class MysqlDatabaseConnection implements DatabaseConnection{
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	 private static final String DBURL="jdbc:mysql://localhost:3307/bookstore?useUnicode=true&characterEncoding=utf-8";
	 private static final String DBUSER="root";
	 private static final String DBPASSWORD="3027310";
	 
	 private Connection conn=null;
	public Connection getConnection(){
		return this.conn;	
	}
	 public  MysqlDatabaseConnection(){
		 try{
			 Class.forName(DBDRIVER);
			 this.conn =DriverManager
					 .getConnection(DBURL,DBUSER,DBPASSWORD);
		 }catch(Exception e){
			 
			 e.printStackTrace();
		 }
	  }
public void close() throws Exception{
	if(this.conn!=null){
		 try{
			 this.conn.close();
			 
		 }catch(Exception e){
			 throw e;
	
        }
      }
   }
}
//DatabaseConnection的子类
//使用Mysql数据库