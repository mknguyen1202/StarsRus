package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.entities.Deposit;

// import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Sell;
import cs174.starsrus.entities.StockAccount;
import cs174.starsrus.entities.StockMarket;



@Repository
public class SellRepository {

    @Autowired
	JdbcTemplate jdbcTemplate;


    public long count() {
        String QUERY = "SELECT COUNT(*) FROM Sell";
        return jdbcTemplate.queryForObject(QUERY, Long.class);
    };

    /**
     * This method subtracts shares from StockAccount, deposits money into MarketAccount, and
     * adds to sell history.
     * @param sell
     * @return
     */
    public int create(Sell sell) {
        try {
            DepositRepository derespo = new DepositRepository();
            Deposit deposit = new Deposit();
            MarketAccountRepository marespo = new MarketAccountRepository();
            StockAccountRepository sarespo = new StockAccountRepository();
            StockMarketRepository smrespo = new StockMarketRepository();

            StockMarket stock = smrespo.findBySymbol(sell.get_symbol());
            List<StockAccount> salist = sarespo.findByKey(sym, user, obp)

            double earning_from_sale = stock.getCurrent_price() * sell.getSell_shares();

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

