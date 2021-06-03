package cs174.starsrus.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminStockRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public long count() {
        return 0;
    }


//     CREATE TABLE ActorStock (
//     symbol CHAR(3) NOT NULL,
//     actor_name CHAR(30),
//     actor_dob CHAR(10),
//     actor_movie_title CHAR(30),
//     actor_role CHAR(10),
//     actor_movie_contract REAL NOT NULL,
//     PRIMARY KEY (symbol)
// );


}
