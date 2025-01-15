package Library.Collection;

public class Book {
	private String id;
	private String titulo;
	private int quantidade;

	public Book(String id, String titulo, int quantidade) {
		this.id = id;
		this.titulo = titulo;
		this.quantidade = quantidade;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
