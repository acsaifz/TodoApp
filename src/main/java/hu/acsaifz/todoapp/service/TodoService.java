package hu.acsaifz.todoapp.service;

import hu.acsaifz.todoapp.model.Todo;
import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.repository.TodoRepository;
import hu.acsaifz.todoapp.service.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDto> findAll(){
        List<Todo> todos = todoRepository.findAll();
        return todoMapper.toDto(todos);
    }

    public TodoDto save(TodoCreateDto todoCreateDto) {
        Todo todo = todoRepository.save(todoMapper.toTodo(todoCreateDto));
        return todoMapper.toDto(todo);
    }

    public TodoDto findById(long id) {
        Optional<Todo> result = todoRepository.findById(id);
        Todo todo = result.orElseThrow(() -> new NoSuchElementException("Todo not found: " + id));
        return todoMapper.toDto(todo);
    }
}
