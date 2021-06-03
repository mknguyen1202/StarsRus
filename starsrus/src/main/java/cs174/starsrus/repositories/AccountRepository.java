package cs174.starsrus.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Account;

@Repository
public class AccountRepository  {
	@Autowired
	JdbcTemplate jdbcTemplate;

    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Buy";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    int create(Account account) {
        return 0;
    };
    int update(Account account) {
        return 0;
    };
    int deleteById(Long id) {
        return 0;
    };

    List<Account> findAll() {
        return null;
    };

        
    List<Account> findByNameAndPrice(String name, BigDecimal price) {
        return jdbcTemplate.queryForObject("select * from student where name=?", new Object[] { name },
                 new BeanPropertyRowMapper<List>(List.class));
    };

    Account findById(Long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] { id },
                    new BeanPropertyRowMapper<Account>(Account.class));
    };

    String getNameById(Long id) {
        return null;
    };

}
