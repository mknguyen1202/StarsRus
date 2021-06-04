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

import cs174.starsrus.entities.Deposit;
import cs174.starsrus.repositories.DepositRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class DepositController {
    @Autowired
    private DepositRepository depositRepository;

    @GetMapping("deposit")
    public List<Deposit> getDeposits() {
        return this.depositRepository.findAll();
    }

    @GetMapping("deposit/{deposit_id}")
    public Deposit getDepositByUsername(@PathVariable(value="deposit_id") int deposit_id) {
        return this.depositRepository.findByDepositID(deposit_id);
    }

    @PostMapping("add_deposit")
    public int createDeposit(@RequestBody Deposit deposit) {
        return this.depositRepository.create(deposit);
    }

    @DeleteMapping("deposit/{deposit_id}")
    public int deleteDeposit(@PathVariable(value="deposit_id") int deposit_id) {
        return this.depositRepository.deleteByDepositID(deposit_id);
    }

    @PutMapping("add_deposit")
    public int updateDeposit(@RequestBody Deposit deposit){
        // System.out.println("---------------USERNAME HERE: " + deposit.getDeposit_username());
        return this.depositRepository.update(deposit);
    }
}
