package org.id2k1149.project_3.controllers;

import org.id2k1149.project_3.models.AppUser;
import org.id2k1149.project_3.models.Role;
import org.id2k1149.project_3.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<AppUser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public AppUser getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public void registerNewUser(@RequestBody AppUser appUser) {
        userService.addNewUser(appUser);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Role role
            ) {
            userService.updateUser(userId, name, email, password, role);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
