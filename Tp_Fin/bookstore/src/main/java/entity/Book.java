package entity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dao.BookDao;


@Entity(name = "book")
@Table(name = "book")
@ManagedBean(name = "book")
@ApplicationScoped
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "releaseDate")
	private String releaseDate;

	@Column(name = "price")
	private int price;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bookmark_id", referencedColumnName = "id")
	private BookMark bookMark;

	
	
	public Book() {
		addBookMark(new BookMark());
	}
	
	public void addBookMark(BookMark bookMark)
	{
		bookMark.setBook(this);
		this.bookMark = bookMark;	
	}

	public Book(String title, String autor, String releaseDate, int price, BookMark bookMark) {
		this.title = title;
		this.author = autor;
		this.releaseDate = releaseDate;
		this.price = price;
		addBookMark(bookMark);
	}
	
	public Book(String title, String autor, String releaseDate, int price) {
		this.title = title;
		this.author = autor;
		this.releaseDate = releaseDate;
		this.price = price;
		addBookMark(new BookMark());
	}

	public Book(int id, String title, String autor, String releaseDate, int price, BookMark bookMark) {
		this.id = id;
		this.title = title;
		this.author = autor;
		this.releaseDate = releaseDate;
		this.price = price;
		addBookMark(bookMark);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		BookDao.update(this);
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		BookDao.update(this);
		this.author = autor;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		BookDao.update(this);
		this.releaseDate = releaseDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		BookDao.update(this);
		this.price = price;
	}

	public BookMark getBookMark() {
		return bookMark;
	}

	public void setBookMark(BookMark bookMark) {
		BookDao.update(this);
		this.bookMark = bookMark;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, title=%s, autor=%s, releaseDate=%s, price=%s, bookMark=%s]", id, title,
				author, releaseDate, price, bookMark);
	}
	
	public void add()
	{
		BookDao.persist(this);
	}
}
