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
            User john = new User(
                    "John",
                    "john@test.test",
                    LocalDate.of(1940, OCTOBER, 9)

            );

            User paul =new User(
                    "Paul",
                    "paul@test.test",
                    LocalDate.of(1942, JUNE, 18)

            );

            userRepository.saveAll(
                    List.of(john, paul)
            );
        };
    }
}
