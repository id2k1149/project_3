package org.id2k1149.project_3.webControllers;

import org.id2k1149.project_3.models.AppUser;
import org.id2k1149.project_3.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
//@RequestMapping("/users")
public class UserWebController {
    private final UserService userService;

//    @Autowired
    public UserWebController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping()
    public List<AppUser> getUsers() {
        return userService.getUsers();
    }



}
