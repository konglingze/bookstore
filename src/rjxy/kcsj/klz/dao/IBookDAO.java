package rjxy.kcsj.klz.dao;
import rjxy.kcsj.klz.vo.Book;
import java.util.List;


public interface IBookDAO {//定义增删改查的操作规范
	//查询全部结果	
	    public List<Book> finaAll(String keyWord)throws Exception;
	//数据增加操作
		public boolean doCreate(Book book) throws Exception;
	//数据查询操作	
		public Book findByISBN(String ISBN)throws Exception;
    // 数据删除操作
		public boolean delete(String ISBN)throws Exception;
	//数据修改操作
		public boolean modify(String ISBN)throws Exception;
}
