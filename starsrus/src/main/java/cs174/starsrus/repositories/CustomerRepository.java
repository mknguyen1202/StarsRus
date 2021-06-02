package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Customer;



@Repository
public class CustomerRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    long count() {
        String QUERY = "SELECT COUNT(*) FROM Customer";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    int create(Customer customer) {
        String QUERY = "INSERT INTO Customer"
                       + "VALUE Customer()";
        try {
            jdbcTemplate.execute(QUERY);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    int update(Customer customer) {
        String QUERY = "UPDATE Customer"
                        +" SET ";

        return 0;
    };

    int deleteByUsername(String username) {
        String QUERY = "DELETE * FROM Customer WHERE username=" + username;
        try {
            jdbcTemplate.update(QUERY, new Object[]{username});
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Customer> findAll() {
        String QUERY = "SELECT * FROM Customer";
        return jdbcTemplate.query(QUERY, new CustomerRowMapper());
    };
    public Customer findByUsername(String username) {
        String QUERY = "SELECT * FROM Customer WHERE username=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { username },
				new BeanPropertyRowMapper<Customer>(Customer.class));        
    };



}

