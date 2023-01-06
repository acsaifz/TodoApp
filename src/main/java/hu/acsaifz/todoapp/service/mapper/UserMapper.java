package hu.acsaifz.todoapp.service.mapper;

import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateDto userDto);

    UserDto toDto(User user);
}
