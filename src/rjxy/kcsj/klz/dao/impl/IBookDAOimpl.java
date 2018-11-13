package rjxy.kcsj.klz.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import rjxy.kcsj.klz.vo.Book;
import rjxy.kcsj.klz.dao.IBookDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IBookDAOimpl implements IBookDAO{
	private Connection conn =null ;//���ݿ����Ӷ���
	private PreparedStatement pstmt =null ;//���ݿ��������
public IBookDAOimpl(Connection conn){
	this.conn=conn;
}
	@Override
	public boolean doCreate(Book book) throws Exception {
		boolean flag = false; // �����־λ
		String sql = "INSERT INTO bookinfo(BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql); //ʵ����preparedStatement����
		this.pstmt.setString(1, book.getBookName()); // ��������
		this.pstmt.setString(2, book.getAuthor());// ��������
		this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // ���ó�������
		this.pstmt.setString(4, book.getPublisher());// ���ó�����
		this.pstmt.setFloat(5, book.getPrice());//���ü۸�
		this.pstmt.setString(6, book.getISBN());//����ISBN
		this.pstmt.setString(7, book.getBarcode());//����������
		if(this.pstmt.executeUpdate()>0){ // ���¼�¼����������0
			flag = true; // �޸ı�־λ
		}
		this.pstmt.close();
		return flag;
	}
	@Override//
	/*public boolean delete(String ISBN) throws Exception {
		// TODO �Զ����ɵķ������
		boolean flag = false; // �����־λ
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM bookinfo WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
		this.pstmt.setString(1,ISBN);//����ͼ��ISBN��
		ResultSet rs = this.pstmt.executeQuery(); // ִ�в�ѯ����
		while(rs.next()){// ���Բ�ѯ�����
			String sql2 = "DELETE FROM Bookinfo BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode WHERE ISBN=?";
			this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
			this.pstmt.setString(1,ISBN);//����ͼ��ISBN��
			 this.pstmt.execute(sql2); // ִ�в���
			flag = true;
		}
		  return flag;
	}*/
	public boolean delete(String ISBN) throws Exception {//ɾ������2.0
		// TODO �Զ����ɵķ������
		boolean flag = false; // �����־λ
		 Book book =findByISBN(ISBN);
	     if(book==null){
	    	 flag = false; 
	     }
	     else{
	    	 String ISBN2=book.getISBN();
	    	 String sql = "DELETE FROM Bookinfo BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode WHERE ISBN=?";
				this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����			
				this.pstmt.setString(1,ISBN2);//����ͼ��ISBN��
				boolean flag2=this.pstmt.execute(sql); // ִ�в���
				flag = flag2;
	     }
		return flag ;
	}
	@Override
/*	public  boolean modify(String ISBN) throws Exception {�޸ķ���1.0����
		// TODO �Զ����ɵķ������
		boolean flag = false; // �����־λ
		Book book = null;// ����Book����
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM bookinfo WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
		this.pstmt.setString(1,ISBN);//����ͼ��ISBN��
		ResultSet rs = this.pstmt.executeQuery(); // ִ�в�ѯ����
		while(rs.next()){// ���Բ�ѯ�����
			Book book2=null;
			String sql2 = "UPDATE FROM Bookinfo SET BookName=?,Author=?,PublicationDate=?,Publisher=?,price=?,ISBN=?, Barcode=? WHERE ISBN=?";
			this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
			this.pstmt.setString(1, book.getBookName()); // ��������
			this.pstmt.setString(2, book.getAuthor());// ��������
			this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // ���ó�������
			this.pstmt.setString(4, book.getPublisher());// ���ó�����
			this.pstmt.setFloat(5, book.getPrice());//���ü۸�
			this.pstmt.setString(6, book.getISBN());//����ISBN
			this.pstmt.setString(7, book.getBarcode());//����������
			this.pstmt.setString(8, book.getISBN());//����ISBN
			 this.pstmt.execute(sql2); // ִ�в���
			boolean flag2= this.pstmt.execute(sql2); // ִ�в�ѯ����
			flag = flag2;
		}
		  return flag;
	}  */
	public  boolean modify(String ISBN) throws Exception {//�޸ķ���2.0	
		 boolean flag = false; // �����־λ
	     Book book =findByISBN(ISBN);
	     if(book==null){
	    	 flag = false; 
	     }
	     else{
	    	 String ISBN2=book.getISBN();
	     String sql = "UPDATE FROM Bookinfo SET BookName=?,Author=?,PublicationDate=?,Publisher=?,price=?,ISBN=?, Barcode=? WHERE ISBN=?";
	 		this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
	    	this.pstmt.setString(1, book.getBookName()); // ��������
	 		this.pstmt.setString(2, book.getAuthor());// ��������
	 		this.pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime())); // ���ó�������
	 		this.pstmt.setString(4, book.getPublisher());// ���ó�����
	 		this.pstmt.setFloat(5, book.getPrice());//���ü۸�
	 		this.pstmt.setString(6, book.getISBN());//����ISBN
	 		this.pstmt.setString(7, ISBN2);//���ò�ѯ������
	 		this.pstmt.execute(sql); // ִ�в���
			boolean flag2= this.pstmt.execute(sql); 
			flag = flag2;   	 
	     }
	     
	     return flag;
	}
	@Override//ͨ��ISBN�Ų�ѯͼ����Ϣ
	public Book findByISBN(String ISBN) throws Exception {
		// TODO �Զ����ɵķ������
		Book book = null;// ����Book����
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM book WHERE ISBN=?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
		this.pstmt.setString(1,ISBN);//���ù�Ա���
		ResultSet rs = this.pstmt.executeQuery(); // ִ�в�ѯ����
		while(rs.next()){// ���Բ�ѯ�����
			book = new Book();// ʵ�����µ�Book����
			book.setBookName(rs.getString(1));// ��������������
			book.setAuthor(rs.getString(2));// �������ߵ�����
			book.setPublicationDate(rs.getDate(3));// ���ó������ڵ�����
			book.setPublisher(rs.getString(4));// ���ó����������
			book.setPrice(rs.getFloat(5));// ���ü۸������
			book.setISBN(rs.getString(6));// ����ISBN������
			book.setBarcode(rs.getString(7));// ���������������
		}
		this.pstmt.close(); // �ر�PreparedStatement����
		return book;
	}
	@Override//���ȫ��ͼ����Ϣ
	public List<Book> finaAll(String keyWord) throws Exception {
		List<Book> all = new ArrayList<Book>();// ���弯�ϣ�����ȫ������
		String sql = "SELECT BookName,Author,PublicationDate,Publisher,price,ISBN, Barcode FROM Book WHERE BookName LIKE ? OR Author LIKE ? OR PublicationDate LIKE ? OR Publisher LIKE ? OR price LIKE ? OR ISBN LIKE ? OR BarcodeLIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
		this.pstmt.setString(1, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(2, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(3, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(4, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(5, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(6, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		this.pstmt.setString(7, "%" + keyWord+"%");//���ò�ѯ�ؼ���
		ResultSet rs = this.pstmt.executeQuery(); // ִ�в�ѯ����
		Book book = null;// ����Book����
		while(rs.next()){// һ��ȡ��ÿһ������
			book = new Book();// ʵ�����µ�Book����
			book.setBookName(rs.getString(1));// ��������������
			book.setAuthor(rs.getString(2));// �������ߵ�����
			book.setPublicationDate(rs.getDate(3));// ���ó������ڵ�����
			book.setPublisher(rs.getString(4));// ���ó����������
			book.setPrice(rs.getFloat(5));// ���ü۸������
			book.setISBN(rs.getString(6));// ����ISBN������
			book.setBarcode(rs.getString(7));// ���������������
			all.add(book); // �򼯺������Ӷ���
		}
		this.pstmt.close(); // �ر�PreparedStatement����
		return all;
	}
}
