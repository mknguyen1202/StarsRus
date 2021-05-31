package cs174.starsrus.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Actor {

	    /*
    ACTORID(STOCKID),CURRENTPRICE(3/16/2013),NAME,DOB,MovieTitle,Role,Year,Contract
    SKB,40.00,Kim Basinger,8 December 1958,L.A. Confidential,Actor,1997,5000000
    SMD,71.00,Michael Douglas,25 September 1944,A Perfect Murder,Actor,1998,10000000
    STC,32.50,Tom Cruise,3 July 1962,Jerry Maguire,Actor,1996,5000000
    */
    
    private int id;
    private String name;
    private Date DOB;
    private String role;
    private ArrayList<String> movie_titles;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return this.DOB;
	}

	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getMovie_titles() {
		return this.movie_titles;
	}

	public void setMovie_titles(ArrayList<String> movie_titles) {
		this.movie_titles = movie_titles;
	}


}
