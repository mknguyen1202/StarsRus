package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Buy;



@Repository
public class BuyRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Buy";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(Buy buy) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO Buy"
                       + " VALUES(?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                buy.get_buy_id(),
                                buy.get_buy_date(),
                                buy.get_buy_shares(),
                                buy.get_username(),
                                buy.get_symbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Buy buy) {
        String QUERY = "UPDATE Buy SET"
                                    + " buy_date = ?,"
                                    + " buy_shares = ?,"
                                    + " username = ?,"
                                    + " symbol = ?,"
                                    + " WHERE buy_id = ?";
        try {
            jdbcTemplate.update(QUERY,  buy.get_buy_date(),
                                        buy.get_buy_shares(),
                                        buy.get_username(),
                                        buy.get_symbol(),
                                        buy.get_buy_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByBuyID(int id) {
        String QUERY = "DELETE FROM Buy WHERE buy_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Buy> findAll() {
        String QUERY = "SELECT * FROM Buy";
        return jdbcTemplate.query(QUERY, new BuyRowMapper());
    };
    public Buy findByBuyID(int id) {
        String QUERY = "SELECT * FROM Buy WHERE buy_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Buy>(Buy.class));        
    };



}

