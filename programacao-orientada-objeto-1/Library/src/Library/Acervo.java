package Library;

import Library.Collection.Book;

import java.io.*;
import java.util.ArrayList;

public class Acervo {
	private ArrayList<Book> books = new ArrayList<>();
	private File dbFile = new File("db/acervo.csv");

	public Acervo() {

	}

	private void updateDB(){
		try{
			FileWriter escrita = new FileWriter(this.dbFile);
			BufferedWriter bufEscrita = new BufferedWriter(escrita);
			bufEscrita.write("ID,Título,Quantidade,Quantidade Disponiveis");
			bufEscrita.newLine();

			for(Book book : books){
				bufEscrita.write(book.getId()+","+ book.getTitulo()+","+ book.getQuantidade());
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
