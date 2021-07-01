package cs174.starsrus.security.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cs174.starsrus.entities.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;
	private String firstname;
	private String lastname;
	private String DOB;
	private String address;
	private String state;
	private String phone;
	private String registration_date;
	private double net_balance;



	private String email;


	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id,
							String username, 
							String password,
							String firstname,
							String lastname,
							String DOB,
							String address,
							String state,
							String phone,
							String email,
							String ssn,
							String registration_date,
							double net_balance,
							
			Collection<? extends GrantedAuthority> authorities) {
		// this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(),
				user.getUsername(), 
				user.getPassword(),
				user.getFirstname(),
				user.getLastname(),
				user.getDOB(),
				user.getAddress(),
				user.getState(),
				user.getPhone(),
				user.getEmail(),
				user.getSsn(),
				user.getRegistration_date(),
				user.getNet_balance(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	public String getDOB() {
		return this.DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
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

	public String getRegistration_date() {
		return this.registration_date;
	}

	public void setRegistration_date(LocalDate registration_date) {
		this.registration_date = registration_date.toString();
	}

	public double getNet_balance() {
		return this.net_balance;
	}

	public void setNet_balance(double net_balance) {
		this.net_balance = net_balance;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
