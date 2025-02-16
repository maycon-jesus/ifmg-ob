package ui;

import Atendimento.Ficha;
import Usuarios.Paciente;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {
	public static Scanner sc = new Scanner(System.in);

	public static boolean promptBoolean(String prompt) {
		System.out.println(prompt + " (s/n)");
		String s = sc.nextLine();
		if (s.equals("s")) {
			return true;
		} else if (s.equals("n")) {
			return false;
		} else {
			return promptBoolean(prompt);
		}
	}

	public static LocalDate promptLocalDate(String prompt) {
		System.out.println(prompt + " (dd/mm/yyyy)");
		String s = sc.nextLine();
		String[] splitted = s.split("/");
		if (splitted.length != 3) return promptLocalDate(prompt);
		LocalDate localDate = LocalDate.of(Integer.parseInt(splitted[2]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[0]));
		return localDate;
	}

	public static String promptString(String prompt) {
		System.out.println(prompt);
		String s = sc.nextLine();
		if (s.isEmpty()) {
			return promptString(prompt);
		}
		return s;
	}

	public static double promptDouble(String prompt) {
		System.out.println(prompt);
		double d = sc.nextDouble();

		return d;
	}

	public static String promptSelectString(String prompt, String[] options) {
		System.out.println(prompt);
		for (int i = 0; i < options.length; i++) {
			System.out.println(i + " " + options[i]);
		}
		int s = sc.nextInt();
		if (s >= 0 && s < options.length) return options[s];
		return promptSelectString(prompt, options);
	}

	public static int promptIntFromRange(String prompt, int min, int max) {
		System.out.println(prompt);
		int s = sc.nextInt();
		if (s >= min && s <= max) return s;
		return promptIntFromRange(prompt, min, max);
	}

	public static int promptInt(String prompt) {
		System.out.println(prompt);
		int s = sc.nextInt();
		return s;
	}

	public static void appMenu() {
		System.out.println("1 - Cadastrar ficha");
		System.out.println("2 - Informações do paciente");
		System.out.println("3 - Realizar triagem do próximo paciente");
		System.out.println("4 - Chamar proximo paciente");
		System.out.println("5 - Cadastrar enfermeiro");
		System.out.println("6 - Cadastrar médico");
		System.out.println("0 - Encerrar");
		int menuOption = promptIntFromRange("Selecione uma opção: ", 0, 6);

		switch (menuOption) {
			case 1: {
				Paciente paciente = PessoaPrompts.criarPaciente();
				PessoaPrompts.criarFicha(paciente);
				break;
			}
			case 3: {
				Ficha ficha = FilaOperations.getNextFichaTriagem();
				if (ficha == null) {
					System.out.println("A recepção está vazia!!!");
				} else {
					Paciente paciente = ficha.getPaciente();
					ficha.setEmTriagem();
					System.out.println("Fazendo triagem do paciente: " + paciente.getNomeCompleto());
				}
				break;
			}

			case 5:
				PessoaPrompts.criarEnfermeiro();
				break;
			case 6:
				PessoaPrompts.criarMedico();
				break;
			case 0:
				System.exit(0);
				break;
		}
		appMenu();
	}
}
