package db;

import java.io.*;
import java.util.ArrayList;

public abstract class DBManager<DataType extends DBItem> {
	protected ArrayList<DataType> items = new ArrayList<DataType>();
	private String dbFolderPath;
	private File dbFolder;
	private String firstLineData;
	private int chunkSize = 10;

	public DBManager(String dbFilePath, String firstLineData, int chunkSize) {
		this.dbFolderPath = dbFilePath;
		this.dbFolder = new File(this.dbFolderPath);
		this.firstLineData = firstLineData;
		this.chunkSize = chunkSize;
		if (!this.dbFolder.exists()) {
			this.dbFolder.mkdir();
		}
		if (!this.dbFolder.isDirectory()) {
			throw new RuntimeException(dbFilePath + " is not a directory");
		}
		this.readDBLines();
	}

	protected void readDBLines() {

		File[] files = this.dbFolder.listFiles();

		for (File file : files) {
			ArrayList<DataType> items = this.readChunk(file);
			this.items.addAll(items);
		}
	}

	private ArrayList<DataType> readChunk(File chunkFile) {
		ArrayList<DataType> items = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(chunkFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String currentLine = bufferedReader.readLine();
			currentLine = bufferedReader.readLine(); // pular primeira linha

			while (currentLine != null && !currentLine.isEmpty()) {
				// Arruma problema que o split quando 2 virgulas estão juntas considera so uma
				String[] strFixed = currentLine.split(",");
				for (int i = 0; i < strFixed.length; i++) {
					if (strFixed[i].equals("null")) {
						strFixed[i] = "";
					}
				}
				DataType data = this.createInstaceOfData(strFixed);
				items.add(data);
				currentLine = bufferedReader.readLine(); // proxima linha

				if (currentLine == null || currentLine.isEmpty()) {
					return items;
				}
			}
		} catch (FileNotFoundException err) {
			System.err.println("File not found: " + this.dbFolderPath);
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("File corrupted: " + this.dbFolderPath);
			System.exit(-1);
		}
		System.out.println("aaaa");
		return items;
	}

	private int getChunkId(DataType data) {
		return (data.getId() - 1) / this.chunkSize;
	}

	private String getChunkPath(DataType data) {
		int chunkNumber = this.getChunkId(data);
		return this.dbFolderPath + "/" + chunkNumber + ".csv";
	}

	private ArrayList<DataType> getChunkItems(int chunkId) {
		int start = chunkId * this.chunkSize;
		int end = start + this.chunkSize;
		if (end > this.items.size()) {
			end = this.items.size();
		}
		return new ArrayList(this.items.subList(start, end));
	}


	public void onUpdateData(DataType data) {
		int chunkId = this.getChunkId(data);
		File chunkFile = new File(this.getChunkPath(data));
		ArrayList<DataType> items = this.getChunkItems(chunkId);

		try {
			FileWriter writer = new FileWriter(chunkFile);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(this.firstLineData);
			bufferedWriter.newLine();

			for (DataType item : items) {
				bufferedWriter.write(this.instanceToStringData(item));
				bufferedWriter.newLine();
			}

			bufferedWriter.flush();
			bufferedWriter.close();
			writer.close();
		} catch (IOException e) {
			System.err.println("File corrupted: " + this.dbFolderPath);
			System.exit(-1);
		}
	}

	public int getNextItemId() {
		return this.items.size() > 1 ? this.items.getLast().getId() + 1 : 1;
	}

	public void insertData(DataType data) {
		this.items.add(data);
		this.onUpdateData(data);
	}

	abstract DataType createInstaceOfData(String[] dataArr);

	abstract String instanceToStringData(DataType data);

}
