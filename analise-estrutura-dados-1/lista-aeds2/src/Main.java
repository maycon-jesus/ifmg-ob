public class Main {
	public static void main(String[] args) {
		SortResponse resp = InsertionSort.sort(new int[]{3, 2,1});
		System.out.println(resp.interactions);

		SortResponse resp2 = SelectionSort.sort(new int[]{3, 2,1});
		System.out.println(resp2.interactions);

		SortResponse resp3 = MergeSort.sort(new int[]{3,2,1});
		System.out.println(resp3.interactions);
		resp3.printFinalVector();

	}
}
