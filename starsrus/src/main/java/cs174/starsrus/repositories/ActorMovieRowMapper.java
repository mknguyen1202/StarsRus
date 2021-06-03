package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.ActorMovie;

public class ActorMovieRowMapper implements RowMapper<ActorMovie>{

    @Override
    public ActorMovie mapRow(ResultSet rs, int rowNum) throws SQLException {


        ActorMovie actorMovie = new ActorMovie();
        actorMovie.setContract_id(rs.getInt("contract_id"));
        actorMovie.setContract_year(rs.getInt("contract_year"));
        actorMovie.setActor_role(rs.getString("actor_role"));
        actorMovie.setTitle(rs.getString("title"));
        actorMovie.setTotal_value(rs.getDouble("total_value"));
        actorMovie.setSymbol(rs.getString("symbol"));
        return actorMovie;
    }
    
}
