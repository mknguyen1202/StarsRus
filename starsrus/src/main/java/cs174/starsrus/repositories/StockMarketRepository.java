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
                       + " VALUES(?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                stockmarket.getStocktime(),
                                stockmarket.getCurrent_price(),
                                stockmarket.getClosing_price(),
                                stockmarket.getSymbol());
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
        String QUERY = "SELECT * FROM (SELECT * FROM StockMarket ORDER BY stocktime DESC) GROUP BY symbol;";
        return jdbcTemplate.query(QUERY, new StockMarketRowMapper());
    };
    public StockMarket findBySymbol(String sym,String time) {
        String QUERY = "SELECT * FROM StockMarket WHERE symbol=? AND stocktime=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { sym,time },
				new BeanPropertyRowMapper<StockMarket>(StockMarket.class));        
    };



}

