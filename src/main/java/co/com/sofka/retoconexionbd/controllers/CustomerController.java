package co.com.sofka.retoconexionbd.controllers;

import co.com.sofka.retoconexionbd.dtos.CustomerDTO;
import co.com.sofka.retoconexionbd.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository.findAll().forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setId(customer.getCustomer_id());
            customerDTO.setFullName(customer.getFirst_name() + " " + customer.getLast_name());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setActive(customer.isActive());

            customers.add(customerDTO);
        });

        return customers;
    }
}
