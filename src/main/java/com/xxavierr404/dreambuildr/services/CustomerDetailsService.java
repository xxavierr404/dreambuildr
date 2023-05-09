package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.dto.CustomerDetailsDTO;
import com.xxavierr404.dreambuildr.model.Customer;
import com.xxavierr404.dreambuildr.model.CustomerDetails;
import com.xxavierr404.dreambuildr.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {
    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public CustomerDetailsService(CustomerRepository repository) {
        this.repository = repository;
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = repository.findByUsername(username);
        if (customer.isEmpty()) throw new UsernameNotFoundException(username);
        return new CustomerDetails(customer.get());
    }

    public void doRegister(CustomerDetailsDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        repository.save(new Customer(dto));
    }
}
