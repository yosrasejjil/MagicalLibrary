package com.example.MagicalLibraryy.services;


import com.example.MagicalLibraryy.Repositories.UserRepository;
import com.example.MagicalLibraryy.models.CustomUserDetail;
import com.example.MagicalLibraryy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User"));
        return user.map(CustomUserDetail::new).get();
    }
}