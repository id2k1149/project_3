package org.id2k1149.project_3.config;

import org.id2k1149.project_3.models.User;
import org.id2k1149.project_3.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User admin_1 = new User(
                    true,
                    "admin_1@test.test",
                    "admin"
            );

            User admin_2 = new User(
                    true,
                    "admin_2@test.test",
                    "admin"
            );

            User john = new User(
                    false,
                    "john@test.test",
                    "pass"
            );

            User paul =new User(
                    false,
                    "paul@test.test",
                    "pass"
            );

            userRepository.saveAll(
                    List.of(admin_1, admin_2, john, paul)
            );
        };
    }
}
