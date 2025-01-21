package Library.Collection;

import DB.DBItem;

public class Book extends DBItem {
	private String titulo;
	private int quantidade;
	private int availableQuantity;

	public Book(int id, String titulo, int quantidade) {
		super(id);
		this.titulo = titulo;
		this.quantidade = quantidade;
		this.availableQuantity = quantidade;
	}

	public Book(int id, String titulo, int quantidade, int availableQuantity) {
		super(id);
		this.titulo = titulo;
		this.quantidade = quantidade;
		this.availableQuantity = availableQuantity;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}
}
