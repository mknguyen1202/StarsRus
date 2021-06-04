package cs174.starsrus.entities;


public class Sell {

    private int sell_id;
    private String sell_date;
    private double sell_shares;
    private double earnings_from_sale;
    private String username;
    private String symbol;


     public Sell(){}


    public double getEarnings_from_sale() {
        return earnings_from_sale;
    }


    public void setEarnings_from_sale(double earnings_from_sale) {
        this.earnings_from_sale = earnings_from_sale;
    }


    public double getSell_shares() {
        return sell_shares;
    }


    public void setSell_shares(double sell_shares) {
        this.sell_shares = sell_shares;
    }


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
