package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.StockAccount;

class StockAccountRowMapper implements RowMapper<StockAccount> {

    @Override
    public StockAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        StockAccount stockaccount = new StockAccount();
        stockaccount.set_symbol(rs.getString("symbol"));
        stockaccount.set_balance(rs.getFloat("balance"));
        stockaccount.set_original_buying_price(rs.getString("original_buying_price"));
        stockaccount.set_account_date(rs.getString("account_date"));
        stockaccount.set_username(rs.getString("username"));

        return stockaccount;
    }
}