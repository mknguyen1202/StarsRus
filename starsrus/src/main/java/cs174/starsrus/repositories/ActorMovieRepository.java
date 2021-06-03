package cs174.starsrus.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs174.starsrus.entities.ActorMovie;

@Repository
public class ActorMovieRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

//     CREATE TABLE IF NOT EXISTS ActorMovie (
//     contract_id INTEGER,
//     contract_year INTEGER,
//     actor_role CHAR(20),
//     title CHAR(20),
//     total_value REAL,
//     symbol INTEGER NOT NULL,
//     PRIMARY KEY (contract_id),
//     FOREIGN KEY (symbol) REFERENCES ActorStock(symbol)
//         ON DELETE CASCADE
//         ON UPDATE CASCADE
// );
    
    public int create(ActorMovie actorMovie) {
        String QUERY = "INSERT INTO ActorMovie(contract_year, actor_role, title, total_value, symbol)"
                       + " VALUES(?,?,?,?,?)" ;
        try {
            jdbcTemplate.update(QUERY, 
                                    actorMovie.getContract_year(),
                                    actorMovie.getActor_role(),
                                    actorMovie.getTitle(),
                                    actorMovie.getTotal_value(),
                                    actorMovie.getSymbol());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int update(ActorMovie actorMovie) {
        String QUERY = "UPDATE ActorMovie SET"
                                    + " contract_year = ?,"
                                    + " actor_role = ?,"
                                    + " title = ?,"
                                    + " total_value = ?,"
                                    + " symbol = ?,"
                                    + " WHERE contract_id = ?";
        try {
            jdbcTemplate.update(QUERY,  actorMovie.getContract_year(),
                                        actorMovie.getActor_role(),
                                        actorMovie.getTitle(),
                                        actorMovie.getTotal_value(),
                                        actorMovie.getSymbol(),
                                        actorMovie.getContract_id()); // WHERE
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    };

    public int deleteByContractId(int contract_id) {
        String QUERY = "DELETE FROM ActorMovie WHERE contract_id = ?";
        try {
            jdbcTemplate.update(QUERY, contract_id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    public List<ActorMovie> findAll() {
        String QUERY = "SELECT * FROM ActorMovie";
        return jdbcTemplate.query(QUERY, new ActorMovieRowMapper());
    };


    public ActorMovie findByContractId(int control_id) {
        String QUERY = "SELECT * FROM ActorMovie WHERE contract_id=?";
		return jdbcTemplate.queryForObject(QUERY, new Object[] { control_id },
				new BeanPropertyRowMapper<ActorMovie>(ActorMovie.class));        
    };


}
