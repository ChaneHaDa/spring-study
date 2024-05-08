package com.chan.springauthorizationserver.user.customer;

import com.chan.springauthorizationserver.user.authority.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CustomerSecurityService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerSecurityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByName(username);
        if (customer != null) {
            return new User(customer.getName(), customer.getPassword(), getGrantedAuthorities(customer.getAuthorities()));
        }
        return null;
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+authority.getName()));
        }
        return grantedAuthorities;
    }
}
