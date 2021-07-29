package org.id2k1149.project_3.registration;

import org.id2k1149.project_3.models.AppUser;
import org.id2k1149.project_3.models.Role;
import org.id2k1149.project_3.servise.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public RegistrationService(UserService userService,
                               EmailValidator emailValidator) {
        this.userService = userService;
        this.emailValidator = emailValidator;
    }

    public void register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email is not valid");
        }
        userService.addNewUser(
                new AppUser(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        Role.USER
                )
        );
    }
}
