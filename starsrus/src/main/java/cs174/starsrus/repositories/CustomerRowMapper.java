package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Customer;

class CustomerRowMapper implements RowMapper<Customer> {

//     -- CREATE TABLE Customer (
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
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setUsername(rs.getString("username"));
        customer.setPassword(rs.getString("password"));
        customer.setName(rs.getString("name"));
        customer.setAddress(rs.getString("address"));
        customer.setState(rs.getString("state"));
        customer.setPhoneNumber(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));
        customer.setTID(rs.getString("tid"));
        customer.setSsn(rs.getString("ssn"));
        return customer;
    }

}