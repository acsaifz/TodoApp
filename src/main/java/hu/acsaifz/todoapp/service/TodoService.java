package hu.acsaifz.todoapp.service;

import hu.acsaifz.todoapp.model.Todo;
import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.model.dto.TodoUpdateDto;
import hu.acsaifz.todoapp.model.exceptions.TodoNotFoundException;
import hu.acsaifz.todoapp.repository.TodoRepository;
import hu.acsaifz.todoapp.service.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final UserService userService;

    public List<TodoDto> findAll(){
        User user = userService.getCurrentUser();
        List<Todo> todos = todoRepository.findAllByUser(user);
        return todoMapper.toDto(todos);
    }

    @Transactional
    public TodoDto save(TodoCreateDto todoCreateDto) {
        User user = userService.getCurrentUser();
        Todo todo = todoMapper.toTodo(todoCreateDto);
        user.addTodo(todo);
        return todoMapper.toDto(todoRepository.save(todo));
    }

    public TodoDto findById(long id) {
        Optional<Todo> result = todoRepository.findById(id);
        Todo todo = result.orElseThrow(() -> new TodoNotFoundException(id));
        return todoMapper.toDto(todo);
    }

    public TodoDto updateDescriptionById(long id, TodoUpdateDto todoUpdateDto) {
        todoRepository.updateTodoDescriptionById(id, todoUpdateDto.getDescription());
        return this.findById(id);
    }

    public TodoDto completeTodo(long id) {
        todoRepository.completeTodoById(id);
        return this.findById(id);
    }

    public void deleteTodo(long id) {
        if (todoRepository.deleteTodoById(id) == 0){
            throw new TodoNotFoundException(id);
        }
    }
}
