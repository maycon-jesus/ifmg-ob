public class Main {
	static int currentAux = 0;
	static int currentI=0;
	static int currentJ=0;

	public static void printStatus(){
		System.out.println("| "+Main.currentAux+" | "+Main.currentI+" | "+Main.currentJ+" |");
	}

	public static void changeAux(int aux){
		currentAux = aux;
		Main.printStatus();
	}

	public static void changeI(int i){
		currentI = i;
		Main.printStatus();
	}

	public static void changeJ(int j){
		currentJ = j;
	}

	public static void quickSort(int[] A, int p, int r){
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}

	public static int partition (int[] A, int p, int r){
		int aux, pivo = A[r], i = p-1;
		changeI(i);
		for (int j = p; j <= r - 1; j++) {
			changeJ(j);
			if (A[j] <= pivo) {
				i = i + 1;
				changeI(i);

				aux = A[i];
				changeAux(aux);

				A[i] = A[j];
				A[j] = aux;
			}
		}
		aux = A[i+1];
		changeAux(aux);

		A[i+1] = A[r];
		A[r] = aux;
		return i + 1;
	}

	public static void main(String[] args) {
		quickSort(new int[]{2,8,7,1,3,6},0,5);
	}

}
