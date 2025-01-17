package UI;

import Methods.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TicketSeller {
	static void sell() {
		Customer customer = promptCustomerInfos();
		Methods.Flight flight = promptCustomerFlightInfo(customer);
		Seat seat = promptCustomerSeatInfo(flight);
		Ticket ticket = Company.quotationTicket(flight, seat, customer);
		boolean confirmedSell = confirmTicketQuotation(ticket);
		if (confirmedSell) {
			sell(ticket);
		} else {
			System.out.println("Venda cancelada!!!");
		}
	}

	static private void sell(Ticket ticket) {
		Company.ticketSellConfirmed(ticket);
	}

	static private boolean confirmTicketQuotation(Ticket ticket) {
		System.out.println("====[DADOS DO PASSAGEIRO]====");
		System.out.println("Nome: " + ticket.customer.getName());
		System.out.println("Data de nascimento: " + ticket.customer.getBirthDate() + "(" + ticket.customer.getAge() + " anos)");
		System.out.println("Email: " + ticket.customer.getEmail());
		System.out.println("Endereço: " + ticket.customer.getAddress());
		System.out.println("Possui comorbidades: " + (ticket.customer.getComorbidities() ? "Sim" : "Não"));

		System.out.println("====[DADOS DO VOO]====");
		System.out.println("Data: " + ticket.flight.getDate());
		System.out.println("Assento: " + ticket.customer.getName());


		System.out.println("====[RESUMO DO PEDIDO]====");
		System.out.println("Subtotal: R$ " + ticket.getSubtotal());
		System.out.println("Descontos: R$ " + ticket.getDiscount());
		System.out.println("Total: R$ " + ticket.getTotal());

		System.out.print("Confirmar venda (s/n)? ");

		return Operator.scanner.next().equals("s");
	}

	static private Customer promptCustomerInfos() {
		System.out.print("====[Informações do passageiro]====\n");

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

	static private Methods.Flight promptCustomerFlightInfo(Customer customer) {
		System.out.println("====[Informações do voo]====");
		System.out.print("Data do voo (dd/mm/yyyy): ");
		String flightDate = Operator.scanner.next();
		LocalDate flightDateConverted = LocalDate.parse(flightDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Methods.Flight flight = Company.getFlightByDate(flightDateConverted);
		if (flight == null) {
			System.out.println("Não possuímos voo nesta data.");
			return promptCustomerFlightInfo(customer);
		}
		if (flight.getDay().getPast()) {
			System.out.println("Não é possivel viajar no tempo para voar em um voo ja realizado!!!");
			return promptCustomerFlightInfo(customer);
		}
		if (flight.customerAlreadyHasTicket(customer)) {
			System.out.println("Você não pode ter duas passagens no mesmo voo!!!");
			return promptCustomerFlightInfo(customer);
		}
		return flight;
	}


	static private Seat promptCustomerSeatInfo(Methods.Flight flight) {
		Flight.printFlightSeats(flight);
		System.out.println("Selecione um assento disponível (ex: 11C):");
		String seatId = Operator.scanner.next().toUpperCase();
		Seat seat = null;
		try {
			seat = flight.getSeatById(seatId);
		} catch (CustomError err) {
			System.out.println(err.message);
			return promptCustomerSeatInfo(flight);
		}
		if (seat.getPassenger() != null) {
			System.out.println("Este assento ja possui um passageiro!!!");
			return promptCustomerSeatInfo(flight);
		}
		return seat;
	}
}
