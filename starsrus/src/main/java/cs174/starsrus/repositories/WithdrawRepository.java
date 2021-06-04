package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Withdraw;



@Repository
public class WithdrawRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Withdraw";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(Withdraw withdraw) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO Withdraw"
                       + " VALUES(?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                withdraw.get_withdraw_id(),
                                withdraw.get_withdraw_date(),
                                withdraw.get_withdraw_amount(),
                                withdraw.get_username());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Withdraw withdraw) {
        String QUERY = "UPDATE Withdraw SET"
                                    + " withdraw_date = ?,"
                                    + " withdraw_amount = ?,"
                                    + " username = ?,"
                                    + " WHERE withdraw_id = ?";
        try {
            jdbcTemplate.update(QUERY,  withdraw.get_withdraw_date(),
                                        withdraw.get_withdraw_amount(),
                                        withdraw.get_username(),
                                        withdraw.get_withdraw_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByWithdrawID(int id) {
        String QUERY = "DELETE FROM Withdraw WHERE withdraw_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Withdraw> findAll() {
        String QUERY = "SELECT * FROM Withdraw";
        return jdbcTemplate.query(QUERY, new WithdrawRowMapper());
    };
    public Withdraw findByWithdrawID(int id) {
        String QUERY = "SELECT * FROM Withdraw WHERE withdraw_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Withdraw>(Withdraw.class));        
    };

}

