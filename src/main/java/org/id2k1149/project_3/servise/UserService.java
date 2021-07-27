package org.id2k1149.project_3.servise;

import org.id2k1149.project_3.models.AppUser;
import org.id2k1149.project_3.models.Role;
import org.id2k1149.project_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final static String NOT_FOUND = "user with email %s is not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(NOT_FOUND, email)));
    }

    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    public AppUser getUser(Long userId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "appUser with id " + userId + " does not exist"));
        return appUser;
    }

//    public void addNewUser(AppUser appUser) {
//        Optional<AppUser> userOptional = userRepository
//                .findUserByEmail(appUser.getEmail());
//        if(userOptional.isPresent()) {
//            throw new IllegalStateException("we have this email");
//        }
//        userRepository.save(appUser);
//    }

    public String addNewUser(AppUser appUser) {
        boolean userExists = userRepository
                .findUserByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("this email is already used");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        userRepository.save(appUser);

        return "A new user was added";
    }

    @Transactional
    public void updateUser(Long userId,
                           String name,
                           String email,
                           String password,
                           Role role
                           ) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "appUser with id " + userId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(appUser.getName(), name)) {
            appUser.setName(name);
        }

        if (email != null  && !Objects.equals(appUser.getEmail(), email)) {
            Optional<AppUser> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("we have this email");
            }
            appUser.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(appUser.getPassword(), password)) {
            appUser.setPassword(password);
        }

        appUser.setRole(role);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }
}
