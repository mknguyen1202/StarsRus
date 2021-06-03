package cs174.starsrus.entities;


public class MarketAccount {

    private int market_account_id;
    private float balance;
    private String balance_date;
    private String account_date;
    private String username;



    public int get_market_account_id() {
        return market_account_id;
    }

    public void set_market_account_id(int id) {
		this.market_account_id = id;
	}

    public float get_balance() {
        return balance;
    }

    public void set_balance(float bal) {
		this.balance = bal;
	}


    public String get_balance_date() {
        return balance_date;
    }

    public void set_balance_date(String date) {
		this.balance_date = date;
	}

    public String get_account_date() {
        return account_date;
    }

    public void set_account_date(String date) {
		this.account_date = date;
	}

    public String get_username() {
        return username;
    }

    public void set_username(String name) {
		this.username = name;
	}
}
