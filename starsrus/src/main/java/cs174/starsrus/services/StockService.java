package cs174.starsrus.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce.Cluster.Refresh;
import org.springframework.stereotype.Service;

import cs174.starsrus.entities.StockWrapper;
import cs174.starsrus.entities.StockWrapperTester;
import yahoofinance.YahooFinance;

@Service
public class StockService {

    public static RefreshService refreshService;
    
    public StockWrapperTester findStock(String ticker) {
        // try {
        //     return new StockWrapper(YahooFinance.get(ticker));
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        // }

        try {
            return new StockWrapperTester(ticker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // public List<StockWrapper> findStocks(List<String> tickers) {
    //     return tickers.stream().map(this::findStock).filter(Objects::nonNull).collect(Collectors.toList());
    // }

    public BigDecimal findPrice(StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getPrice();
    }

    public BigDecimal findLastChangePercent(StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getChangeInPercent();
    }

    public BigDecimal findChangeFrom200MeanPercent(StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(refreshService.shouldRefresh(stock)).getChangeFromAvg200InPercent();
    }
    
}
