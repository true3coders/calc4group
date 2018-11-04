package org.calc4group.controllers;

import org.calc4group.dtos.UserDto;
import org.calc4group.entities.User;
import org.calc4group.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public String createUser(UserDto userDto) {
        User user = userService.addUser(userDto);
        return user.getUserId().toString();
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public void deleteUser(@PathVariable("user_id") Integer userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("{user_id}")
    public @ResponseBody User getUser(@PathVariable("user_id") Integer userId) {
        return userService.getUserById(userId);
    }
}
