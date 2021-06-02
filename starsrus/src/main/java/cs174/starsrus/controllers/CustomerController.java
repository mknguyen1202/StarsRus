package cs174.starsrus.controllers;

import java.util.List;

import javax.annotation.security.RunAs;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("customer/{username}")
    public Customer getCustomerByUsername(@PathVariable(value="username") String username) {
        return this.customerRepository.findByUsername(username);
    }

    @PostMapping("add_customer")
    public int createCustomer(@RequestBody Customer customer) {
        return this.customerRepository.create(customer);
    }

    @DeleteMapping("customer/{username}")
    public int deleteCustomer(@PathVariable(value="username") String username) {
        return this.customerRepository.deleteByUsername(username.trim());
    }

    @PutMapping("add_customer")
    public int updateCustomer(@RequestBody Customer customer){
        // System.out.println("---------------USERNAME HERE: " + customer.getUsername());
        return this.customerRepository.update(customer);
    }
}
