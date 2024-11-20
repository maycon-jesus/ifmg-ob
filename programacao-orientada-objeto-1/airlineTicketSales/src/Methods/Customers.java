package Methods;

import java.util.ArrayList;

public class Customers {
	private static ArrayList<Customer> customers = new ArrayList<>();

	public static void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static Customer getCustomerByName(String name) {
		for (Customer c : customers) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
