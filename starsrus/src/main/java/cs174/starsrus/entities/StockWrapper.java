package cs174.starsrus.entities;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import cs174.starsrus.util.Util;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockWrapper {

    private Stock stock;
    private LocalDateTime lastAccessed;

    public StockWrapper(Stock stock) {
        this.stock = stock;
        lastAccessed = LocalDateTime.now();
    }

    
    public Stock getStock() {
        return this.stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public LocalDateTime getLastAccessed() {
        return this.lastAccessed;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    // public List<BigDecimal> getTodayPriceHistory()  throws IOException {
    //     return getStock().getHistory(Util.getCalendarYesterday(), Util.getCalendarNow());
    // }

    public BigDecimal getPrice() {
        return getStock().getQuote().getPrice();
    }





}
