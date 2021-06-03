package cs174.starsrus.entities;

public class StockMarket {
    
    private String stocktime;
    private double current_price;
    private double closing_price;
    private String symbol;

	public String getStocktime() {
		return this.stocktime;
	}

	public void setStocktime(String time) {
		this.stocktime = time;
	}

	public double getCurrent_price() {
		return this.current_price;
	}

	public void setCurrent_price(double price) {
		this.current_price = price;
	}

	public double getClosing_price() {
		return this.closing_price;
	}

	public void setClosing_price(double price) {
		this.closing_price = price;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
