package hu.acsaifz.todoapp.service;

import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import hu.acsaifz.todoapp.repository.UserRepository;
import hu.acsaifz.todoapp.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto addUser(UserCreateDto userCreateDto){
        User user = userMapper.toUser(userCreateDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
