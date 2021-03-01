package co.com.sofka.retoconexionbd.repositories;

import co.com.sofka.retoconexionbd.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {}
