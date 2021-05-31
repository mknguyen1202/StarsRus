package cs174.starsrus.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Account;

public interface AccountRepository extends CrudRepository {
    long count();

    int create(Account account);
    int update(Account account);
    int deleteById(Long id);

    List<Account> findAll();

        
    List<Account> findByNameAndPrice(String name, BigDecimal price);

    Optional<Account> findById(Long id);

    String getNameById(Long id);

}
