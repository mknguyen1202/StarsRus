package cs174.starsrus.entities;


public class ActorMovie {
    
//     CREATE TABLE IF NOT EXISTS ActorMovie (
//     contract_id INTEGER,
//     contract_year INTEGER,
//     actor_role CHAR(20),
//     title CHAR(20),
//     total_value REAL,
//     symbol INTEGER NOT NULL,
//     PRIMARY KEY (contract_id),
//     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
//         ON DELETE CASCADE
//         ON UPDATE CASCADE
// );

    private int contract_id;
    private int contract_year;
    private String actor_role;
    private String title;
    private double total_value;
    private String symbol;
    

	public int getContract_id() {
		return this.contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public int getContract_year() {
		return this.contract_year;
	}

	public void setContract_year(int contract_year) {
		this.contract_year = contract_year;
	}

	public String getActor_role() {
		return this.actor_role;
	}

	public void setActor_role(String actor_role) {
		this.actor_role = actor_role;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getTotal_value() {
		return this.total_value;
	}

	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
