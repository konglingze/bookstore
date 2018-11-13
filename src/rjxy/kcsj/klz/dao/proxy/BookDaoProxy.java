package rjxy.kcsj.klz.dao.proxy;
import java.util.List;
import rjxy.kcsj.klz.dao.IBookDAO;
import rjxy.kcsj.klz.dao.impl.IBookDAOimpl;
import rjxy.kcsj.klz.dbc.DatabaseConnection;
import rjxy.kcsj.klz.vo.Book;
import rjxy.kcsj.klz.factory.DatabaseConnectionFactory;
public class BookDaoProxy implements IBookDAO {
	private DatabaseConnection dbc = null;//�������ݿ�����
	private IBookDAO dao = null;//����DAO����
	public BookDaoProxy() throws Exception { // �ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc=DatabaseConnectionFactory.getDatabaseConnection();
		//this.dbc = new MySQLDatabaseConnection1(); // �������ݿ�
		
		this.dao = new IBookDAOimpl(this.dbc.getConnection());// ʵ������ʵ������
	}
	@Override
	public boolean doCreate(Book book) throws Exception {
		boolean flag = false; // �����־λ
		try {
			if(this.dao.findByISBN(book.getISBN())==null){// �������Ĺ�Ա��Ų�����
				flag = this.dao.doCreate(book); // ������ʵ�������
			}
		} catch (Exception e) { // ���쳣���������ߴ���
			throw e;
		} finally {
			this.dbc.close(); // �ر����ݿ�����
		}
		
		return flag;
	}

	@Override
	public List<Book> finaAll(String keyWord) throws Exception {
		List<Book> all = null; // ���巵�صļ���
		try {
			all = this.dao.finaAll(keyWord); // ������ʵ�������
		} catch (Exception e) { // ���쳣���������ߴ���
			throw e;
		} finally {
			this.dbc.close(); // �ر����ݿ�����
		}
		
		return all;
	}

	@Override
	public Book findByISBN(String isbn) throws Exception {
		Book book = null; // ����Book����
		try {
			book = this.dao.findByISBN(isbn); // ������ʵ�������
		} catch (Exception e) { // ���쳣���������ߴ���
			throw e;
		} finally {
			this.dbc.close(); // �ر����ݿ�����
		}
		
		return book;
	}
	@Override
	public boolean delete(String ISBN) throws Exception {
		// TODO �Զ����ɵķ������
		boolean flag = false; // ����Book����
		try {
			flag = this.dao.delete(ISBN); // ������ʵ�������
		} catch (Exception e) { // ���쳣���������ߴ���
			throw e;
		} finally {
			this.dbc.close(); // �ر����ݿ�����
		}
		
		return flag;
	}
	@Override
	public boolean modify(String ISBN) throws Exception {
		// TODO �Զ����ɵķ������
		boolean flag = false; // ����Book����
		try {
			flag = this.dao.modify(ISBN); // ������ʵ�������
		} catch (Exception e) { // ���쳣���������ߴ���
			throw e;
		} finally {
			this.dbc.close(); // �ر����ݿ�����
		}
		
		return flag;
	 }
 }


//�����ฺ�����ݿ����ʵ����