package cs174.starsrus.entities;


public class Withdraw {

    private int withdraw_id;
    private String withdraw_date;
    private double withdraw_amount;
    private String username;


     public Withdraw(){}


    public double getWithdraw_amount() {
        return withdraw_amount;
    }


    public void setWithdraw_amount(double withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }


    public int get_withdraw_id() {
        return withdraw_id;
    }

    public void set_withdraw_id(int id) {
		this.withdraw_id = id;
	}

    public String get_withdraw_date() {
        return withdraw_date;
    }

    public void set_withdraw_date(String date) {
		this.withdraw_date = date;
	}



    public String get_username() {
        return username;
    }

    public void set_username(String name) {
		this.username = name;
	}
}
