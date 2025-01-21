package DB;

import Library.Collection.Book;

import java.util.ArrayList;

public class DBBooks extends DBManagerv2<Book> {
	public DBBooks() {
		super("db/acervo", "ID,Título,Quantidade,Quantidade Disponivel", 5000);
	}

	@Override
	protected Book createInstaceOfData(String[] dataArr) {
		int bookId = Integer.valueOf(dataArr[0]);
		String title = dataArr[1];
		int quantityTotal = Integer.valueOf(dataArr[2]);
		String availableQuantity = dataArr[2];
		if (availableQuantity != null) {
			int availableQuantityInt = Integer.valueOf(availableQuantity);
			Book book = new Book(bookId, title, quantityTotal, availableQuantityInt);
			return book;
		} else {
			Book book = new Book(bookId, title, quantityTotal);
			return book;
		}
	}

	@Override
	protected String instanceToStringData(Book data) {
		return data.getId() + "," + data.getTitulo() + "," + data.getQuantidade() + "," + data.getAvailableQuantity();
	}

	public ArrayList<Book> getBooks() {
		return super.items;
	}

	public Book getBookById(int bookId) {
		return this.items.get(bookId - 1);
	}
}
