package com.brodniak.medicproject.service;

import com.brodniak.medicproject.entity.User;
import com.brodniak.medicproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(name);
        if(user!=null){
            UserPrincipal userPrincipal = new UserPrincipal();
            userPrincipal.setUser(user);

            return userPrincipal;
        }
        else{
            throw new UsernameNotFoundException(name);
        }
    }
}
