package cs174.starsrus.entities;

public class UserAA {
	
}

// import java.sql.Date;
// import java.time.LocalDate;
// import java.util.HashSet;
// import java.util.Set;

// import javax.persistence.*;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;

// import org.springframework.lang.NonNull;

// import cs174.models.Role;


// @Entity
// @Table(name = DBTables.TABLE_USER.TABLENAME,
// 		uniqueConstraints = {
// 			@UniqueConstraint(columnNames=DBTables.TABLE_USER.ATTR_USERNAME),
// 			@UniqueConstraint(columnNames=DBTables.TABLE_USER.ATTR_EMAIL)
// 		})
// public class UserAA {

	
// 	@NotBlank
// 	@Size(max = 30)
// 	@Column(name = DBTables.TABLE_USER.ATTR_USERNAME, length = 30)
// 	private String username;
	
// 	@NotBlank
// 	@Size(max = 30)
// 	@Column(name = DBTables.TABLE_USER.ATTR_PASSWORD, length = 30)
// 	private String password;
	
// 	// @NotBlank
// 	// @Size(max = 30)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_FIRSTNAME, length = 30)
// 	// private String firstname;

// 	// @NotBlank
// 	// @Size(max = 30)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_LASTNAME, length = 30)
// 	// private String lastname;

// 	// @NotBlank
// 	// @Column(name = DBTables.TABLE_USER.ATTR_DOB, length = 30)
// 	// private String DOB;

// 	// @NotBlank
// 	// @Size(max = 70)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_ADDRESS, length = 70)
// 	// private String address;

// 	// @NotBlank
// 	// @Size(max = 2)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_STATE, length = 2)
// 	// private String state;
	
// 	// @NotBlank
// 	// @Size(max = 15)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_PHONE)
// 	// private String phone;
	
// 	@NotBlank
// 	// @Size(max = 254)
// 	@Email
// 	@Column(name = DBTables.TABLE_USER.ATTR_EMAIL, length = 254)
// 	private String email;
	
// 	// @NotBlank
// 	// // @Size(max = 9) 
// 	// @Column(name = DBTables.TABLE_USER.ATTR_SSN, length = 9)
// 	// private String ssn;

// 	// @NotBlank
// 	// @Column(name = DBTables.TABLE_USER.ATTR_REGISTRATION_DATE)
// 	// private String registration_date;

// 	// @Min(0)
// 	// @Column(name = DBTables.TABLE_USER.ATTR_NET_BALANCE)
// 	// private double net_balance;		// might limit to 10 mil

// 	@ManyToMany(fetch = FetchType.LAZY)
// 	@JoinTable( name = DBTables.TABLE_USER_ROLE.TABLENAME,
// 				joinColumns = @JoinColumn(name = DBTables.TABLE_USER_ROLE.ATTR_USERNAME),
// 				inverseJoinColumns = @JoinColumn(name = DBTables.TABLE_USER_ROLE.ATTR_ROLE_ID))
// 	private Set<Role> roles = new HashSet<>();


// 	public UserAA() {

// 	}

// 	public UserAA(String username, 
// 				String password, 
// 				String firstname,
// 				String lastname,
// 				String DOB,
// 				String address,
// 				String state,
// 				String phone,
// 				String email,
// 				String ssn,
// 				String registration_date) {
// 					this.username = username;
// 					this.password = password;
// 					// this.firstname = firstname;
// 					// this.lastname = lastname;
// 					// this.DOB = DOB;
// 					// this.address = address;
// 					// this.state = state;
// 					// this.phone = phone;
// 					this.email = email;
// 					// this.ssn = ssn;
// 					// this.registration_date = LocalDate.now().toString();
// 					// this.net_balance = 0;
// 				}

// 	public String getUsername() {
// 		return this.username;
// 	}

// 	public void setUsername(String username) {
// 		this.username = username;
// 	}

// 	public String getPassword() {
// 		return this.password;
// 	}

// 	public void setPassword(String password) {
// 		this.password = password;
// 	}

// 	// public String getFirstname() {
// 	// 	return this.firstname;
// 	// }

// 	// public void setFirstname(String firstname) {
// 	// 	this.firstname = firstname;
// 	// }

// 	// public String getLastname() {
// 	// 	return this.lastname;
// 	// }

// 	// public void setLastname(String lastname) {
// 	// 	this.lastname = lastname;
// 	// }

// 	// public String getDOB() {
// 	// 	return this.DOB;
// 	// }

// 	// public void setDOB(String DOB) {
// 	// 	this.DOB = DOB;
// 	// }

// 	// public String getAddress() {
// 	// 	return this.address;
// 	// }

// 	// public void setAddress(String address) {
// 	// 	this.address = address;
// 	// }

// 	// public String getState() {
// 	// 	return this.state;
// 	// }

// 	// public void setState(String state) {
// 	// 	this.slstate = state;
// 	// }

// 	// public String getPhone() {
// 	// 	return this.phone;
// 	// }

// 	// public void setPhone(String phone) {
// 	// 	this.phone = phone;
// 	// }

// 	public String getEmail() {
// 		return this.email;
// 	}

// 	public void setEmail(String email) {
// 		this.email = email;
// 	}

// 	// public String getSsn() {
// 	// 	return this.ssn;
// 	// }

// 	// public void setSsn(String ssn) {
// 	// 	this.ssn = ssn;
// 	// }

// 	// public String getRegistration_date() {
// 	// 	return this.registration_date;
// 	// }

// 	// public void setRegistration_date(LocalDate registration_date) {
// 	// 	this.registration_date = registration_date.toString();
// 	// }

// 	// public double getNet_balance(){
// 	// 	return this.net_balance;
// 	// }

// 	// public void setNet_balance(double net_balance) {
// 	// 	this.net_balance = net_balance;
// 	// }

// 	public Set<Role> getRoles() {
// 		return this.roles;
// 	}

// 	public void setRoles(Set<Role> roles) {
// 		this.roles = roles;
// 	}

// }
