package hu.acsaifz.todoapp.controller;

import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import hu.acsaifz.todoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/users"})
public class UserController {
    private final UserService userService;

    @PostMapping(value = {"/register"})
    public UserDto addUser(@RequestBody UserCreateDto userDto){
        return userService.addUser(userDto);
    }
}
