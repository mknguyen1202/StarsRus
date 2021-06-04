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

import cs174.starsrus.entities.Withdraw;
import cs174.starsrus.repositories.WithdrawRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class WithdrawController {
    @Autowired
    private WithdrawRepository withdrawRepository;

    @GetMapping("withdraw")
    public List<Withdraw> getWithdraws() {
        return this.withdrawRepository.findAll();
    }

    @GetMapping("withdraw/{withdraw_id}")
    public Withdraw getWithdrawByUsername(@PathVariable(value="withdraw_id") int withdraw_id) {
        return this.withdrawRepository.findByWithdrawID(withdraw_id);
    }

    @PostMapping("add_withdraw")
    public int createWithdraw(@RequestBody Withdraw withdraw) {
        return this.withdrawRepository.withdraw(withdraw);
    }

    @DeleteMapping("withdraw/{withdraw_id}")
    public int deleteWithdraw(@PathVariable(value="withdraw_id") int withdraw_id) {
        return this.withdrawRepository.deleteByWithdrawID(withdraw_id);
    }

    @PutMapping("add_withdraw")
    public int updateWithdraw(@RequestBody Withdraw withdraw){
        // System.out.println("---------------USERNAME HERE: " + withdraw.getWithdraw_username());
        return this.withdrawRepository.update(withdraw);
    }
}
