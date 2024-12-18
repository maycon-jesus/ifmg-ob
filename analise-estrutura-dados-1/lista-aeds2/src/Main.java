public class Main {
	public static void main(String[] args) {
		SortResponse resp = InsertionSort.sort(new int[]{3, 2,1});
		System.out.println(resp.interactions);

		SortResponse resp2 = SelectionSort.sort(new int[]{3, 2,1});
		System.out.println(resp2.interactions);
	}
}
