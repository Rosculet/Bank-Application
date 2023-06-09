package com.example.bank_security.config;

import com.example.bank_security.model.authorities.AuthoritiesEntity;
import com.example.bank_security.model.customer.CustomerEntity;
import com.example.bank_security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class BankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<CustomerEntity> customerEntityList = customerRepository.findByEmail(username);
        if (customerEntityList.size() > 0) {
            if (passwordEncoder.matches(pwd, customerEntityList.get(0).getPwd())) {

/*              List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(customerEntityList.get(0).getRole()));*/

                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthority(customerEntityList.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("No User registered with this details");
        }
    }

    private List<GrantedAuthority> getGrantedAuthority(Set<AuthoritiesEntity> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AuthoritiesEntity authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
