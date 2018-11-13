package rjxy.kcsj.klz.dbc;
import java.sql.Connection;
public interface DatabaseConnection {
public Connection getConnection();
public void close()throws Exception;
}
