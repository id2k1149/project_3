package org.id2k1149.project_3.config;

import org.id2k1149.project_3.models.AppUser;
import org.id2k1149.project_3.models.Role;
import org.id2k1149.project_3.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            AppUser admin_1 = new AppUser(
                    "admin_1",
                    "admin_1@test.test",
                    "admin",
                    Role.ADMIN
            );

            AppUser admin_2 = new AppUser(
                    "admin_2",
                    "admin_2@test.test",
                    "admin",
                    Role.ADMIN
            );

            AppUser john = new AppUser(
                    "John",
                    "john@test.test",
                    "j_pass",
                    Role.USER
            );

            AppUser paul =new AppUser(
                    "Paul",
                    "paul@test.test",
                    "p_pass",
                    Role.USER
            );

//            userRepository.saveAll(
//                    List.of(admin_1, admin_2, john, paul)
//            );
        };
    }
}
