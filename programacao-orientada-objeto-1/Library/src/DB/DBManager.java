package DB;

import java.io.*;
import java.util.ArrayList;

public abstract class DBManager<DataType> {
	private String dbFilePath;
	private File dbFile;
	protected ArrayList<DataType> items = new ArrayList<DataType>();
	private String firstLineData;

	public DBManager(String dbFilePath, String firstLineData) {
		this.dbFilePath = dbFilePath;
		this.dbFile = new File(this.dbFilePath);
		this.firstLineData = firstLineData;
		this.readDBLines();
	}

	protected void readDBLines(){
		try{
			FileReader fileReader = new FileReader(this.dbFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String currentLine = bufferedReader.readLine();
			currentLine = bufferedReader.readLine(); // pular primeira linha

			while(currentLine != null && !currentLine.isEmpty()){
				DataType data = this.createInstaceOfData(currentLine.split(","));
				this.items.add(data);
				currentLine = bufferedReader.readLine(); // proxima linha
			}
		}catch(FileNotFoundException err){
			System.err.println("File not found: " + this.dbFilePath);
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("File corrupted: " + this.dbFilePath);
			System.exit(-1);
		}
	}

	abstract DataType createInstaceOfData(String[] dataArr);
	// abstract void updateDB();

}
