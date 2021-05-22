package cs174.starsrus.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Account {
    //TODO
    // Add column annotations

    @Column(name = "")
    private int id;

    @Column(name = "")
    private String username;
    private BigDecimal balance; // NUMERIC in Database


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
