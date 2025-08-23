package com.floproje.StokYonetim;

import com.floproje.StokYonetim.entity.Category;
import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.entity.UserRole;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.service.UserRoleService;
import com.floproje.StokYonetim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class StokYonetimApplication implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
		SpringApplication.run(StokYonetimApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //SpringApplication.run calistiginda, ilk olarak burasi calistirilacak, sonra uygulama ayaga kalkacak.
        if (userRoleService.findAll().isEmpty()){
            UserRole admin = new UserRole();
            admin.setRole(Role.ADMIN);

            userRoleService.save(admin);

            UserRole manager = new UserRole();
            manager.setRole(Role.MANAGER);

            userRoleService.save(manager);

            UserRole personnel = new UserRole();
            personnel.setRole(Role.PERSONNEL);

            userRoleService.save(personnel);

            //Roller eklendi
        }

        //Peki uygulamanin bir admini var mi?
        if (userService.countAdmins() == 0){
            User admin = new User();
            admin.setUsername("Admin");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            admin.setPhoneNumber("000");
            admin.setEmail("admin@stokyonetimuyg.com");
            admin.setUserRole(userRoleService.findByRole(Role.ADMIN));

            userService.saveUser(admin);
        }
    }
}
