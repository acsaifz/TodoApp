package hu.acsaifz.todoapp.service.mapper;

import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.UserCreateDto;
import hu.acsaifz.todoapp.model.dto.UserDto;
import hu.acsaifz.todoapp.model.dto.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateDto userDto);

    UserDto toDto(User user);

    User updateUserFromDto(UserUpdateDto userDto, @MappingTarget User user);
}
