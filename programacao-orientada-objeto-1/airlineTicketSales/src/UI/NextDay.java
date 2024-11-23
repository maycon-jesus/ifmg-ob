package UI;

import Methods.Company;
import Methods.Customer;
import Methods.Day;
import Methods.Seat;

import java.util.ArrayList;

public class NextDay {
	static void next() {
		Day currentDay = Company.getCurrentDayInstance();
		ArrayList<Seat> seatsBusy = currentDay.getFlight().getSeatsByBusyStatus(true);
		if (seatsBusy.isEmpty()) {
			System.out.println("Voo cancelado por falta de passageiros!!!");
			nextCompanyDay();
			return;
		} else {
			System.out.println("Realizando VOO do dia: " + currentDay.getDate());
			System.out.println("Passageiros confirmados do dia em ordem de prioridde:");
			sortAndPrintSeats(seatsBusy);
			nextCompanyDay();
			return;
		}
	}

	private static void sortAndPrintSeats(ArrayList<Seat> seats) {
		for (int i = 0; i < seats.size(); i++) {
			Seat seatA = seats.get(i);
			Customer customerA = seatA.getPassenger();
			Seat bigger = seats.get(i);
			int biggerIndex = i;


			for (int j = i + 1; j < seats.size(); j++) {
				Seat seatB = seats.get(j);
				Customer customerB = seatB.getPassenger();

				if (customerA.getComorbidities() && !customerB.getComorbidities()) continue;
				if (!customerA.getComorbidities() && customerB.getComorbidities()) {
					bigger = seatB;
					biggerIndex = j;
					continue;
				}

				if (customerA.getAge() >= 60 && customerA.getAge() >= customerB.getAge()) continue;
				if (customerB.getAge() >= 60) {
					bigger = seatB;
					biggerIndex = j;
					continue;
				}

				if (customerA.isBirthDay() && !customerB.isBirthDay()) continue;
				if (!customerA.isBirthDay() && customerB.isBirthDay()) {
					bigger = seatB;
					biggerIndex = j;
					continue;
				}

				if (seatA.getBuyedTimestamp() > seatB.getBuyedTimestamp()) {
					bigger = seatB;
					biggerIndex = j;
					continue;
				}
			}

			//            Invertendo o seatA com o bigger que é o assento de maior importanci
//            Colocando bigger no começo
			seats.set(i, bigger);

//            Colocando seatA no lugar anterior do bigger
			seats.set(biggerIndex, seatA);

			System.out.println((i + 1) + " - " + bigger.getPassenger().getName());
		}
	}


	private static void nextCompanyDay() {
		Company.nextDay();
	}
}
