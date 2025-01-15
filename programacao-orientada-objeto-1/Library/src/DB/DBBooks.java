package DB;

import Library.Collection.Book;

import java.util.ArrayList;

public class DBBooks extends DBManager<Book> {
	public DBBooks() {
		super("db/acervo.csv", "ID,Título,Quantidade");
	}

	@Override
	Book createInstaceOfData(String[] dataArr) {
		String bookId = dataArr[0];
		String title = dataArr[1];
		int quantityTotal = Integer.valueOf(dataArr[2]);
		Book book = new Book(bookId, title, quantityTotal);
		return book;
	}

	public ArrayList<Book> getBooks() {
		return super.items;
	}
}
