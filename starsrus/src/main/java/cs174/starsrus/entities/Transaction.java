package cs174.starsrus.entities;

import java.sql.Date;

public interface Transaction<T> {
    
    public void deposit(T transaction_amount);
    public void getDate(Date date);
    
}
