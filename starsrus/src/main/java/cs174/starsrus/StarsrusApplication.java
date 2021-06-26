package cs174.starsrus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cs174.starsrus.controllers.CustomerController;
import cs174.starsrus.controllers.SystemDateController;
import cs174.starsrus.entities.Customer;
import cs174.starsrus.repositories.CustomerRepository;
import cs174.starsrus.repositories.SystemDateRepository;

@SpringBootApplication
public class StarsrusApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StarsrusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// customerRepository.findAll();
		// for (Customer : customerRepository.findAll()) {

		// }
		// System.out.println(customerRepository.findAll());
		System.out.println("NUMBER OF DAYS: " + Util.numDaysInMonth(2021, 6));

		String DEFAULT_DATE = "DATE('now')";
		// SystemDateController sDateController = new SystemDateController();
		// sDateController.getSystemDateRepository().addDefaultSystemDate(DEFAULT_DATE);
		// Util.addDefaultSystemDate(DEFAULT_DATE);

	}

}
