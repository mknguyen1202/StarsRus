package cs174.starsrus.entities;


public class StockAccount {

    private String symbol;
    private float balance;
    private String original_buying_price;
    private String account_date;
    private String username;


     public StockAccount(){}


    public String get_symbol() {
        return symbol;
    }

    public void set_symbol(String sym) {
		this.symbol = sym;
	}

    public float get_balance() {
        return balance;
    }

    public void set_balance(float bal) {
		this.balance = bal;
	}


    public String get_original_buying_price() {
        return original_buying_price;
    }

    public void set_original_buying_price(String price) {
		this.original_buying_price = price;
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
