package hu.acsaifz.todoapp.service;

import hu.acsaifz.todoapp.model.Todo;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.repository.TodoRepository;
import hu.acsaifz.todoapp.service.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDto> findAll(){
        List<Todo> todos = todoRepository.findAll();
        return todoMapper.toDto(todos);
    }

}
