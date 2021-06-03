package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Withdraw;

class WithdrawRowMapper implements RowMapper<Withdraw> {

    @Override
    public Withdraw mapRow(ResultSet rs, int rowNum) throws SQLException {
        Withdraw withdraw = new Withdraw();
        withdraw.set_withdraw_id(rs.getInt("withdraw_id"));
        withdraw.set_withdraw_date(rs.getString("withdraw_date"));
        withdraw.set_withdraw_amount(rs.getFloat("withdraw_amount"));
        withdraw.set_username(rs.getString("username"));
        return withdraw;
    }
}