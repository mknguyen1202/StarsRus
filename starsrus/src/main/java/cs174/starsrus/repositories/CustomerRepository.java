package cs174.starsrus.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cs174.starsrus.entities.Customer;

public interface CustomerRepository extends CrudRepository{
    long count();

    int create(Customer customer);
    int update(Customer customer);
    int deleteByUsername(String username);

    List<Customer> findAll();
    List<Customer> findByUsername(String username);

    String getNameById(Long id);
}
