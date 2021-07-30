package cs174.starsrus.entities;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cs174.starsrus.entities.DBTables.TABLE_USER_WATCH_LIST;

public class UserWatchList {
    
    
    private String symbol;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = TABLE_USER_WATCH_LIST.ATTR_USER_ID, nullable = false)
    private User user;


    public UserWatchList() {
        
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
}
