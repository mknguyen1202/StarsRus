package cs174.starsrus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
}
