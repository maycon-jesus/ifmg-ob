package DB;

public abstract class DBItem<DataType> {
	private int id;

	protected DBItem(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
