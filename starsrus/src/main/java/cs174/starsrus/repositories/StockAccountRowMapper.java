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
        stockaccount.setBalance(rs.getDouble("balance"));
        stockaccount.setOriginal_buying_price(rs.getDouble("original_buying_price"));
        stockaccount.set_account_date(rs.getString("account_date"));
        stockaccount.set_username(rs.getString("username"));

        return stockaccount;
    }
}