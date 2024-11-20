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

	public static Flight getFlightByDate(LocalDate date) {
		for (Day day : allDays) {
			if (day.getDate().isEqual(date)) {
				return day.getFlight();
			}
		}
		return null;
	}
}
