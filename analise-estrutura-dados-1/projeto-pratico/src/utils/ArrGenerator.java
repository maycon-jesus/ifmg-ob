package utils;

import java.util.Random;

public class ArrGenerator {
	public static int[] randomNumbers(int qnt) {
		Random random = new Random();
		random.setSeed(2143658709);
		int[] arr = new int[qnt];
		for (int i = 0; i < qnt; i++) {
			arr[i] = random.nextInt();
		}
		return arr;
	}

	public static int[] ascNumbers(int qnt) {
		int[] arr = new int[qnt];
		for (int i = 0; i < qnt; i++) {
			arr[i] = i * 1000000000;
		}
		return arr;
	}

	public static int[] descNumbers(int qnt) {
		int[] arr = new int[qnt];
		for (int i = qnt - 1; i >= 0; i--) {
			arr[i] = i * 1000000000;
		}
		return arr;
	}
}
