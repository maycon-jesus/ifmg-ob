package SortMethods;

import java.util.Stack;

public class QuickSort extends SortBase {
	@Override
	public SortResponse sort(int[] _vetor) {
		SortResponse resp = new SortResponse();
		int[] vetor = _vetor.clone();
		resp.startTimer();
		iterativeQuickSort(vetor, 0, _vetor.length - 1);
		resp.endTimer();
		return resp;
	}

	private void iterativeQuickSort(int[] vetor, int inicio, int fim) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{inicio, fim});

		while (!stack.isEmpty()) {
			int[] range = stack.pop();
			int low = range[0], high = range[1];
			if (low < high) {
				int posicaoPivo = separar(vetor, low, high);
				stack.push(new int[]{low, posicaoPivo - 1});
				stack.push(new int[]{posicaoPivo + 1, high});
			}
		}
	}

	private int separar(int[] vetor, int inicio, int fim) {
		int pivo = (vetor[inicio] + vetor[fim]) / 2;
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
