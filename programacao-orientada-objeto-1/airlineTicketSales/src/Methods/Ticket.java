package Methods;

import java.time.Period;

public class Ticket {
	public Flight flight;
	public Seat seat;
	private double subtotal = 0;
	private double discount = 0;
	private double discountPercent = 0;

	Ticket(Flight flight, Seat seat, Customer customer){
		this.flight=flight;
		this.seat=seat;
		this.subtotal=seat.getOriginalPrice();

//		Comorbidades
		if(customer.getComorbidities()) {
			discountPercent+= 0.15;
		};

//		Aniversario
		int currentDay = Company.currentDay.getDayOfMonth();
		int currentMonth = Company.currentDay.getMonthValue();

		int customerBirthDay = customer.getBirthDate().getDayOfMonth();
		int customerBirthMonth = customer.getBirthDate().getMonthValue();
		if(currentDay == customerBirthDay && currentMonth == customerBirthMonth){
			discountPercent+= 0.05;
		}

//		Idoso
		Period period = Period.between(Company.currentDay, customer.getBirthDate());
		if(period.getYears() >= 60){
			discountPercent+= 0.05;
		}

//		Cliente fiel
		discountPercent+= customer.getFlightsCurrentMonth()>8? 8*0.05:customer.getFlightsCurrentMonth()*0.05;

		discount=this.subtotal*discountPercent;
	}

	public double getTotal(){
		return subtotal-discount;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getDiscount() {
		return discount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}
}
