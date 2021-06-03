package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Sell;



@Repository
public class SellRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Sell";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(Sell sell) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO Sell"
                       + " VALUES(?,?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                sell.get_sell_id(),
                                sell.get_sell_date(),
                                sell.get_sell_shares(),
                                sell.get_earnings_from_sale(),
                                sell.get_username(),
                                sell.get_symbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Sell sell) {
        String QUERY = "UPDATE Sell SET"
                                    + " sell_date = ?,"
                                    + " sell_shares = ?,"
                                    + " earnings_from_sale = ?,"
                                    + " username = ?,"
                                    + " symbol = ?,"
                                    + " WHERE sell_id = ?";
        try {
            jdbcTemplate.update(QUERY,  sell.get_sell_date(),
                                        sell.get_sell_shares(),
                                        sell.get_earnings_from_sale(),
                                        sell.get_username(),
                                        sell.get_symbol(),
                                        sell.get_sell_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteBySellID(int id) {
        String QUERY = "DELETE FROM Sell WHERE sell_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Sell> findAll() {
        String QUERY = "SELECT * FROM Sell";
        return jdbcTemplate.query(QUERY, new SellRowMapper());
    };
    public Sell findBySellID(int id) {
        String QUERY = "SELECT * FROM Sell WHERE sell_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Sell>(Sell.class));        
    };



}

