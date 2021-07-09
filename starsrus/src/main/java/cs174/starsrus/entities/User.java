package cs174.starsrus.entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;



@Entity
@Table(	name = DBTables.TABLE_USER.TABLENAME, 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = DBTables.TABLE_USER.ATTR_USERNAME),
			@UniqueConstraint(columnNames = DBTables.TABLE_USER.ATTR_EMAIL) 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 30)
	private String username;

	@NotBlank
	@Size(max = 120)
	private String password;

	@NotBlank
	@Size(max = 30)
	private String firstname;

	@NotBlank
	@Size(max = 30)	
	private String lastname;

	@NotBlank
	private String dob;

	@NotBlank
	@Size(max = 70)
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
	
	private String registration_date;

	@Min(0)
	private double net_balance;




	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = DBTables.TABLE_USER_ROLE.TABLENAME, 
				joinColumns = @JoinColumn(name = DBTables.TABLE_USER_ROLE.ATTR_USER_ID), 
				inverseJoinColumns = @JoinColumn(name = DBTables.TABLE_USER_ROLE.ATTR_ROLE_ID))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, 
				String password, 
				String firstname,
				String lastname,
				String dob,
				String address,
				String state,
				String phone,
				String email,
				String ssn) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					this.username = username;
					this.password = password;
					this.firstname = firstname;
					this.lastname = lastname;
					this.dob = dob;
					this.address = address;
					this.state = state;
					this.phone = phone;
					this.email = email;
					this.ssn = ssn;
					this.registration_date = LocalDateTime.now().format(formatter);
					this.net_balance = 0;
				}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


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

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRegistration_date() {
		return this.registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public double getNet_balance() {
		return this.net_balance;
	}

	public void setNet_balance(double net_balance) {
		this.net_balance = net_balance;
	}


	/**
	 * 
{
  "username": "user1",
  "password": "password1",
  "firstname": "firstname1",
  "lastname": "lastname1",
  "dob":"1990-01-01",
  "address":"1010 Holister, Apartment 110",
  "state":"CA",
  "phone":"0123456789",
  "email": "user1@gmail.com",
  "ssn": "123456789",
  "role": ["mod", "user"]
}
	 */
}
