package SortMethods;

public class InsertionSort extends SortBase {
	public SortResponse sort(int[] _vetor) {
		SortResponse resp = new SortResponse();
		int vetor[] = _vetor.clone();
		int alreadyOrdenedIndex = -1;


		resp.startTimer();
		for (int i = 0; i < vetor.length; i++) {
			int element = vetor[i];

//			Seleciona o elemento e passa pelo subconjunto para encontrar a posicao ideal
			for (int j = 0; j <= alreadyOrdenedIndex; j++) {
				if (element < vetor[j]) {
					int aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
					break;
				}
			}

			alreadyOrdenedIndex++;
		}

		resp.endTimer();
		resp.setFinalVector(vetor);
		return resp;
	}
}
