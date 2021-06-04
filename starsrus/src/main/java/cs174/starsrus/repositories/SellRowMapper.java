package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.Sell;

class SellRowMapper implements RowMapper<Sell> {

    @Override
    public Sell mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sell sell = new Sell();
        sell.set_sell_id(rs.getInt("sell_id"));
        sell.set_sell_date(rs.getString("sell_date"));
        sell.setSell_shares(rs.getDouble("sell_shares"));
        sell.setEarnings_from_sale(rs.getDouble("earnings_from_sale"));
        sell.set_username(rs.getString("username"));
        sell.set_symbol(rs.getString("symbol"));

        return sell;
    }
}