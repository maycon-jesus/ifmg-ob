package Methods;

import java.util.ArrayList;

public class Flight {
	private final Seat[][] seats = new Seat[12][4];

	Flight() {

//        Define os ids dos assentos. Ex. 1A, 1B, 2A.
		for (int i = 0; i < seats.length; i++) {

			Seat[] line = seats[i];
			for (int j = 0; j < line.length; j++) {
				double price = 0.0;
				if (j == 0) {
					price = 850;
				} else if (j == 2) {
					price = 550;
				} else if (j == 3) {
					price = 720;
				}

//                Bloqueia a coluna B
				Boolean seatBlocked = j == 1;
				line[j] = new Seat(String.valueOf(i + 1) + intToAlphabet(j), seatBlocked, price);
			}
		}
	}

	private String intToAlphabet(int num) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(num, num + 1);
	}

	public ArrayList<Seat> getSeatsByBusyStatus(Boolean busy) {
		ArrayList<Seat> nList = new ArrayList<>();
		for (Seat[] line : seats) {
			for (Seat seat : line) {
				if (busy && !seat.isEmpty()) {
					nList.add(seat);
				}

				if (!busy && seat.isEmpty()) {
					nList.add(seat);
				}
			}
		}

		return nList;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public Seat getSeatById(String seatId) throws CustomError {
		for (Seat[] line : seats) {
			for (Seat seat : line) {
				if (seat.getSeatId().equals(seatId)) {
					return seat;
				}
			}
		}
		throw new CustomError("Assento inválido!");
	}

	public void newTicket(Customer customer, Seat seat) throws CustomError {
		if (customer == null) throw new CustomError("Methods.Passenger is null!");
		if (!seat.isBlocked()) {
			throw new CustomError("Assento bloqueado!");
		}
		if (!seat.isEmpty()) {
			throw new CustomError("Assento já está ocupado!");
		}
		seat.setPassenger(customer);
	}
}
