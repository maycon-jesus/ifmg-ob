import SortMethods.InsertionSort;
import SortMethods.SortBase;
import SortMethods.SortResponse;
import utils.ArrGenerator;

public class Main {
	public static void main(String[] args) {
		testScenario("INSERTION SORT", new InsertionSort());
//		testScenario("MERGE SORT", new MergeSort());
//		testScenario("SELECTION SORT", new SelectionSort());
//		testScenario("BUBBLE SORT", new BubbleSort());
//		testScenario("QUICK SORT", new QuickSort());

	}

	private static void testScenario(String title, SortBase sortInstance) {
		int[] scenarios = new int[]{100, 500, 1_000, 5_000, 20_000, 50_000, 100_000, 500_000};
		for (int scenario : scenarios) {
			System.out.println("====[" + title + ": " + scenario + "]====");
			int[] arrRandom = ArrGenerator.randomNumbers(scenario);
			int[] arrAsc = ArrGenerator.ascNumbers(scenario);
			int[] arrDesc = ArrGenerator.descNumbers(scenario);


			double totalRandom = 0;
			double totalAsc = 0;
			double totalDesc = 0;
			int samples = 1;

			for (int i = 0; i < samples; i++) {
				System.out.println("Sample " + i);
				SortResponse respRandom = sortInstance.sort(arrRandom);
				totalRandom += respRandom.getSortDuration();
			}
			System.out.println("Array aleatorio: " + totalRandom / samples + "ms");

			for (int i = 0; i < samples; i++) {
				System.out.println("Sample " + i);
				SortResponse respAsc = sortInstance.sort(arrAsc);
				totalAsc += respAsc.getSortDuration();
			}
			System.out.println("Array crescente: " + totalAsc / samples + "ms");

			for (int i = 0; i < samples; i++) {
				System.out.println("Sample " + i);
				SortResponse respDesc = sortInstance.sort(arrDesc);
				totalDesc += respDesc.getSortDuration();
			}
			System.out.println("Array decrescente: " + totalDesc / samples + "ms");


			System.out.println("===");
		}
	}

}
