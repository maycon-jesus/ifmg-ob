package Utils;

import java.util.Scanner;

public class Input {
	public static Scanner scanner = new Scanner(System.in);

	public static int inputMenu(int min, int max) {
		int value = scanner.nextInt();
		while (value < min || value > max) {
			System.out.println("Valor invalido");
			value = scanner.nextInt();
		}
		return value;
	}
}
