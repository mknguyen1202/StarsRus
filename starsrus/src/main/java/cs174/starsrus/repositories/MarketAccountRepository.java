package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.MarketAccount;



@Repository
public class MarketAccountRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM MarketAccount";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(MarketAccount marketaccount) {
        //TODO: automatically create and add $1000 to Market account
        // market_account_id INTEGER NOT NULL,
        // balance REAL NOT NULL,
        // balance_date DATE,
        // account_date DATE,
        // username CHAR(30),
        String QUERY = "INSERT INTO MarketAccount(balance, balance_date, account_date, username)"
                       + " VALUES(?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                // marketaccount.get_market_account_id(),
                                marketaccount.getBalance(),
                                marketaccount.get_balance_date(),
                                marketaccount.get_account_date(),
                                marketaccount.get_username());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    /**
     * This method could be used to deposit ore take out moneyy
     * @param marketaccount
     * @return
     */
    
    public int update(MarketAccount marketaccount) {
        String QUERY = "UPDATE MarketAccount SET"
                                    + " balance = ?,"
                                    + " balance_date = ?,"
                                    + " account_date = ?,"
                                    + " username = ?,"
                                    + " WHERE market_account_id = ?";
        try {
            jdbcTemplate.update(QUERY,  marketaccount.getBalance(),
                                        marketaccount.get_balance_date(),
                                        marketaccount.get_account_date(),
                                        marketaccount.get_username(),
                                        marketaccount.get_market_account_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByMarketAccountID(int id) {
        String QUERY = "DELETE FROM MarketAccount WHERE market_account_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<MarketAccount> findAll() {         
        String QUERY = "SELECT * FROM MarketAccount";
        return jdbcTemplate.query(QUERY, new MarketAccountRowMapper());
    };

    public MarketAccount findByMarketAccountID(int id) {
        String QUERY = "SELECT * FROM MarketAccount WHERE market_account_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<MarketAccount>(MarketAccount.class));        
    };

    public MarketAccount findByMarketAccountUsername(String username) {
        String QUERY = "SELECT * FROM MarketAccount WHERE username=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { username },
				new BeanPropertyRowMapper<MarketAccount>(MarketAccount.class));        
    };


}

