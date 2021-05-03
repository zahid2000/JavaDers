package interfaceAbstraactDemo;

import java.util.Date;

import abstracts.BaseCustomerManager;
import adapters.MernisServiceAdapter;
import concrete.NeroCustomerManager;
import concrete.StarbucksCustomerManager;
import entities.Customer;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		BaseCustomerManager customerManager = new NeroCustomerManager(new MernisServiceAdapter());
		Customer customer1 = new Customer(1, "Engin", "Demiroğ", new Date(1985, 2, 11), "12345678901");
		Customer customer2 = new Customer(2, "Bilge", "Yaşar", new Date(1998, 7, 29), "55544433322");
		Customer customer3 = new Customer(1,"Mustafa Ýlhan","Kaygusuz", new Date(2002, 06, 13),"52423156468");
			customerManager.save(customer3);

	}

}
