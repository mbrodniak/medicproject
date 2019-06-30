package com.brodniak.medicproject.service;

import com.brodniak.medicproject.entity.Employer;
import com.brodniak.medicproject.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomEmployerDetailsService implements UserDetailsService {

    @Autowired
    EmployerRepository employerRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Employer employer = employerRepository.findByLogin(login);
        if(employer != null){
            EmployerPrincipal employerPrincipal = new EmployerPrincipal();
            employerPrincipal.setEmployer(employer);
            return employerPrincipal;
        }else{
            throw new UsernameNotFoundException(login);
        }
    }
}
