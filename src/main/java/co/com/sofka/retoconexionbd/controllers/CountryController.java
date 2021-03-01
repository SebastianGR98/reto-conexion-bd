package co.com.sofka.retoconexionbd.controllers;

import co.com.sofka.retoconexionbd.dtos.CityDTO;
import co.com.sofka.retoconexionbd.dtos.CountryDTO;
import co.com.sofka.retoconexionbd.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/country")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<CountryDTO> getAllCountries() {
        List<CountryDTO> countries = new ArrayList<>();

        countryRepository.findAll().forEach(country -> {
            CountryDTO countryDTO = new CountryDTO();

            countryDTO.setName(country.getCountry());

            country.getCities().forEach(city -> {
                CityDTO cityDTO = new CityDTO();

                cityDTO.setName(city.getCity());
                cityDTO.setCountry(country.getCountry());

                countryDTO.addCity(cityDTO);
            });

            countries.add(countryDTO);
        });

        return countries;
    }
}
