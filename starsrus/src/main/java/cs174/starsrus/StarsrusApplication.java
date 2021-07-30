package cs174.starsrus;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cs174.starsrus.util.StockUtil;
import cs174.starsrus.util.Util;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes.HistoricalQuote;


@SpringBootApplication
public class StarsrusApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StarsrusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        // System.out.println("----------------------- DAILY HISTORY --------------------------");
        // System.out.println(Util.getCalendarStartOfTheDate());

		
		
        // try {
        //     Stock stock;
        //     stock = YahooFinance.get("INTC");

        //     BigDecimal price = stock.getQuote().getPrice();
        //     BigDecimal change = stock.getQuote().getChangeInPercent();
        //     BigDecimal peg = stock.getStats().getPeg();
        //     BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
        //     System.out.println("============= "  + price + " " + change + " " + peg + " " + dividend);

        //     System.out.println("----------------------- DAILY HISTORY --------------------------");
        //     System.out.println("START:" + Util.getCalendarStartOfTheDate().getTime());
        //     System.out.println("NOW: " + Util.getCalendarNow().getTime());
        //     System.out.println("YESTERDAY: " + Util.getCalendarLastWeek().getTime());
        //     // System.out.println(Util.getCalendarStartOfTheDate().getInstance().getTime());
        //     System.out.println("[][][][][][][][][][][][][][][][][]");

        //     List<BigDecimal> prices = new ArrayList<>();
            
        //     // System.out.println(stock.getHistory(Util.getCalendarYesterday(), Util.getCalendarNow()));
        //     List<HistoricalQuote> data = stock.getHistory(Util.getCalendarDaysAgo(1), Util.getCalendarNow());
        //     System.out.println("DATA SIZE: " + data.size());
        //     for (HistoricalQuote o : data) {
        //         System.out.println("history price:" + o.toString());
        //         System.out.println(o.getOpen());
        //         System.out.println(o.getClose());
        //         System.out.println(o.getLow());
        //         System.out.println(o.getHigh());
        //         prices.add(o.getOpen());
        //     }
        //     // stock.print();
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        
        // String path = "/cs174/resources/data.csv";

        

        File file = new File(".");
        String userDirectory = System.getProperty("user.dir");
        String strParentDirectory = file.getParent();
        String filename = userDirectory + "/src/main/resources/data.csv";
        System.out.println("userDirectory: " +filename);
        System.out.println(file.getName());
        System.out.println("Parent directory is : " + strParentDirectory);

        System.out.println(Util.getCSV_data(filename, "\n"));

        int count = 1;
        BigDecimal price = new BigDecimal(80);
        for (ArrayList<Double> s : StockUtil.generateHistoryQuotesOneDay(price, 10.0f)) {
            System.out.println(count + " " + s);
            count++;
        };

	}

}
