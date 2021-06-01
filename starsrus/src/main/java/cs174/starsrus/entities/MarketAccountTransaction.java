package cs174.starsrus.entities;


public class MarketAccountTransaction extends Transaction {

    private final int DEPOSIT = 0;
    private final int WITHDRAW = 1;
    private int type;


    public MarketAccountTransaction(int type) {
        super();
        this.type = type;
    }

    

    
}
