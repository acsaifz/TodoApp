package hu.acsaifz.todoapp.service;

import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import hu.acsaifz.todoapp.model.dto.UserUpdateDto;
import hu.acsaifz.todoapp.repository.UserRepository;
import hu.acsaifz.todoapp.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto addUser(UserCreateDto userCreateDto){
        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        User user = userMapper.toUser(userCreateDto);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto updateUser(UserUpdateDto userDto){
        User user = getCurrentUser();
        user = userRepository.save(userMapper.updateUserFromDto(userDto, user));
        return userMapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username);
    }

    public UserDto getUserByUsername(String username){
        User user = findUserByUsername(username);
        return userMapper.toDto(user);
    }

    private User findUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return findUserByUsername(authentication.getName());
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
