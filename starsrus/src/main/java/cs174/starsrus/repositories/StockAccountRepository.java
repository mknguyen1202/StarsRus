package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.StockAccount;



@Repository
public class StockAccountRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM StockAccount";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(StockAccount stockaccount) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO StockAccount"
                       + " VALUES(?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                stockaccount.get_symbol(),
                                stockaccount.get_balance(),
                                stockaccount.get_original_buying_price(),
                                stockaccount.get_account_date(),
                                stockaccount.get_username());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(StockAccount stockaccount) {
        String QUERY = "UPDATE StockAccount SET"
                                    + " balance = ?,"
                                    + " original_buying_price = ?,"
                                    + " account_date = ?,"
                                    + " username = ?,"
                                    + " WHERE symbol = ?";
        try {
            jdbcTemplate.update(QUERY,  stockaccount.get_balance(),
                                        stockaccount.get_original_buying_price(),
                                        stockaccount.get_account_date(),
                                        stockaccount.get_username(),
                                        stockaccount.get_symbol()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByKey(String sym, String user, String obp) {
        String WHEREstatement = "symbol=" + "\'" + sym + "\'";
        WHEREstatement += "username=" + "\'" + user + "\'";
        WHEREstatement += "original_buying_price=" + "\'" + obp + "\'";
        String QUERY = "DELETE FROM StockAccount WHERE " + WHEREstatement;         
        try{
            jdbcTemplate.update(QUERY);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    };

    public List<StockAccount> findAll() {         
        String QUERY = "SELECT * FROM StockAccount";
        return jdbcTemplate.query(QUERY, new StockAccountRowMapper());
    };
    public StockAccount findByKey(String sym, String user, String obp) {
        String QUERY = "SELECT * FROM StockAccount WHERE symbol=? AND username=? AND original_buying_price=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { sym,user,obp },
				new BeanPropertyRowMapper<StockAccount>(StockAccount.class));    
    };



}

