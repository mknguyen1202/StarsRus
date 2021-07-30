package cs174.starsrus.services;

import java.util.concurrent.ScheduledExecutorService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.stereotype.Service;

import cs174.starsrus.entities.StockWrapper;

@Service
public class RefreshService {

    public static final int UPDATE_TIME_PERIOD_IN_SECONDS = 15;
    public static final long  INITIAL_DELAY = 0;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Map<StockWrapper, Boolean> stocksToRefresh;
    private static final Duration refreshPeriod = Duration.ofSeconds(UPDATE_TIME_PERIOD_IN_SECONDS);

    public RefreshService() {
        stocksToRefresh = new HashMap<>();
    }

    public boolean shouldRefresh(StockWrapper stock) {
        if (!stocksToRefresh.containsKey(stock)) {
            stocksToRefresh.put(stock, false);
            return true;
        }
        return stocksToRefresh.get(stock);
    }

    public void setRefresh() {
        
        scheduler.scheduleAtFixedRate(() -> 
        stocksToRefresh.forEach((stock, value) -> {
            if (stock.getLastAccessed().isBefore(LocalDateTime.now().minus(refreshPeriod))) {
                System.out.println("Setting should refresh " + stock.getStock().getSymbol());
                stocksToRefresh.remove(stock);
                stock.setLastAccessed(LocalDateTime.now());
                stocksToRefresh.put(stock, true);
            }
        }), INITIAL_DELAY, UPDATE_TIME_PERIOD_IN_SECONDS, SECONDS);
    }

}
