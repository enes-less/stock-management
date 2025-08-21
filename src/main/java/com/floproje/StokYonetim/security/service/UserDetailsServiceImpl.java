package com.floproje.StokYonetim.security.service;

import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);

        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getUserRole().getRole().name());
    }
}
