package cs174.starsrus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.entities.Customer;
import cs174.starsrus.repositories.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("customer")
    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }
}
