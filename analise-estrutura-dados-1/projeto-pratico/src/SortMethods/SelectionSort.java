package SortMethods;

public class SelectionSort extends SortBase {
	public SortResponse sort(int[] _vector) {
		SortResponse resp = new SortResponse();
		int[] vector = _vector.clone();
		resp.startTimer();

		for (int i = 0; i < vector.length; i++) {
			int smallestIndex = i;
			int smallestValue = vector[i];
			for (int j = i + 1; j < vector.length; j++) {
				int currentValue = vector[j];
				if (currentValue < smallestValue) {
					smallestIndex = j;
					smallestValue = currentValue;
				}
			}

			int temp = smallestValue;
			vector[i] = smallestValue;
			vector[smallestIndex] = temp;
		}

		resp.endTimer();
		resp.setFinalVector(vector);
		return resp;
	}
}
