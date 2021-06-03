package cs174.starsrus.entities;


public class AccrueInterest {

    private int interest_id;
    private String interest_date;
    private float total_earnings;
    private String username;


     public AccrueInterest(){}


    public int get_interest_id() {
        return interest_id;
    }

    public void set_interest_id(int id) {
		this.interest_id = id;
	}

    public String get_interest_date() {
        return interest_date;
    }

    public void set_interest_date(String date) {
		this.interest_date = date;
	}

    public float get_total_earnings() {
        return total_earnings;
    }

    public void set_total_earnings(float amount) {
		this.total_earnings = amount;
	}

    public String get_username() {
        return username;
    }

    public void set_username(String name) {
		this.username = name;
	}
}
