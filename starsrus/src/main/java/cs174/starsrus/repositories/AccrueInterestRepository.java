package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.AccrueInterest;



@Repository
public class AccrueInterestRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM AccrueInterest";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };


    public int create(AccrueInterest accrueinterest) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO AccrueInterest"
                       + " VALUES(?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                accrueinterest.get_interest_id(),
                                accrueinterest.get_interest_date(),
                                accrueinterest.get_total_earnings(),
                                accrueinterest.get_username());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(AccrueInterest accrueinterest) {
        String QUERY = "UPDATE AccrueInterest SET"
                                    + " interest_date = ?,"
                                    + " total_earnings = ?,"
                                    + " username = ?,"
                                    + " WHERE interest_id = ?";
        try {
            jdbcTemplate.update(QUERY,  accrueinterest.get_interest_date(),
                                        accrueinterest.get_total_earnings(),
                                        accrueinterest.get_username(),
                                        accrueinterest.get_interest_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByInterestID(int id) {
        String QUERY = "DELETE FROM AccrueInterest WHERE interest_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<AccrueInterest> findAll() {
        String QUERY = "SELECT * FROM AccrueInterest";
        return jdbcTemplate.query(QUERY, new AccrueInterestRowMapper());
    };
    public AccrueInterest findByInterestID(int id) {
        String QUERY = "SELECT * FROM AccrueInterest WHERE interest_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<AccrueInterest>(AccrueInterest.class));        
    };



}

