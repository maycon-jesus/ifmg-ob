package Methods;

public class Seat {
	private final String seatId;
	private Customer customer;
	private Boolean useBlocked;
	private double originalPrice;

	Seat(String seatId, Boolean useBlocked, double originalPrice) {
		this.seatId = seatId;
		this.useBlocked = useBlocked;
		this.originalPrice = originalPrice;
	}

	public String getSeatId() {
		return this.seatId;
	}

	public Boolean isBlocked() {
		return this.useBlocked;
	}

	public Boolean isEmpty() {
		return this.customer == null;
	}

	public Customer getPassenger() {
		return this.customer;
	}

	public Boolean setPassenger(Customer customer) {
		if (this.useBlocked) {
			return false;
		}
		this.customer = customer;
		return true;
	}
}
