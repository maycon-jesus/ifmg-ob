public class InsertionSort {
	static SortResponse sort(int[] vetor){
		SortResponse resp = new SortResponse();
		int alreadyOrdenedIndex = -1;


		for(int i = 0; resp.incrementInteraction() && i < vetor.length; i++){

			int element = vetor[i];

//			Seleciona o elemento e passa pelo subconjunto para encontrar a posicao ideal
			for(int j = 0; resp.incrementInteraction() && j <= alreadyOrdenedIndex; j++){
				if(resp.incrementInteraction() && element < vetor[j]){
					int aux = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = aux;
					break;
				}
			}

			alreadyOrdenedIndex++;
		}

		return resp;
	}
}
