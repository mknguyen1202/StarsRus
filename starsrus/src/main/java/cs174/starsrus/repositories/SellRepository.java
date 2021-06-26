package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.Util;
import cs174.starsrus.entities.Deposit;
import cs174.starsrus.entities.MarketAccount;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Sell;
import cs174.starsrus.entities.StockAccount;
import cs174.starsrus.entities.StockMarket;



@Repository
public class SellRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    DepositRepository derespo;

    @Autowired
    MarketAccountRepository marespo;

    @Autowired
    StockAccountRepository sarespo;

    @Autowired
    StockMarketRepository smrespo;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Sell";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    /**
     * This method subtracts shares from StockAccount, deposits money into MarketAccount, and
     * adds to deposit and sell history.
     * @param sell
     * @return
     */
    public int create(Sell sell) {
        try {
            // DepositRepository derespo = new DepositRepository();
            Deposit deposit = new Deposit();
            // MarketAccountRepository marespo = new MarketAccountRepository();
            // StockAccountRepository sarespo = new StockAccountRepository();
            // StockMarketRepository smrespo = new StockMarketRepository();

            // get customer's market account, the stock account, and the stock from the stock market
            MarketAccount marketAccount = marespo.findByMarketAccountUsername(sell.get_username());
            StockMarket stock = smrespo.findBySymbol(sell.get_symbol());
            StockAccount stockAccount = sarespo.findBySymbolUsername(sell.get_symbol(), sell.get_username());

            // stock does not exist, just extra check, will be constrained on frontend
            if (stockAccount == null) {
                return 0;
            }


            // not enough shares return error
            if (stockAccount.getBalance() < sell.getSell_shares()) {
                return 0;
            }
            

            double total_sell_in_dollars = stock.getCurrent_price() * sell.getSell_shares();    // money to get from sell
            double original_worth = stockAccount.getOriginal_buying_price() * sell.getSell_shares();

            double earning_from_sale = total_sell_in_dollars - original_worth;
            sell.setEarnings_from_sale(earning_from_sale);
            // sell.set_sell_date(Util.getCurrentDateFromDBAsString());    // current date (in the system) for sell
            sell.set_sell_date(LocalDate.now().toString());

            // substract shares from StockAccount
            stockAccount.setBalance(stockAccount.getBalance() - sell.getSell_shares());

            // deposit the money earned into MarketAccount
            double updatedBalance = marketAccount.getBalance() + total_sell_in_dollars;
            marketAccount.setBalance(updatedBalance);
            marespo.update(marketAccount);

            // add to deposit and to sell history
            // to deposit history
            deposit.setDeposit_amount(total_sell_in_dollars);
            // deposit.set_deposit_date(Util.getCurrentDateFromDBAsString());
            deposit.set_deposit_date(LocalDate.now().toString());
            deposit.set_username(sell.get_username());
            derespo.create(deposit);    
            
            // to sell history
            String QUERY = "INSERT INTO Sell(sell_date, sell_shares, earnings_from_sale, username, symbol)"
                            + " VALUES(?,?,?,?,?)" ;
            jdbcTemplate.update(QUERY, 
                                // sell.get_sell_id(),
                                sell.get_sell_date(),
                                sell.getSell_shares(),
                                sell.getEarnings_from_sale(),
                                sell.get_username(),
                                sell.get_symbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };
    
    public int update(Sell sell) {
        String QUERY = "UPDATE Sell SET"
                                    + " sell_date = ?,"
                                    + " sell_shares = ?,"
                                    + " earnings_from_sale = ?,"
                                    + " username = ?,"
                                    + " symbol = ?,"
                                    + " WHERE sell_id = ?";
        try {
            jdbcTemplate.update(QUERY,  sell.get_sell_date(),
                                        sell.getSell_shares(),
                                        sell.getEarnings_from_sale(),
                                        sell.get_username(),
                                        sell.get_symbol(),
                                        sell.get_sell_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteBySellID(int id) {
        String QUERY = "DELETE FROM Sell WHERE sell_id = ?";
        try {
            jdbcTemplate.update(QUERY, id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Sell> findAll() {
        String QUERY = "SELECT * FROM Sell";
        return jdbcTemplate.query(QUERY, new SellRowMapper());
    };
    public Sell findBySellID(int id) {
        String QUERY = "SELECT * FROM Sell WHERE sell_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { id },
				new BeanPropertyRowMapper<Sell>(Sell.class));        
    };



}

