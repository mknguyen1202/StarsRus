package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.util.Util;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Buy;
import cs174.starsrus.entities.MarketAccount;
import cs174.starsrus.entities.StockAccount;
import cs174.starsrus.entities.StockMarket;
import cs174.starsrus.entities.Withdraw;



@Repository
public class BuyRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    WithdrawRepository wdrespo;

    @Autowired
    MarketAccountRepository marespo;

    @Autowired
    StockMarketRepository smrespo;

    @Autowired
    StockAccountRepository sarespo;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Buy";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    public int buy(Buy buy){
        Withdraw withdraw = new Withdraw();
        try {
            // withdraw.set_withdraw_date(Util.getCurrentDateFromDBAsString());
            withdraw.set_username(buy.get_username());

            return 1;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * This method add shares to StockAccount, withdraws money from MarketAccount, and 
     * adds to deposit and sell history.
     * @param buy
     * @return 1: success, 0: error
     */
    public int create(Buy buy) {
        //TODO: automatically create and add $1000 to Market account


        
        try {
            // WithdrawRepository wdrespo = new WithdrawRepository();
            // MarketAccountRepository marespo = new MarketAccountRepository();
            // StockMarketRepository smrespo = new StockMarketRepository();
            // StockAccountRepository sarespo = new StockAccountRepository();

            // find the market account to take the money to buy
            MarketAccount ma = marespo.findByMarketAccountUsername(buy.get_username());

            // find the stock to get the current price on the market
            StockMarket sm = smrespo.findBySymbol(buy.get_symbol());

            // find the stock account to insert the new bought stocks
            StockAccount sa = sarespo.findBySymbolUsername(buy.get_symbol(), buy.get_username());


            double total_money_needed = sm.getCurrent_price() * buy.getBuy_shares(); // in dollars

            // return error if not enough money
            if (ma.getBalance() < total_money_needed) {
                return 0;
            }

            // STEP 1: Add shares to StockAccount
            if (sa == null) {   // buy whole new stock (not in stock account yet)
                sa = new StockAccount();
                sa.setBalance(buy.getBuy_shares());
                sa.setOriginal_buying_price(sm.getCurrent_price());
                // sa.set_account_date(Util.getCurrentDateFromDBAsString());
                sa.set_account_date(LocalDate.now().toString());
                sa.set_username(buy.get_username());
                sa.set_symbol(buy.get_symbol());
                sarespo.create(sa); // add to StockAccount
            } else { // Stock already in account, just need to add more shares
                double updateBalance = sa.getBalance() + buy.getBuy_shares();

                // equation for average buy price for tax purpose
                double updateOriginalBuyPrice = (sa.getOriginal_buying_price() * sa.getBalance() + sm.getCurrent_price() * buy.getBuy_shares()) / (sa.getBalance() + buy.getBuy_shares());
                
                sa.setBalance(updateBalance);
                sa.setOriginal_buying_price(updateOriginalBuyPrice);
                // sa.set_account_date(Util.getCurrentDateFromDBAsString());
                sa.set_account_date(LocalDate.now().toString());
                sarespo.update(sa);
            }

            // STEP 2: withdraw money from MarketAccount
            double updateBalance = ma.getBalance() - total_money_needed;
            ma.setBalance(updateBalance);
            // ma.set_balance_date(Util.getCurrentDateFromDBAsString());
            ma.set_balance_date(LocalDate.now().toString());
            marespo.update(ma);


            // STEP 3: add to withdraw history and buy history
            // add to withdraw history
            Withdraw withdraw = new Withdraw();            
            withdraw.set_withdraw_date(Util.getCurrentDateFromDBAsString());
            withdraw.setWithdraw_amount(total_money_needed);
            withdraw.set_username(buy.get_username());
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

