package SortMethods;

public class QuickSort extends SortBase {
	@Override
	public SortResponse sort(int[] _vetor) {
		SortResponse resp = new SortResponse();
		int[] vetor = _vetor.clone();
		resp.startTimer();
		quickSort(vetor, 0, _vetor.length - 1);
		resp.endTimer();
		return resp;
	}

	private void quickSort(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private int separar(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
}
