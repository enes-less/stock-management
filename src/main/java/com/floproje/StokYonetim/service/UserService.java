package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.UserCreateRequestDTO;
import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserCreateRequestDTO dto){}

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with given username: " + username));
    }
    //yeni eklenen metodlar aşağıda
    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with id: " + id));
    }

    // Tüm kullanıcıları listele !!PAGINATION LAZIM
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

    public long countUsers(){
        return userRepository.count();
    }

    public long countAdmins(){
        return userRepository.countAdmin(Role.ADMIN);
    }
}
