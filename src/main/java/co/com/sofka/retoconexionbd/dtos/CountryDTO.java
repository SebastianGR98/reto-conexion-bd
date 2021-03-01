package co.com.sofka.retoconexionbd.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CountryDTO implements Serializable {
    private String name;
    private Set<CityDTO> cities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CityDTO> getCities() {
        return cities;
    }

    public void addCity(CityDTO cityDTO) {
        this.cities.add(cityDTO);
    }
}
