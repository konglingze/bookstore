package rjxy.kcsj.klz.dao.proxy;
import java.util.List;
import rjxy.kcsj.klz.dao.IBookDAO;
import rjxy.kcsj.klz.dao.impl.IBookDAOimpl;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.vo.Book;
import rjxy.kcsj.klz.factory.DatabaseConnectionFactory;
public class BookDaoProxy implements IBookDAO {
	private DatabaseConnection dbc = null;//定义数据库连接
	private IBookDAO dao = null;//声明DAO对象
	public BookDaoProxy() throws Exception { // 在构造方法中实例化连接，同时实例化dao对象
		this.dbc=DatabaseConnectionFactory.getDatabaseConnection();
		//this.dbc = new MySQLDatabaseConnection1(); // 连接数据库
		
		this.dao = new IBookDAOimpl(this.dbc.getConnection());// 实例化真实主题类
	}
	@Override
	public boolean doCreate(Book book) throws Exception {
		boolean flag = false; // 定义标志位
		try {
			if(this.dao.findByISBN(book.getISBN())==null){// 如果插入的雇员编号不存在
				flag = this.dao.doCreate(book); // 调用真实主题操作
			}
		} catch (Exception e) { // 有异常交给调用者处理
			throw e;
		} finally {
			this.dbc.close(); // 关闭数据库连接
		}
		
		return flag;
	}

	@Override
	public List<Book> finaAll(String keyWord) throws Exception {
		List<Book> all = null; // 定义返回的集合
		try {
			all = this.dao.finaAll(keyWord); // 调用真实主题操作
		} catch (Exception e) { // 有异常交给调用者处理
			throw e;
		} finally {
			this.dbc.close(); // 关闭数据库连接
		}
		
		return all;
	}

	@Override
	public Book findByISBN(String isbn) throws Exception {
		Book book = null; // 定义Book对象
		try {
			book = this.dao.findByISBN(isbn); // 调用真实主题操作
		} catch (Exception e) { // 有异常交给调用者处理
			throw e;
		} finally {
			this.dbc.close(); // 关闭数据库连接
		}
		
		return book;
	}
	@Override
	public boolean delete(String ISBN) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false; // 定义Book对象
		try {
			flag = this.dao.delete(ISBN); // 调用真实主题操作
		} catch (Exception e) { // 有异常交给调用者处理
			throw e;
		} finally {
			this.dbc.close(); // 关闭数据库连接
		}
		
		return flag;
	}
	@Override
	public boolean modify(String ISBN) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false; // 定义Book对象
		try {
			flag = this.dao.modify(ISBN); // 调用真实主题操作
		} catch (Exception e) { // 有异常交给调用者处理
			throw e;
		} finally {
			this.dbc.close(); // 关闭数据库连接
		}
		
		return flag;
	 }
 }


//代理类负责数据库的真实连接