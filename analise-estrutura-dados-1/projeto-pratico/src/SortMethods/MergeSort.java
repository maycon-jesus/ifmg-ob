package SortMethods;

import java.util.Arrays;

public class MergeSort extends SortBase {

	// Função para mesclar dois arrays ordenados
	private static void merge(int[] vetor, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

		// Mesclar os dois arrays em um único array ordenado
		while ((i < left.length) && (j < right.length)) {
			if (left[i] <= right[j]) {
				vetor[k++] = left[i++];
			} else {
				vetor[k++] = right[j++];
			}
		}

		// Se ainda houver elementos no array 'left', adiciona-os ao array 'array'
		while (i < left.length) {
			vetor[k++] = left[i++];
		}

		// Se ainda houver elementos no array 'right', adiciona-os ao array 'array'
		while (j < right.length) {
			vetor[k++] = right[j++];
		}
	}

	private int[] mergeSort(int[] vetor) {
		if (vetor.length < 2) {
			return vetor; // Caso base: o array já está ordenado
		}

		// Dividir o array ao meio
		int mid = vetor.length / 2;
		int[] left = Arrays.copyOfRange(vetor, 0, mid);
		int[] right = Arrays.copyOfRange(vetor, mid, vetor.length);

		// Recursivamente ordenar as metades
		sort(left);
		sort(right);

		// Mesclar as metades ordenadas
		merge(vetor, left, right);
		return vetor;
	}

	// Função principal para ordenar o array
	public SortResponse sort(int[] _vetor) {
		SortResponse resp = new SortResponse();
		int vetor[] = _vetor.clone();

		resp.startTimer();
		this.mergeSort(vetor);
		resp.endTimer();
		resp.setFinalVector(vetor);
		return resp;
	}
}
