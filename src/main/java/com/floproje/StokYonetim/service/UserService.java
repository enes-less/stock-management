package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.UserCreateRequestDTO;
import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.exception.EntityNotFoundException;
import com.floproje.StokYonetim.exception.NotPermittedActionException;
import com.floproje.StokYonetim.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserCreateRequestDTO dto){}

    @PermitAll
    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("No user found with given username: " + username));
    }

    //yeni eklenen metodlar aşağıda
    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user found with id: " + id));
    }

    // Tüm kullanıcıları listele !!PAGINATION LAZIM
    public Map<String, Object> findAll(int page, int size, String sortBy, Sort.Direction order){
        Pageable pageable;

        //Pageable icin verilen bilgiler eksikse yerine manuel olarak id'nin artan sirasina gore urunleri getirdik
        //(default)
        if (sortBy != null && order != null){
            pageable = PageRequest.of(page, size, order, sortBy);
        }else{
            if (sortBy != null){
                pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
            }else if(order != null){
                pageable = PageRequest.of(page, size, order, "id");
            }else{
                pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
            }
        }
        Page<User> userPage = userRepository.findAll(pageable);

        List<User> userList = userPage.stream().toList();

        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", pageable.getPageNumber() + 1);
        map.put("totalPages", userPage.getTotalPages());
        map.put("userCount", userPage.getNumberOfElements());
        map.put("totalUsers", userPage.getTotalElements());
        map.put("users", userList);

        return map;
    }

    // Kullanıcı silme
    public void deleteById(Long id){
        User foundUser = findById(id);
        if (Role.ADMIN.equals(foundUser.getUserRole().getRole())){
            throw new NotPermittedActionException("Admins cannot be deleted! Admin ID: " + id);
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
