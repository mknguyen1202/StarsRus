package cs174.starsrus.entities;

public class StockMarket {
    
//     CREATE TABLE IF NOT EXISTS StockMarket(
//     stocktime TEXT,
//     current_price REAL,
//     closing_price REAL,
//     symbol CHAR(3),
//     PRIMARY KEY (symbol, stocktime),
//     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
//         ON UPDATE CASCADE
//         ON DELETE CASCADE
// );

    private String stocktime;
    private double current_price;
    private double closing_price;
    private String symbol;

	public String getStocktime() {
		return this.stocktime;
	}

	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}

	public double getCurrent_price() {
		return this.current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	public double getClosing_price() {
		return this.closing_price;
	}

	public void setClosing_price(double closing_price) {
		this.closing_price = closing_price;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}




}
