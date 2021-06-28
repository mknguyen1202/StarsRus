package cs174.starsrus.repositories;


import java.time.LocalDate;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Customer;
import cs174.starsrus.entities.MarketAccount;



@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    private MarketAccountRepository marespo;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Customer";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

//     CREATE TABLE Customer (
//     username CHAR(30),
//     password CHAR(30),
//     name CHAR(30),
//     address CHAR(30),
//     state CHAR(2),
//     phone CHAR(20),
//     email CHAR(30),
//     tid CHAR(30),
//     ssn CHAR(20)
// );

    public int create(Customer customer) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO Customer"
                       + " VALUES(?,?,?,?,?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                customer.getUsername(),
                                customer.getPassword(),
                                customer.getName(),
                                customer.getAddress(),
                                customer.getState(),
                                customer.getPhoneNumber(),
                                customer.getEmail(),
                                customer.getTID(),
                                customer.getSsn());

            // deposit 1000 by default
            double DEFAULT_DEPOSIT = 1000;
            // MarketAccountRepository marespo = new MarketAccountRepository();
            MarketAccount marketAccount = new MarketAccount();
            marketAccount.setBalance(DEFAULT_DEPOSIT);
            marketAccount.set_username(customer.getUsername());
            // marketAccount.set_account_date(Util.getCurrentDateFromDBAsString());
            // marketAccount.set_balance_date(Util.getCurrentDateFromDBAsString());
            marketAccount.set_account_date(LocalDate.now().toString());
            marketAccount.set_balance_date(LocalDate.now().toString());
            return this.marespo.create(marketAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Customer customer) {

        try {


            String QUERY = "UPDATE Customer SET"
            + " password = ?,"
            + " name = ?,"
            + " address = ?,"
            + " state = ?,"
            + " phone = ?,"
            + " email = ?,"
            + " tid = ?,"
            + " ssn = ?"
            + " WHERE username = ?";

            jdbcTemplate.update(QUERY,  customer.getPassword(),
                                        customer.getName(),
                                        customer.getAddress(),
                                        customer.getState(),
                                        customer.getPhoneNumber(),
                                        customer.getEmail(),
                                        customer.getTID(),
                                        customer.getSsn(), 
                                        customer.getUsername().trim()); // WHERE



            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByUsername(String username) {
        String QUERY = "DELETE FROM Customer WHERE username = ?";
        try {
            jdbcTemplate.update(QUERY, username);
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


/*
    public Customer findByKey(String username, String ssn, String tid) {
        String QUERY = "SELECT * FROM Customer WHERE username=? AND ssn=? AND tid=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { username, ssn, tid },
				new BeanPropertyRowMapper<Customer>(Customer.class));        
    };
*/

/**
     public int deleteByKey(String username, String ssn, String tid) {
        String WHEREstatement = "username=" + "\'" + username + "\'";
        WHEREstatement += "ssn=" + "\'" + ssn + "\'";
        WHEREstatement += "tid=" + "\'" + tid + "\'";
        String QUERY = "DELETE FROM Customer WHERE " + WHEREstatement;
        try {
            jdbcTemplate.update(QUERY);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
 */

}

