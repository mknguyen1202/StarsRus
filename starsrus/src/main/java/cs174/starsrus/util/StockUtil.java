package cs174.starsrus.util;

import java.math.BigDecimal;
import java.util.ArrayList;

import cs174.starsrus.util.Util;

public class StockUtil {

    private static int NUMBER_OF_QUOTES_PER_HOUR = 10;
   
    
    public static ArrayList<ArrayList<Double>> generateHistoryQuotes(BigDecimal price, double margin, int interval) {
        ArrayList<ArrayList <Double>> history = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_QUOTES_PER_HOUR * interval; i++) {
            ArrayList<Double> quote = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                quote.add(Util.generateRandomDecimal(price.doubleValue() - margin, price.doubleValue() + margin));
            }
            history.add(quote);
        }
        return history;
    }

    public static ArrayList<ArrayList<Double>> generateHistoryQuotesOneDay(BigDecimal price, double margin) {
        return generateHistoryQuotes(price, margin, 24);
    }

    public static ArrayList<ArrayList<Double>> generateHistoryQuotesOneWeek(BigDecimal price, double margin) {
        return generateHistoryQuotes(price, margin, 24*7);
    }

    public static ArrayList<ArrayList<Double>> generateHistoryQuotesOneMonth(BigDecimal price, double margin) {
        return generateHistoryQuotes(price, margin, 24*30);
    }

    public static ArrayList<ArrayList<Double>> generateHistoryQuotesThreeMonths(BigDecimal price, double margin) {
        return generateHistoryQuotes(price, margin, 24*90);
    }

}
