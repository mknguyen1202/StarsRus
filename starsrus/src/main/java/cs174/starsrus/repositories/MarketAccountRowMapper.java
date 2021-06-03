package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.MarketAccount;

class MarketAccountRowMapper implements RowMapper<MarketAccount> {

    @Override
    public MarketAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        MarketAccount marketaccount = new MarketAccount();
        marketaccount.set_market_account_id(rs.getInt("market_account_id"));
        marketaccount.set_balance(rs.getFloat("balance"));
        marketaccount.set_balance_date(rs.getString("balance_date"));
        marketaccount.set_account_date(rs.getString("account_date"));
        marketaccount.set_username(rs.getString("username"));

        return marketaccount;
    }
}