package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.StockMarket;

class StockMarketRowMapper implements RowMapper<StockMarket> {

    @Override
    public StockMarket mapRow(ResultSet rs, int rowNum) throws SQLException {
        StockMarket stockmarket = new Sell();
        stockmarket.setStocktime(rs.getString("stocktime"));
        stockmarket.setCurrent_price(rs.getDouble("current_price"));
        stockmarket.setClosing_price(rs.getDouble("closing_price"));
        stockmarket.set_symbol(rs.getString("symbol"));

        return stockmarket;
    }
}