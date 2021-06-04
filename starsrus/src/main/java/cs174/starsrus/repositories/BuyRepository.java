package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.Util;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Buy;
import cs174.starsrus.entities.MarketAccount;
import cs174.starsrus.entities.StockMarket;
import cs174.starsrus.entities.Withdraw;



@Repository
public class BuyRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Buy";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    public int buy(Buy buy){
        Withdraw withdraw = new Withdraw();
        try {
            withdraw.set_withdraw_date(Util.getCurrentDateFromDBAsString());
            withdraw.set_username(buy.get_username());

            return 1;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * This method is for buying shares
     * @param buy
     * @return 1: success, 0: error
     */
    public int create(Buy buy) {
        //TODO: automatically create and add $1000 to Market account

        WithdrawRepository wdrespo = new WithdrawRepository();
        Withdraw withdraw = new Withdraw();
        MarketAccountRepository marespo = new MarketAccountRepository();
        StockMarketRepository smrespo = new StockMarketRepository();
        
        try {
            // find the market account to take the money to buy
            MarketAccount ma = marespo.findByMarketAccountUsername(buy.get_username());

            // find the stock to get the current price on the market
            StockMarket sm = smrespo.findBySymbol(buy.get_symbol());
            double total_money_needed = sm.getCurrent_price() * buy.getBuy_shares();

            // return error if not enough money
            if (ma.get_balance() < total_money_needed) {
                return 0;
            }

            withdraw.set_withdraw_date(Util.getCurrentDateFromDBAsString());
            withdraw.setWithdraw_amount(total_money_needed);
            withdraw.set_username(buy.get_username());
        
            // first withdraw money from market account
            wdrespo.create(withdraw);

            // then, add to buy history
            String QUERY = "INSERT INTO Buy(buy_date, buy_shares, username, symbol)"
                        + " VALUES(?,?,?,?,?)" ;

            jdbcTemplate.update(QUERY, 
                                buy.get_buy_date(),
                                buy.getBuy_shares(),
                                buy.get_username(),
                                buy.get_symbol());
                    
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Buy buy) {
        String QUERY = "UPDATE Buy SET"
                                    + " buy_date = ?,"
                                    + " buy_shares = ?,"
                                    + " username = ?,"
                                    + " symbol = ?,"
                                    + " WHERE buy_id = ?";
        try {
            jdbcTemplate.update(QUERY,  buy.get_buy_date(),
                                        buy.getBuy_shares(),
                                        buy.get_username(),
                                        buy.get_symbol(),
                                        buy.get_buy_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByBuyID(int id) {
        String QUERY = "DELETE FROM Buy WHERE buy_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Buy> findAll() {
        String QUERY = "SELECT * FROM Buy";
        return jdbcTemplate.query(QUERY, new BuyRowMapper());
    };
    public Buy findByBuyID(int id) {
        String QUERY = "SELECT * FROM Buy WHERE buy_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Buy>(Buy.class));        
    };



}

