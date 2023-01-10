package hu.acsaifz.todoapp.controller;

import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import hu.acsaifz.todoapp.model.dto.UserUpdateDto;
import hu.acsaifz.todoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/users"})
public class UserController {
    private final UserService userService;

    @PostMapping(value = {"/register"})
    public UserDto addUser(@RequestBody UserCreateDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping(value = {"/profile"})
    public UserDto getLoggedInUser(Authentication authentication){
        return userService.getUserByUsername(authentication.getName());
    }

    @PutMapping(value = {"/profile"})
    public UserDto updateUser(@RequestBody UserUpdateDto userDto){
        return userService.updateUser(userDto);
    }
}
