package co.com.sofka.retoconexionbd.repositories;

import co.com.sofka.retoconexionbd.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {}
