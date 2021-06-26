package cs174.starsrus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.entities.Customer;
import cs174.starsrus.repositories.LoginRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class LoginController {

    @Autowired
    LoginRepository loginRepository;
    
    @GetMapping("login/{username}")
    public Customer getCustomerByUsername(@PathVariable(value="username") String username) {
        // return this.loginRepository.findByUsername(username, password);
        System.out.println("IN LOGIN CONTROLLER: " + username);
        return this.loginRepository.findByUsername(username);
    }
}
