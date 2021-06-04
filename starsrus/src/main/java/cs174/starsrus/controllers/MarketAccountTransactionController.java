package cs174.starsrus.controllers;

import java.util.List;

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

import cs174.starsrus.entities.Deposit;
import cs174.starsrus.repositories.WithdrawRepository;
import cs174.starsrus.repositories.DepositRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class MarketAccountTransactionController {

    @Autowired
    private DepositRepository depositRepository;

    @GetMapping("myaccount")
    public List<Deposit> getMarketHistory() {
        return this.depositRepository.MarketTransactionHistory();
    }
}
