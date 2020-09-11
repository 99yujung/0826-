package library;

import java.sql.Date;

public class LibraryVO {
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String published_date;

	/* */
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublished_date() {
		return published_date;
	}
	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}
	
	@Override
	public String toString() {
		return "LibraryVO [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", published_date=" + published_date + "]";
	}
	public LibraryVO() {
		
	}
	public LibraryVO(String ISBN, String title, String author, String publisher, String published_date) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.published_date = published_date;
	}
	
}
