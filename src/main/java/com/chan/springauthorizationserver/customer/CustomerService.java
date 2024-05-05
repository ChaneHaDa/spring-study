package com.chan.springauthorizationserver.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPassword());
        customer = customerRepository.save(customer);
        return CustomerDTO.fromEntity(customer);
    }

    public CustomerDTO getCustomer(Long id) {
        return customerRepository.findById(id)
                .map(CustomerDTO::fromEntity)
                .orElse(null);
    }
}
