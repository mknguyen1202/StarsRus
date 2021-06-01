package cs174.starsrus.entities;

import java.math.BigDecimal;
import java.sql.Date;

public abstract class Transaction<T> {
    
    
    private int transaction_id;
    private BigDecimal transaction_amount;
    private Date transaction_datetime;
    
    public int getTransaction_id() {
        return transaction_id;
    }
    public Date getTransaction_datetime() {
        return transaction_datetime;
    }
    public void setTransaction_datetime(Date transaction_datetime) {
        this.transaction_datetime = transaction_datetime;
    }
    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }
    public void setTransaction_amount(BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
    
}
