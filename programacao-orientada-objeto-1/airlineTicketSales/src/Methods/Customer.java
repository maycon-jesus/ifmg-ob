package Methods;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Customer {
	private String name;
	private String email;
	private String address;
	private LocalDate birthDate;
	private Boolean comorbidities;
	private int flightsCurrentMonth = 0;

	public Customer(String name, String email, String address, LocalDate birthDate, Boolean Comorbidities) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthDate = birthDate;
		this.comorbidities = Comorbidities;
	}

	public String getName() {
		return name;
	}

	public Boolean getComorbidities() {
		return comorbidities;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getFlightsCurrentMonth() {
		return flightsCurrentMonth;
	}

	void incrementFlightsCurrentMonth(){
		flightsCurrentMonth++;
	}

	public int getAge(){
		LocalDate now = LocalDate.now();
		Period period = Period.between(this.birthDate, Company.currentDay);
		return period.getYears();
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
}
