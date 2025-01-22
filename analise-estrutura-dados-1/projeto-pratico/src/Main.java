import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();

		System.out.println("Scenario\tInsertionSort\tSelectionSort\tMergeSort");

		int[] bestInsertionArray = null;
		int[] bestSelectionArray = null;
		int[] bestMergeArray = null;

		int[] worstInsertionArray = null;
		int[] worstSelectionArray = null;
		int[] worstMergeArray = null;

		int bestInsertion = Integer.MAX_VALUE;
		int bestSelection = Integer.MAX_VALUE;
		int bestMerge = Integer.MAX_VALUE;

		int worstInsertion = Integer.MIN_VALUE;
		int worstSelection = Integer.MIN_VALUE;
		int worstMerge = Integer.MIN_VALUE;

		for (int scenario = 1; scenario <= 100; scenario++) {
			int size = 10; // Tamanho do array entre 1 e 50
			int[] array = random.ints(size, -10, 11).toArray(); // Array com valores de -100 a 100

			SortResponse insertionResult = InsertionSort.sort(array);
			SortResponse selectionResult = SelectionSort.sort(array);
			SortResponse mergeResult = MergeSort.sort(array);

			System.out.printf("%3d\t%15d\t%15d\t%15d\n", scenario,
					insertionResult.getInteractions(),
					selectionResult.getInteractions(),
					mergeResult.getInteractions());

			// Atualizar melhor e pior cenário para InsertionSort
			if (insertionResult.getInteractions() < bestInsertion) {
				bestInsertion = insertionResult.getInteractions();
				bestInsertionArray = array.clone();
			}
			if (insertionResult.getInteractions() > worstInsertion) {
				worstInsertion = insertionResult.getInteractions();
				worstInsertionArray = array.clone();
			}

			// Atualizar melhor e pior cenário para SelectionSort
			if (selectionResult.getInteractions() < bestSelection) {
				bestSelection = selectionResult.getInteractions();
				bestSelectionArray = array.clone();
			}
			if (selectionResult.getInteractions() > worstSelection) {
				worstSelection = selectionResult.getInteractions();
				worstSelectionArray = array.clone();
			}

			// Atualizar melhor e pior cenário para MergeSort
			if (mergeResult.getInteractions() < bestMerge) {
				bestMerge = mergeResult.getInteractions();
				bestMergeArray = array.clone();
			}
			if (mergeResult.getInteractions() > worstMerge) {
				worstMerge = mergeResult.getInteractions();
				worstMergeArray = array.clone();
			}
		}

		// Exibir melhores e piores cenários
		System.out.println("\nMelhores e Piores Cenários:");

		System.out.println("InsertionSort:");
		System.out.println("  Melhor cenário: " + Arrays.toString(bestInsertionArray) + " com " + bestInsertion + " interações");
		System.out.println("  Pior cenário: " + Arrays.toString(worstInsertionArray) + " com " + worstInsertion + " interações");

		System.out.println("SelectionSort:");
		System.out.println("  Melhor cenário: " + Arrays.toString(bestSelectionArray) + " com " + bestSelection + " interações");
		System.out.println("  Pior cenário: " + Arrays.toString(worstSelectionArray) + " com " + worstSelection + " interações");

		System.out.println("MergeSort:");
		System.out.println("  Melhor cenário: " + Arrays.toString(bestMergeArray) + " com " + bestMerge + " interações");
		System.out.println("  Pior cenário: " + Arrays.toString(worstMergeArray) + " com " + worstMerge + " interações");

		ArrayList<Integer> list = ArrayMethods.findOddNumbers(new int[]{1,2,3,4,5}, 0);
		System.out.println("Econtrar numeros impares: "+Arrays.toString(list.toArray()));
		boolean isSorted1 = ArrayMethods.isSorted(new int[]{1,2,3,4,5});
		System.out.println("Esta ordenado 1? "+ isSorted1);
		boolean isSorted2 = ArrayMethods.isSorted(new int[]{1,2,3,4,1});
		System.out.println("Esta ordenado 2? "+ isSorted2);
		int[] inverted = ArrayMethods.invertArray(new int[]{1,2,3,4,5});
		System.out.println("Esta invertido? "+ Arrays.toString(inverted));


	}

}
