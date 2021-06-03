package cs174.starsrus.entities;


public class ActorStock {



    public ActorStock() {

    }

    private String symbol;
    private String actor_name;
    private String actor_dob;


	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getActor_name() {
		return this.actor_name;
	}

	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}

	public String getActor_dob() {
		return this.actor_dob;
	}

	public void setActor_dob(String actor_dob) {
		this.actor_dob = actor_dob;
	}

}
