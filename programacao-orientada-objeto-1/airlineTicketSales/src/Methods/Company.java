package Methods;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company {
	public static Day[] allDays = new Day[31];
	public static LocalDate currentDay = LocalDate.now();
	public static ArrayList<Customer> allCustomers = new ArrayList<>();

	public Company() {
		for (int i = 0; i < 31; i++) {
			if (allDays[i] != null) continue;
			allDays[i] = new Day(LocalDate.now().plusDays(i));
		}
	}

	public static Day getCurrentDayInstance() {
		for (int i = 0; i < 31; i++) {
			if (allDays[i] == null) continue;
			if (allDays[i].getDate().isEqual(currentDay)) {
				return allDays[i];
			}
		}
		return null;
	}

	public static void nextDay() {
		Day day = getCurrentDayInstance();
		if (day == null) return;
		day.setPast();
		currentDay = currentDay.plusDays(1);
		Day day2 = getCurrentDayInstance();
		if (day2 == null) System.exit(0);
	}

	public static Flight getFlightByDate(LocalDate date) {
		for (Day day : allDays) {
			if (day.getDate().isEqual(date)) {
				return day.getFlight();
			}
		}
		return null;
	}

	public static Ticket quotationTicket(Flight flight, Seat seat, Customer customer) {
		return new Ticket(flight, seat, customer);
	}

	public static void ticketSellConfirmed(Ticket ticket) {
		ticket.seat.setPassenger(ticket.customer);
		allCustomers.add(ticket.customer);
	}
}
