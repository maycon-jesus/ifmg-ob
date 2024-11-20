package Methods;

import java.time.LocalDate;

public class Day {
	private final Flight flight = new Flight();
	private LocalDate date;

	Day(LocalDate date) {
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public LocalDate getDate() {
		return date;
	}
}
