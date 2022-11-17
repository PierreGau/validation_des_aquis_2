package client;

import dao.BookDao;
import entity.Book;
import entity.BookMark;

public class test {

	public static void main(String[] args) {
		BookDao.persist(new Book("Harry Potter", "J.K rolling", "2/2/1996", 9 ,new BookMark(128,"la meilleure oui !")));
	}

}
