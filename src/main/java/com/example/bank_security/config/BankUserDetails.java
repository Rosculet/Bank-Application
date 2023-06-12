/*
package com.example.bank_security.config;


import com.example.bank_security.model.CustomerEntity;
import com.example.bank_security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorityList = null;
        List<CustomerEntity> customers = customerRepository.findByEmail(username);
        if (customers.size() == 0) {
            throw new UsernameNotFoundException("User Details not found for the user" + username);
        } else {
          userName = customers.get(0).getEmail();
          password = customers.get(0).getPwd();
          authorityList = new ArrayList<>();
          authorityList.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }
        return new User(username,password,authorityList);
    }
}
*/
