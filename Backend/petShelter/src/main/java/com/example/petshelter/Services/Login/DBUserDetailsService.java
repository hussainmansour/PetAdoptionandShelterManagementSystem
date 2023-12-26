package com.example.petshelter.Services.Login;


import com.example.petshelter.DAOs.AdopterRepository;
import com.example.petshelter.DAOs.ManagerRepository;
import com.example.petshelter.DAOs.StaffRepository;
import com.example.petshelter.Models.Adopter;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DBUserDetailsService implements UserDetailsService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Adopter adopter = adopterRepository
                    .findById(username)
                    .orElse(null);

            Manager manager = managerRepository
                    .findById(username)
                    .orElse( null);

            Staff staff = staffRepository
                    .findById(username)
                    .orElse(null);

            if (adopter == null && manager == null && staff == null)
                throw new UsernameNotFoundException(
                        String.format("User %s not found", username)
                );

            return adopter == null ? manager == null ? staff : manager : adopter;
    }
}
