package org.AbhishekKumar.controller;

import org.AbhishekKumar.model.User;
import org.AbhishekKumar.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("users/user/{uId}")
    User getUserById(@PathVariable Integer uId){
        return userService.getUser(uId);
    }
    @PostMapping("users/user")
    String addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping("users")
    String addUsers(@RequestBody @Valid List<User> userslist){
        return userService.addUsers(userslist);
    }
    @PutMapping("users/user/{uId}")
    String UpdateUserInfo(@PathVariable Integer uId,@RequestBody User user){
        return userService.UpdateUserInfo(uId,user);
    }
    @DeleteMapping("users")
    String remove(@RequestParam @Max(10000) Integer uId){
        return userService.remove(uId);
    }
}
