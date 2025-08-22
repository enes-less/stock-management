package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByName(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with given username: " + username));
    }
    //yeni eklenen metodlar aşağıda
    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with id: " + id));
    }

    // Tüm kullanıcıları listele
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Kullanıcı silme
    public void deleteById(Long id){
        if(!userRepository.existsById(id)){
            throw new UsernameNotFoundException("No user found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
