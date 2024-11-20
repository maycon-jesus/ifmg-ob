package UI;

import Methods.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TicketSeller {
	private final Day[] allDays;

	TicketSeller(Day[] allDays) {
		this.allDays = allDays;
		promptCustomerInfos();
		promptCustomerSeatInfo();
	}

	private Customer promptCustomerInfos() {
		System.out.print("====[Informações do passageiro]====");

		System.out.print("Nome do passageiro: ");
		String customerName = Operator.scanner.next();
		Customer customer = Customers.getCustomerByName(customerName);
		if (customer != null) {
			return customer;
		}

		System.out.print("Email: ");
		String customerEmail = Operator.scanner.next();

		System.out.print("Endereço: ");
		String customerAddress = Operator.scanner.next();

		System.out.print("Data de nascimento (dd/mm/yyyy): ");
		String customerBirthDate = Operator.scanner.next();
		LocalDate customerBirthDateConverted = LocalDate.parse(customerBirthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		System.out.print("Comorbidades(s/n): ");
		String customerComorbidities = Operator.scanner.next();
		Boolean customerComorbiditiesConverted = customerComorbidities.equals("s");
		Customer nCustomer = new Customer(customerName, customerEmail, customerAddress, customerBirthDateConverted, customerComorbiditiesConverted);
		Customers.addCustomer(nCustomer);
		return nCustomer;
	}


	private Seat promptCustomerSeatInfo() {
		System.out.println("====[Informações do voo]====");
		System.out.print("Data do voo (dd/mm/yyyy): ");
		String flightDate = Operator.scanner.next();
		LocalDate flightDateConverted = LocalDate.parse(flightDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Flight flight = Company.getFlightByDate(flightDateConverted);
		if (flight == null) {
			System.out.println("Não possuímos voo nesta data.");
			return promptCustomerSeatInfo();
		}

		System.out.println("Selecione um assento disponível:");
		return null;
	}
}
