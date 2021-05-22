package cs174.starsrus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer {
    @Column(name = "")
    private String username;

    @Column(name = "")
    private String password;

    @Column(name = "")
    private String name;
    private String state;
    private String phoneNumber;
    private String email;
    private String TID;

    public Customer() {
        
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTID() {
		return this.TID;
	}

	public void setTID(String TID) {
		this.TID = TID;
	}




}
