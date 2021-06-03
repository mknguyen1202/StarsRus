package cs174.starsrus.entities;


public class Sell {

    private int sell_id;
    private String sell_date;
    private float sell_shares;
    private float earnings_from_sale;
    private String username;
    private String symbol;


     public Sell(){}


    public int get_sell_id() {
        return sell_id;
    }

    public void set_sell_id(int id) {
		this.sell_id = id;
	}

    public String get_sell_date() {
        return sell_date;
    }

    public void set_sell_date(String date) {
		this.sell_date = date;
	}

    public float get_sell_shares() {
        return sell_shares;
    }

    public void set_sell_shares(float shares) {
		this.sell_shares = shares;
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

    public String get_earnings_from_sale() {
        return earnings_from_sale;
    }

    public void set_earnings_from_sale(String earnings) {
		this.earnings_from_sale = earnings;
    }    
}
