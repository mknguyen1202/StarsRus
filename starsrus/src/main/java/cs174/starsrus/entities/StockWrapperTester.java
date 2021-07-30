package cs174.starsrus.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cs174.starsrus.util.StockUtil;

public class StockWrapperTester {

    private String ticker;
    private double price;
    private String company;
    private LocalDateTime lastAccessed;
    private List<ArrayList<Double>> history;


    public StockWrapperTester(String ticker) {
        this.ticker = ticker;
        this.price = 0.0f;
        this.company = "Intel Inc.";
        lastAccessed = LocalDateTime.now();
        history = new ArrayList<>();
    }

    public StockWrapperTester(String ticker, double price, String company) {
        this.ticker = ticker;
        this.price = price;
        this.company = company;
        lastAccessed = LocalDateTime.now();
        history = new ArrayList<>();
    }
    

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return getHistory().get(0).get(0);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getLastAccessed() {
        return this.lastAccessed;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public List<ArrayList<Double>> getHistory() {
        BigDecimal price = new BigDecimal(80);
        this.history = StockUtil.generateHistoryQuotesOneDay(price, 10.0f);
        return this.history;
    }

    public void setHistory(List<ArrayList<Double>> history) {
        this.history = history;
    }
}
