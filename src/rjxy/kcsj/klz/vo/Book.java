package rjxy.kcsj.klz.vo;

import java.util.Date;

public class Book {
private String BookName ;//书名
private String Author ;//作者
private Date PublicationDate;//出版日期
private String Publisher;//出版社
private float price;//价格
private String ISBN;//书号
private String Barcode;//条形码
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getBarcode() {
	return Barcode;
}
public void setBarcode(String barcode) {
	Barcode = barcode;
}
public String getBookName() {
	return BookName;
}
public void setBookName(String bookName) {
	BookName = bookName;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public Date getPublicationDate() {
	return PublicationDate;
}
public void setPublicationDate(Date publicationDate) {
	PublicationDate = publicationDate;
}
public String getPublisher() {
	return Publisher;
}
public void setPublisher(String publisher) {
	Publisher = publisher;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
