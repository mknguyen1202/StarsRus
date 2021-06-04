package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.StockMarket;



@Repository
public class StockMarketRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM StockMarket";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(StockMarket stockmarket) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO StockMarket"
                       + " VALUES(DATETIME('now'),?,?,?)" ;
        System.out.println("\n\nIN STOCK MARKET REPOSITORY====================");
        System.out.println(stockmarket.getSymbol());
        System.out.println(stockmarket.getClosing_price());
        System.out.println(stockmarket.getLast_closing_price());
        System.out.println(stockmarket.getStocktime());
        try {
            jdbcTemplate.update(QUERY, 
                                stockmarket.getCurrent_price(),
                                stockmarket.getClosing_price(),
                                stockmarket.getSymbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int createClose(StockMarket stockmarket) {
        //TODO: automatically create and add $1000 to Market account
        List<StockMarket> fromLastData = findAll();
   
        String QUERY = "INSERT INTO StockMarket(stocktime, current_price, closing_price, symbol)"
                       + " VALUES(DATETIME('now', 'localtime'),?,?,?)" ;
   
        try {
            for (StockMarket s : fromLastData) {
                System.out.println("IN FORLOOP IN creatClose " + s.getSymbol());
                jdbcTemplate.update(QUERY, 
                                s.getCurrent_price(),
                                s.getCurrent_price(),
                                s.getSymbol());
            }
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int createOpen(StockMarket stockmarket) {
        //TODO: automatically create and add $1000 to Market account
        List<StockMarket> fromLastData = findAll();
   
        String QUERY = "INSERT INTO StockMarket(stocktime, current_price, closing_price, symbol)"
                       + " VALUES(DATETIME('now'),?,?,?)" ;
   
        try {
            for (StockMarket s : fromLastData) {
                System.out.println("IN FORLOOP IN creatClose " + s.getSymbol());
                jdbcTemplate.update(QUERY, 
                                s.getCurrent_price(),
                                -1,
                                s.getSymbol());
            }
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    
    public int update(StockMarket stockmarket) {
        String QUERY = "UPDATE StockMarket SET"
                                    + " current_price = ?,"
                                    + " closing_price = ?,"
                                    + " WHERE symbol = ? AND stocktime = ?";
        try {
            jdbcTemplate.update(QUERY,  stockmarket.getCurrent_price(),
                                        stockmarket.getClosing_price(),
                                        stockmarket.getSymbol(),
                                        stockmarket.getStocktime()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteBySymbol(String sym, String time) {
        String WHEREstatement = "symbol="+ "\'" + sym + "\'";
        WHEREstatement += "stocktime=" + "\'" + time + "\'";

        String QUERY = "DELETE FROM StockMarket WHERE" + WHEREstatement;
        try {
            jdbcTemplate.update(QUERY);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<StockMarket> findAll() {
        String QUERY = "SELECT * FROM (SELECT * FROM StockMarket ORDER BY stocktime DESC)"
                        +" LEFT JOIN (SELECT symbol AS symbol2, closing_price AS last_closing_price"
                        +"                FROM (SELECT *  FROM StockMarket ORDER BY stocktime DESC)" 
                        +"                 WHERE closing_price != -1 "
                        +"                GROUP BY symbol2 )" 
                        +" ON symbol = symbol2"
                        +" GROUP BY symbol;";
        return jdbcTemplate.query(QUERY, new StockMarketRowMapper());
    };
    public StockMarket findBySymbol(String sym,String time) {
        String QUERY = "SELECT * FROM StockMarket WHERE symbol=? AND stocktime=? ORDER BY stocktime DESC LIMIT 1";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { sym,time },
				new BeanPropertyRowMapper<StockMarket>(StockMarket.class));        
    };



}

