package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Wrong Type Parameter"),
        @ApiResponse(code = 404, message = "Does not exists"),
        @ApiResponse(code = 500, message = "Server Error")})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/login")
    public User findUser(@RequestParam(value = "id") String id,
                         @RequestParam(value = "pw") String pw) {
        return userService.findUser(id, pw);
    }

    @PostMapping(name = "/signup")
    public User signupUser(@RequestBody User user) {
        return userService.saveUser(
                user.getUserId(),
                user.getUserPassword(),
                user.getUserName());
    }
}
