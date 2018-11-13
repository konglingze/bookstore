package rjxy.kcsj.klz.dao;
import java.util.List;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.vo.User;
public interface IUserDAO {
 public boolean findLogin(User user)throws Exception;
 public boolean Delete(User user)throws Exception;
 public boolean Modify(User user,User user2)throws Exception;
 public boolean Insert(User user)throws Exception;
 public User Find(User user)throws Exception;
 public List<User> findAll() throws Exception;
public DatabaseConnection getDatabseConnection();
 
}
