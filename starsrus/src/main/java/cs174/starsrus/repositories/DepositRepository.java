package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Deposit;
import cs174.starsrus.entities.Withdraw;



@Repository
public class DepositRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Deposit";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(Deposit deposit) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO Deposit"
                       + " VALUES(?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                deposit.get_deposit_id(),
                                deposit.get_deposit_date(),
                                deposit.get_deposit_amount(),
                                deposit.get_username());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Deposit deposit) {
        String QUERY = "UPDATE Deposit SET"
                                    + " deposit_date = ?,"
                                    + " deposit_amount = ?,"
                                    + " username = ?,"
                                    + " WHERE deposit_id = ?";
        try {
            jdbcTemplate.update(QUERY,  deposit.get_deposit_date(),
                                        deposit.get_deposit_amount(),
                                        deposit.get_username(),
                                        deposit.get_deposit_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByDepositID(int id) {
        String QUERY = "DELETE FROM Deposit WHERE deposit_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Deposit> findAll() {
        String QUERY = "SELECT * FROM Deposit";
        return jdbcTemplate.query(QUERY, new DepositRowMapper());
    };
    public Deposit findByDepositID(int id) {
        String QUERY = "SELECT * FROM Deposit WHERE deposit_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Deposit>(Deposit.class));        
    };

    public List<Deposit> MarketTransactionHistory(){
        String QUERY = "SELECT deposit_id AS transaction_id, deposit_date AS date, deposit_amount AS amount, username AS username "
                        + "FROM Deposit "
                        + "WHERE username = 'olive' "
                        + "UNION "
                        + "SELECT withdraw_id AS transaction_id, withdraw_date AS date, withdraw_amount AS amount, username AS username "
                        + "FROM Withdraw;"
                        + "WHERE username = 'olive'";
        return jdbcTemplate.query(QUERY, new MarketTransactionRowMapper());
    };

}

