import java.util.ArrayList;

public class ArrayMethods {
	public static ArrayList<Integer> findOddNumbers(int[] array, int currentIndex) {
		if(currentIndex == array.length) return new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(array[currentIndex] % 2 == 0) {
			ArrayList<Integer> nNums = findOddNumbers(array, currentIndex+1);
			list.addAll(nNums);
			return list;
		}

		list.add(array[currentIndex]);
		ArrayList<Integer> nNums = findOddNumbers(array, currentIndex+1);
		list.addAll(nNums);
		return list;

	}

	public static boolean isSorted(int[] array) {
		if(array.length < 2) return true;
		int prev = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < prev) {
				return false;
			}
			prev = array[i];

		}
		return true;
	}

	public static int[] invertArray(int[] array) {
		if(array.length < 2) return array;
		int half = array.length / 2;
		for(int i = 0; i < half; i++) {
			int oposto = array[array.length-2-i];
			int temp = array[i];
			array[i]=array[oposto];
			array[oposto]=temp;
		}
		return array;
	}
}
