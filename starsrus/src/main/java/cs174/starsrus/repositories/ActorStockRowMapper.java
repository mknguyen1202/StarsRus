package cs174.starsrus.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cs174.starsrus.entities.ActorStock;

public class ActorStockRowMapper implements RowMapper<ActorStock>{

    @Override
    public ActorStock mapRow(ResultSet rs, int rowNum) throws SQLException {
        ActorStock actorStock = new ActorStock();
        actorStock.setSymbol(rs.getString("symbol"));
        actorStock.setActor_name(rs.getString("actor_name"));
        actorStock.setActor_dob(rs.getString("actor_dob"));
        return actorStock;
    }
    
}
