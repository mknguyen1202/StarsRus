package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Admin;

class AdminRowMapper implements RowMapper<Admin> {

//     -- CREATE TABLE Admin (
// --     username CHAR(30),
// --     password CHAR(30),
// --     name CHAR(30),
// --     address CHAR(30),
// --     state CHAR(2),
// --     phone CHAR(20),
// --     email CHAR(30),
// --     tid CHAR(30),
// --     ssn CHAR(20)
// -- );
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setAdmin_username(rs.getString("admin_username"));
        admin.setAdmin_password(rs.getString("admin_password"));
        admin.setAdmin_Name(rs.getString("admin_name"));
        admin.setAdmin_address(rs.getString("admin_address"));
        admin.setAdmin_state(rs.getString("admin_state"));
        admin.setAdmin_phonenumber(rs.getString("admin_phone"));
        admin.setAdmin_email(rs.getString("admin_email"));
        admin.setAdmin_tid(rs.getString("admin_tid"));
        admin.setAdmin_ssn(rs.getString("admin_ssn"));
        return admin;
    }

}