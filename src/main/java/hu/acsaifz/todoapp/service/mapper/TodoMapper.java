package hu.acsaifz.todoapp.service.mapper;

import hu.acsaifz.todoapp.model.Todo;
import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mapping(target = "id", source = "todo.id")
    @Mapping(target = "description", source = "todo.description")
    @Mapping(target = "dateOfCreation", source = "todo.dateOfCreation")
    @Mapping(target = "completed", source = "todo.completed")
    TodoDto toDto(Todo todo);

    List<TodoDto> toDto(List<Todo> todos);

    @Mapping(target = "description", source = "dto.description")
    Todo toTodo(TodoCreateDto dto);
}

