package cs174.starsrus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.entities.ActorStock;

@Repository
public class ActorStockRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

            // CREATE TABLE IF NOT EXISTS ActorStock (
    //     symbol CHAR(3) NOT NULL,
    //     actor_name CHAR(30),
    //     actor_dob CHAR(10),
    //     PRIMARY KEY (symbol)
    
    // );

    public int create(ActorStock actorStock) {
        //TODO: automatically create and add $1000 to Market account
        String QUERY = "INSERT INTO ActorStock"
                       + " VALUES(?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                    actorStock.getSymbol(),
                                    actorStock.getActor_name(),
                                    actorStock.getActor_dob());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int update(ActorStock actorStock) {
        String QUERY = "UPDATE ActorStock SET"
                                    + " actor_name = ?,"
                                    + " actor_dob = ?,"
                                    + " WHERE symbol = ?";
        try {
            jdbcTemplate.update(QUERY,  actorStock.getActor_name(),
                                        actorStock.getActor_dob(),
                                        actorStock.getSymbol().trim()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };


    public int deleteBySymbol(String symbol) {
        String QUERY = "DELETE FROM ActorStock WHERE symbol = ?";
        try {
            jdbcTemplate.update(QUERY, symbol);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ActorStock> findAll() {
        String QUERY = "SELECT * FROM ActorStock";
        return jdbcTemplate.query(QUERY, new ActorStockRowMapper());

    };

    public ActorStock findBySymbol(String symbol) {
        String QUERY = "SELECT * FROM ActorStock WHERE symbol=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { symbol },
				new BeanPropertyRowMapper<ActorStock>(ActorStock.class));        
    };
}
