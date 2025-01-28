package SortMethods;

public class BubbleSort extends SortBase {
	@Override
	public SortResponse sort(int[] _vetor) {
		SortResponse resp = new SortResponse();
		int[] vetor = _vetor.clone();
		resp.startTimer();
		for (int i = 0; i < vetor.length - 1; i++) {
			int itemPosition = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[itemPosition] > vetor[j]) {
					int temp = vetor[itemPosition];
					vetor[itemPosition] = vetor[j];
					vetor[j] = temp;
					itemPosition = j;
				}
			}
		}
		resp.endTimer();
		resp.setFinalVector(vetor);
		return resp;
	}
}
