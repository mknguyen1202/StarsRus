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
                                stockmarket.get_symbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(StockMarket stockmarket) {
        String QUERY = "UPDATE StockMarket SET"
                                    + " stocktime = ?,"
                                    + " current_price = ?,"
                                    + " closing_price = ?,"
                                    + " WHERE symbol = ?";
        try {
            jdbcTemplate.update(QUERY,  stockmarket.getStocktime(),
                                        stockmarket.getCurrent_price(),
                                        stockmarket.getClosing_price(),
                                        stockmarket.getSymbol()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteBySymbol(String id) {
        String QUERY = "DELETE FROM StockMarket WHERE symbol = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<StockMarket> findAll() {
        String QUERY = "SELECT * FROM StockMarket";
        return jdbcTemplate.query(QUERY, new StockMarketRowMapper());
    };
    public StockMarket findBySymbol(String id) {
        String QUERY = "SELECT * FROM StockMarket WHERE symbol=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<StockMarket>(StockMarket.class));        
    };



}

