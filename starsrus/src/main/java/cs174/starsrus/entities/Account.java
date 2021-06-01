package cs174.starsrus.entities;

import java.math.BigDecimal;
import java.util.Date;


public class Account {
    //TODO
    // Add column annotations

    private int id;
    private String username;
	private BigDecimal balance; // NUMERIC in Database
	private Date createdDate;


	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
