package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Deposit;

class DepositRowMapper implements RowMapper<Deposit> {

    @Override
    public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException {
        Deposit deposit = new Deposit();
        deposit.set_deposit_id(rs.getInt("deposit_id"));
        deposit.set_deposit_date(rs.getString("deposit_date"));
        deposit.setDeposit_amount(rs.getDouble("deposit_amount"));
        deposit.set_username(rs.getString("username"));
        return deposit;
    }
}