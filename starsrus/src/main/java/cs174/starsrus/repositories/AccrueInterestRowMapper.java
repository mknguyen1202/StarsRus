package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.AccrueInterest;

class AccrueInterestRowMapper implements RowMapper<Customer> {

    @Override
    public AccrueInterest mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccrueInterest accrueinterest = new AccrueInterest();
        accrueinterest.set_interest_id(rs.getInt("interest_id"));
        accrueinterest.set_interest_date(rs.getString("interest_date"));
        accrueinterest.set_total_earnings(rs.getFloat("total_earnings"));
        accrueinterest.set_username(rs.getString("username"));
        return accrueinterest;
    }

}