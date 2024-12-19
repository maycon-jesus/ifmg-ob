import java.util.Arrays;

public class MergeSort {

	// Função principal para ordenar o array
	public static SortResponse sort(int[] array) {
		SortResponse resp = new SortResponse();

		if (resp.incrementInteraction()&&array.length < 2) {
			return resp; // Caso base: o array já está ordenado
		}

		// Dividir o array ao meio
		int mid = array.length / 2;
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);

		// Recursivamente ordenar as metades
		sort(left);
		sort(right);

		// Mesclar as metades ordenadas
		merge(resp,array, left, right);
		resp.setFinalVector(array);
		return resp;
	}

	// Função para mesclar dois arrays ordenados
	private static void merge(SortResponse resp,int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

		// Mesclar os dois arrays em um único array ordenado
		while ((resp.incrementInteraction() && i < left.length) && (resp.incrementInteraction()&&j < right.length)) {
			if (resp.incrementInteraction() &&left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}

		// Se ainda houver elementos no array 'left', adiciona-os ao array 'array'
		while (resp.incrementInteraction() && i < left.length) {
			array[k++] = left[i++];
		}

		// Se ainda houver elementos no array 'right', adiciona-os ao array 'array'
		while (resp.incrementInteraction() && j < right.length) {
			array[k++] = right[j++];
		}
	}
}
