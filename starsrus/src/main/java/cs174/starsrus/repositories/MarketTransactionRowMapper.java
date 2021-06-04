package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Deposit;

class MarketTransactionRowMapper implements RowMapper<Deposit> {

    @Override
    public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException {
        Deposit deposit = new Deposit();
        System.out.println("IN ROW MAPPER: ----------------" + rs.getInt("transaction_id"));
        deposit.set_deposit_id(rs.getInt("transaction_id"));
        deposit.set_deposit_date(rs.getString("date"));
        deposit.setDeposit_amount(rs.getDouble("amount"));
        deposit.set_username(rs.getString("username"));
        return deposit;
    }
}