package rjxy.kcsj.klz.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import rjxy.kcsj.klz.vo.Book;
import rjxy.kcsj.klz.dao.IBookDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IBookDAOimpl implements IBookDAO{
	private Connection conn =null ;//数据库连接对象
	private PreparedStatement pstmt =null ;//数据库操作对象
public IBookDAOimpl(Connection conn){
	this.conn=conn;
}
	@Override
	public boolean doCreate(Book book) throws Exception {
		boolean flag = false; // 定义标志位
		String sql = "INSERT INTO bookinfo(BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql); //实例化preparedStatement对象
		this.pstmt.setString(1, book.getBookName()); // 设置书名
		this.pstmt.setString(2, book.getAuthor());// 设置作者
		this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // 设置出版日期
		this.pstmt.setString(4, book.getPublisher());// 设置出版社
		this.pstmt.setFloat(5, book.getPrice());//设置价格
		this.pstmt.setString(6, book.getISBN());//设置ISBN
		this.pstmt.setString(7, book.getBarcode());//设置条形码
		if(this.pstmt.executeUpdate()>0){ // 更新记录的行数大于0
			flag = true; // 修改标志位
		}
		this.pstmt.close();
		return flag;
	}
	@Override//
	/*public boolean delete(String ISBN) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false; // 定义标志位
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM bookinfo WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
		this.pstmt.setString(1,ISBN);//设置图书ISBN号
		ResultSet rs = this.pstmt.executeQuery(); // 执行查询操作
		while(rs.next()){// 可以查询到结果
			String sql2 = "DELETE FROM Bookinfo BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode WHERE ISBN=?";
			this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
			this.pstmt.setString(1,ISBN);//设置图书ISBN号
			 this.pstmt.execute(sql2); // 执行操作
			flag = true;
		}
		  return flag;
	}*/
	public boolean delete(String ISBN) throws Exception {//删除方法2.0
		// TODO 自动生成的方法存根
		boolean flag = false; // 定义标志位
		 Book book =findByISBN(ISBN);
	     if(book==null){
	    	 flag = false; 
	     }
	     else{
	    	 String ISBN2=book.getISBN();
	    	 String sql = "DELETE FROM Bookinfo BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode WHERE ISBN=?";
				this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象			
				this.pstmt.setString(1,ISBN2);//设置图书ISBN号
				boolean flag2=this.pstmt.execute(sql); // 执行操作
				flag = flag2;
	     }
		return flag ;
	}
	@Override
/*	public  boolean modify(String ISBN) throws Exception {修改方法1.0测试
		// TODO 自动生成的方法存根
		boolean flag = false; // 定义标志位
		Book book = null;// 声明Book对象
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM bookinfo WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
		this.pstmt.setString(1,ISBN);//设置图书ISBN号
		ResultSet rs = this.pstmt.executeQuery(); // 执行查询操作
		while(rs.next()){// 可以查询到结果
			Book book2=null;
			String sql2 = "UPDATE FROM Bookinfo SET BookName=?,Author=?,PublicationDate=?,Publisher=?,price=?,ISBN=?, Barcode=? WHERE ISBN=?";
			this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
			this.pstmt.setString(1, book.getBookName()); // 设置书名
			this.pstmt.setString(2, book.getAuthor());// 设置作者
			this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // 设置出版日期
			this.pstmt.setString(4, book.getPublisher());// 设置出版社
			this.pstmt.setFloat(5, book.getPrice());//设置价格
			this.pstmt.setString(6, book.getISBN());//设置ISBN
			this.pstmt.setString(7, book.getBarcode());//设置条形码
			this.pstmt.setString(8, book.getISBN());//设置ISBN
			 this.pstmt.execute(sql2); // 执行操作
			boolean flag2= this.pstmt.execute(sql2); // 执行查询操作
			flag = flag2;
		}
		  return flag;
	}  */
	public  boolean modify(String ISBN) throws Exception {//修改方法2.0	
		 boolean flag = false; // 定义标志位
	     Book book =findByISBN(ISBN);
	     if(book==null){
	    	 flag = false; 
	     }
	     else{
	    	 String ISBN2=book.getISBN();
	     String sql = "UPDATE FROM Bookinfo SET BookName=?,Author=?,PublicationDate=?,Publisher=?,price=?,ISBN=?, Barcode=? WHERE ISBN=?";
	 		this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
	    	this.pstmt.setString(1, book.getBookName()); // 设置书名
	 		this.pstmt.setString(2, book.getAuthor());// 设置作者
	 		this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // 设置出版日期
	 		this.pstmt.setString(4, book.getPublisher());// 设置出版社
	 		this.pstmt.setFloat(5, book.getPrice());//设置价格
	 		this.pstmt.setString(6, book.getISBN());//设置ISBN
	 		this.pstmt.setString(7, ISBN2);//设置查询条形码
	 		this.pstmt.execute(sql); // 执行操作
			boolean flag2= this.pstmt.execute(sql); 
			flag = flag2;   	 
	     }
	     
	     return flag;
	}
	@Override//通过ISBN号查询图书信息
	public Book findByISBN(String ISBN) throws Exception {
		// TODO 自动生成的方法存根
		Book book = null;// 声明Book对象
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM book WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
		this.pstmt.setString(1,ISBN);//设置雇员编号
		ResultSet rs = this.pstmt.executeQuery(); // 执行查询操作
		while(rs.next()){// 可以查询到结果
			book = new Book();// 实例化新的Book对象
			book.setBookName(rs.getString(1));// 设置书名的内容
			book.setAuthor(rs.getString(2));// 设置作者的内容
			book.setPublicationDate(rs.getDate(3));// 设置出版日期的内容
			book.setPublisher(rs.getString(4));// 设置出版社的内容
			book.setPrice(rs.getFloat(5));// 设置价格的内容
			book.setISBN(rs.getString(6));// 设置ISBN的内容
			book.setBarcode(rs.getString(7));// 设置条形码的内容
		}
		this.pstmt.close(); // 关闭PreparedStatement操作
		return book;
	}
	@Override//输出全部图书信息
	public List<Book> finaAll(String keyWord) throws Exception {
		List<Book> all = new ArrayList<Book>();// 定义集合，接收全部数据
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM Book WHERE BookName LIKE ? OR Author LIKE ? OR PublicationDate LIKE ? OR Publisher LIKE ? OR price LIKE ? OR ISBN LIKE ? OR BarcodeLIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
		this.pstmt.setString(1, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(2, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(3, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(4, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(5, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(6, "%" + keyWord+"%");//设置查询关键字
		this.pstmt.setString(7, "%" + keyWord+"%");//设置查询关键字
		ResultSet rs = this.pstmt.executeQuery(); // 执行查询操作
		Book book = null;// 定义Book对象
		while(rs.next()){// 一次取出每一条数据
			book = new Book();// 实例化新的Book对象
			book.setBookName(rs.getString(1));// 设置书名的内容
			book.setAuthor(rs.getString(2));// 设置作者的内容
			book.setPublicationDate(rs.getDate(3));// 设置出版日期的内容
			book.setPublisher(rs.getString(4));// 设置出版社的内容
			book.setPrice(rs.getFloat(5));// 设置价格的内容
			book.setISBN(rs.getString(6));// 设置ISBN的内容
			book.setBarcode(rs.getString(7));// 设置条形码的内容
			all.add(book); // 向集合中增加对象
		}
		this.pstmt.close(); // 关闭PreparedStatement操作
		return all;
	}
}
