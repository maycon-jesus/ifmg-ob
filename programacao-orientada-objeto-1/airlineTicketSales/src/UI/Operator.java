package UI;

import Methods.Company;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Operator {
	static public Scanner scanner = new Scanner(System.in);

	public void menu() {
		System.out.println("====[MENU]====");
		System.out.println("Bem vindo a NoisTropicaMaisNaoCai.");
		System.out.println("Hoje é dia: " + Company.currentDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Selecione a opção desejada: ");
		System.out.println("1 - Emitir passagem");
		System.out.println("2 - Realizar voo do dia");
		System.out.println("3 - Finalizar programa");
		int choice = scanner.nextInt();
		switch (choice) {
			case 1: {
				TicketSeller.sell();
				menu();
				break;
			}
			case 2: {
				NextDay.next();
				menu();
				break;
			}
			default: {
				System.out.println("Opção inválida!");
			}
			break;
		}
	}

	public void start() {
		menu();
	}
}
