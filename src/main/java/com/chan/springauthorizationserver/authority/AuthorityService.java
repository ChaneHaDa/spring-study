package com.chan.springauthorizationserver.authority;

import com.chan.springauthorizationserver.customer.Customer;
import com.chan.springauthorizationserver.customer.CustomerDTO;
import com.chan.springauthorizationserver.customer.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final CustomerService customerService;

    public AuthorityService(AuthorityRepository authorityRepository, CustomerService customerService) {
        this.authorityRepository = authorityRepository;
        this.customerService = customerService;
    }

    public AuthorityDTO createAuthority(AuthorityDTO authorityDTO) {
        CustomerDTO customerDTO = customerService.getCustomer(authorityDTO.getCustomerId());
        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getPassword());
        Authority authority = new Authority(authorityDTO.getId(), authorityDTO.getName(), customer);
        AuthorityDTO returnAuthorityDTO = AuthorityDTO.fromEntity(authorityRepository.save(authority));
        return returnAuthorityDTO;
    }
}
