package Acervo;

import java.io.*;
import java.util.ArrayList;

public class Acervo {
	private ArrayList<Livro> livros = new ArrayList<>();
	private File dbFile = new File("db/acervo.csv");

	public Acervo() {
		this.readDB();
	}

	private void readDB(){
		try{
			FileReader leitura = new FileReader(dbFile);
			BufferedReader bufLeitura = new BufferedReader(leitura);
			bufLeitura.readLine(); // ignorar a primeira linha

			String actualLine = bufLeitura.readLine();
			while(actualLine != null || !actualLine.equals("")){

				String[] actualLineSplitted = actualLine.split(",");
				int id = Integer.valueOf(actualLineSplitted[0]);
				String title = actualLineSplitted[1];
				int quantity = Integer.valueOf(actualLineSplitted[2]);

				livros.add(new Livro(id, title, quantity));

				actualLine = bufLeitura.readLine(); // proxima linha
			}

			bufLeitura.close();
			leitura.close();
		}catch (FileNotFoundException err) {
			System.err.println("Arquivo de acervo nao encontrado!!!");
		}catch (IOException err) {
			System.err.println("Arquivo de acervo corrompido!!!");
		}
	}

	private void updateDB(){
		try{
			FileWriter escrita = new FileWriter(this.dbFile);
			BufferedWriter bufEscrita = new BufferedWriter(escrita);
			bufEscrita.write("ID,Título,Quantidade,Quantidade Disponiveis");
			bufEscrita.newLine();

			for(Livro livro : livros){
				bufEscrita.write(livro.getId()+","+livro.getTitulo()+","+livro.getQuantidade());
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
