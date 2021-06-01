package cs174.starsrus.entities;


public class Stock {
    
    private String symbol;
    private Float closingPrice;
    private Float currentPrice;

    private Actor actor;

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Float getClosingPrice() {
		return this.closingPrice;
	}

	public void setClosingPrice(Float closingPrice) {
		this.closingPrice = closingPrice;
	}

	public Float getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}


}
