package Library;

import Library.Collection.Book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Acervo {
	private ArrayList<Book> books = new ArrayList<>();
	private File dbFile = new File("db/0.csv");

	public Acervo() {

	}

	private void updateDB() {
		try {
			FileWriter escrita = new FileWriter(this.dbFile);
			BufferedWriter bufEscrita = new BufferedWriter(escrita);
			bufEscrita.write("ID,Título,Quantidade,Quantidade Disponiveis");
			bufEscrita.newLine();

			for (Book book : books) {
				bufEscrita.write(book.getId() + "," + book.getTitulo() + "," + book.getQuantidade());
				bufEscrita.newLine();
			}

			bufEscrita.flush();
			bufEscrita.close();
			escrita.close();
		} catch (IOException e) {
			System.err.println("Não foi possível atualizar o arquivo de acervo!!!");
			throw new RuntimeException(e);
		}
	}
}
