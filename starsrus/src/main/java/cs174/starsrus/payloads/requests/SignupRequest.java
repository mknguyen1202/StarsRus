package cs174.starsrus.payloads.requests;

import java.util.Set;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


public class SignupRequest {

    // String username, 
    // String password, 
    // String firstname,
    // String lastname,
    // String DOB,
    // String address,
    // String state,
    // String phone,
    // String email,
    // String ssn,
    // LocalDate registration_date,
    // double net_balance

    @NotBlank
    @Size(min = 3, max = 30)
    private String username;

    @NotBlank
    @Size(min = 6, max = 30)
    private String password;
 
    private Set<String> role;
    

    @NotBlank
    @Size(max = 30)
    private String firstname;

    @NotBlank
    @Size(max = 30)
    private String lastname;

    @NotBlank
    private String dob;

    @NotBlank
    @Size(max = 50)
    private String address;

	@NotBlank
	@Size(max = 2)
	private String state;
	
	@NotBlank
	@Size(max = 15)
	private String phone;
	
	@NotBlank
	@Size(max = 254)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 9)
	private String ssn;

	@NotBlank
    private LocalDateTime registration_date;
    
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public LocalDateTime getRegistration_date() {
		return this.registration_date;
	}

	public void setRegistration_date(LocalDateTime registration_date) {
		this.registration_date = registration_date;
	}


  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}