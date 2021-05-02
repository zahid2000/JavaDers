package interfaces;

public class Main {

	public static void main(String[] args) {
		Logger[] loggers= {new SmsLogger(),new DatabaseLogger(),new EmailLogger()};
		CustomerManager customerManager=new CustomerManager(loggers);

		Customer zahid=new Customer(1,"Zahid","Mamedov");
		customerManager.add(zahid);
	}

}
