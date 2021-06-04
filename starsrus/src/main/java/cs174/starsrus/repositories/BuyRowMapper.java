package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Buy;

class BuyRowMapper implements RowMapper<Buy> {

    @Override
    public Buy mapRow(ResultSet rs, int rowNum) throws SQLException {
        Buy buy = new Buy();
        buy.set_buy_id(rs.getInt("buy_id"));
        buy.set_buy_date(rs.getString("buy_date"));
        buy.setBuy_shares(rs.getDouble("buy_shares"));
        buy.set_username(rs.getString("username"));
        buy.set_symbol(rs.getString("symbol"));

        return buy;
    }
}