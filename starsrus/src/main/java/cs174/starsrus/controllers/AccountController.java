package cs174.starsrus.controllers;

import java.util.ArrayList;

import cs174.starsrus.entities.MarketAccount;
import cs174.starsrus.entities.StockAccount;

public class AccountController {
    private MarketAccount marketAccount;
    private ArrayList<StockAccount> stockAccounts;

    public MarketAccount getMarketAccount() {
        return marketAccount;
    }
    public void setMarketAccount(MarketAccount marketAccount) {
        this.marketAccount = marketAccount;
    }

    public ArrayList<StockAccount> getStockAccounts() {
        return stockAccounts;
    }

    public void setStockAccounts(ArrayList<StockAccount> stockAccounts) {
        this.stockAccounts = stockAccounts;
    }

}
