package rjxy.kcsj.klz.dao;
import rjxy.kcsj.klz.vo.Book;
import java.util.List;


public interface IBookDAO {//������ɾ�Ĳ�Ĳ����淶
	//��ѯȫ�����	
	    public List<Book> finaAll(String keyWord)throws Exception;
	//�������Ӳ���
		public boolean doCreate(Book book) throws Exception;
	//���ݲ�ѯ����	
		public Book findByISBN(String ISBN)throws Exception;
    // ����ɾ������
		public boolean delete(String ISBN)throws Exception;
	//�����޸Ĳ���
		public boolean modify(String ISBN)throws Exception;
}
