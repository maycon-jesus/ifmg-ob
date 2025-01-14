package Acervo;

public class Livro {
	private int id;
	private String titulo;
	private int quantidade;

	public Livro(int id, String titulo, int quantidade) {
		this.id = id;
		this.titulo = titulo;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
