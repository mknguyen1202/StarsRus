package cs174.starsrus.entities;


public class Deposit {

    private int deposit_id;
    private String deposit_date;
    private double deposit_amount;
    private String username;


     public Deposit(){}


    public double getDeposit_amount() {
        return deposit_amount;
    }


    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }


    public int get_deposit_id() {
        return deposit_id;
    }

    public void set_deposit_id(int id) {
		this.deposit_id = id;
	}

    public String get_deposit_date() {
        return deposit_date;
    }

    public void set_deposit_date(String date) {
		this.deposit_date = date;
	}



    public String get_username() {
        return username;
    }

    public void set_username(String name) {
		this.username = name;
	}
}
