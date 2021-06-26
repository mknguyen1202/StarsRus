package cs174.starsrus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.entities.Customer;

@Repository
public class LoginRepository {
    


    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public Customer findByUsername(String username) {
        String QUERY = "SELECT * FROM Customer WHERE username=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { username },
				new BeanPropertyRowMapper<Customer>(Customer.class));        
    };

}
