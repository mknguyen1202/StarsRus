package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Admin;



@Repository
public class AdminRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Administrator";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

//     CREATE TABLE Admin (
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

    public int create(Admin admin) {
        System.out.println("CREATE ADMIN---------" + admin.getAdmin_username() + " " +admin.getAdmin_name());
        String QUERY = "INSERT INTO Administrator"
                       + " VALUES(?,?,?,?,?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                admin.getAdmin_username(),
                                admin.getAdmin_password(),
                                admin.getAdmin_name(),
                                admin.getAdmin_address(),
                                admin.getAdmin_state(),
                                admin.getAdmin_phone(),
                                admin.getAdmin_email(),
                                admin.getAdmin_taxid(),
                                admin.getAdmin_ssn());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Admin admin) {
        String QUERY = "UPDATE Administrator SET"
                                    + " admin_password = ?,"
                                    + " admin_name = ?,"
                                    + " admin_address = ?,"
                                    + " admin_state = ?,"
                                    + " admin_phone = ?,"
                                    + " admin_email = ?,"
                                    + " admin_taxid = ?,"
                                    + " admin_ssn = ?"
                                    + " WHERE admin_username = ?";
        try {
            jdbcTemplate.update(QUERY,  admin.getAdmin_password(),
                                        admin.getAdmin_name(),
                                        admin.getAdmin_address(),
                                        admin.getAdmin_state(),
                                        admin.getAdmin_phone(),
                                        admin.getAdmin_email(),
                                        admin.getAdmin_taxid(),
                                        admin.getAdmin_ssn(), 
                                        admin.getAdmin_username().trim()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByUsername(String username) {
        String QUERY = "DELETE FROM Administrator WHERE admin_username = ?";
        try {
            jdbcTemplate.update(QUERY, username);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Admin> findAll() {
        String QUERY = "SELECT * FROM Administrator";
        return jdbcTemplate.query(QUERY, new AdminRowMapper());
    };
    public Admin findByUsername(String username) {
        String QUERY = "SELECT * FROM Administrator WHERE admin_username=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { username },
				new BeanPropertyRowMapper<Admin>(Admin.class));        
    };



}

