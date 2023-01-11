package hu.acsaifz.todoapp.controller;

import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.model.dto.TodoUpdateDto;
import hu.acsaifz.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/todos"})
public class TodoController {
    private final TodoService todoService;

    @GetMapping(value = {"", "/"})
    public List<TodoDto> listTodos(Authentication authentication){
        User currentUser = (User) authentication.getPrincipal();
        return todoService.findAllByUser(currentUser);
    }

    @GetMapping(value={"/{id}"})
    public TodoDto getTodoById(@PathVariable long id){
        return todoService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDto createTodo(@RequestBody TodoCreateDto todo, Authentication authentication){
        User currentUser = (User) authentication.getPrincipal();
        return todoService.save(todo, currentUser);
    }

    @PutMapping(value = {"/{id}"})
    public TodoDto updateTodo(@PathVariable long id, @RequestBody TodoUpdateDto todoUpdate){
        return todoService.updateDescriptionById(id, todoUpdate);
    }

    @PutMapping(value = {"/{id}/complete"})
    public TodoDto completeTodo(@PathVariable long id){
        return todoService.completeTodo(id);
    }

    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable long id){
        todoService.deleteTodo(id);
    }
}
