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
                    "john@test.test",
                    "John"
            );

            User paul =new User(
                    "paul@test.test",
                    "Paul"
            );

            userRepository.saveAll(
                    List.of(john, paul)
            );
        };
    }
}
