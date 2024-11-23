package Methods;

import java.time.LocalDate;

public class Day {
	private final Flight flight = new Flight(this);
	private final LocalDate date;
	private boolean past = false;

	Day(LocalDate date) {
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setPast() {
		this.past = true;
	}

	public boolean getPast() {
		return this.past;
	}
}
