package entity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "bookMark")
@Table(name = "bookMark")
@ManagedBean(name="bookMark")
@ApplicationScoped
public class BookMark
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="page")
	private int page;
	
	@Column(name="comment")
	private String comment;
	

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "bookMark")
	private Book book;
	
	public BookMark() {
		this.page = 0;
		this.comment = "";
	}

	public BookMark(int page, String comment, Book book) {
		this.page = page;
		this.comment = comment;
		this.book = book;
	}

	public BookMark(int id, int page, String comment, Book book) {
		this.id = id;
		this.page = page;
		this.comment = comment;
		this.book = book;
	}
	
	public BookMark(int page, String comment) {
		this.page = page;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return String.format("BookMark [id=%s, page=%s, comment=%s, book=%s]", id, page, comment, book);
	}
}
