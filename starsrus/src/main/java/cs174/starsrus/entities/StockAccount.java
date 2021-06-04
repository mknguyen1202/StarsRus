package cs174.starsrus.entities;


public class StockAccount {

    private String symbol;
    private double balance;
    private double original_buying_price;
    private String account_date;
    private String username;


     public StockAccount(){}


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public double getOriginal_buying_price() {
        return original_buying_price;
    }


    public void setOriginal_buying_price(double original_buying_price) {
        this.original_buying_price = original_buying_price;
    }


    public String get_symbol() {
        return symbol;
    }

    public void set_symbol(String sym) {
		this.symbol = sym;
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
