package cs174.starsrus.entities;


public class Buy {

    private int buy_id;
    private String buy_date;
    private double buy_shares;
    private String username;
    private String symbol;


     public Buy(){}


    public double getBuy_shares() {
        return buy_shares;
    }


    public void setBuy_shares(double buy_shares) {
        this.buy_shares = buy_shares;
    }


    public int get_buy_id() {
        return buy_id;
    }

    public void set_buy_id(int id) {
		this.buy_id = id;
	}

    public String get_buy_date() {
        return buy_date;
    }

    public void set_buy_date(String date) {
		this.buy_date = date;
	}




    public String get_username() {
        return username;
    }

    public void set_username(String name) {
		this.username = name;
	}

    public String get_symbol() {
        return symbol;
    }

    public void set_symbol(String sym) {
		this.symbol = sym;
	}
}
