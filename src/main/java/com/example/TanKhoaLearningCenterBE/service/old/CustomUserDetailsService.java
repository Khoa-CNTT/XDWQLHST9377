package com.example.TanKhoaLearningCenterBE.service.old;

import com.example.TanKhoaLearningCenterBE.repository.old.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //can add logic to deal with the optional
        var user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find user");
        };

        //this is where you can add roles & authorities to the user

        //relational mapping to get roles & authorites
        var userEntity = user.get();
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword()).build();
    }
}
