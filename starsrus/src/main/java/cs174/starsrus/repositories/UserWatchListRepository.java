package cs174.starsrus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import cs174.starsrus.entities.UserWatchList;


@Repository
public interface UserWatchListRepository  extends JpaRepository<UserWatchList, Long> {
    
    Optional<UserWatchList> findByUsername(String username);
    
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    
    List<UserWatchList> findAll();
    
}
