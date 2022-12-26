package hu.acsaifz.todoapp.controller;

import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping(value = {"", "/"})
    public List<TodoDto> listTodos(){
        return todoService.findAll();
    }

    @PostMapping(value = {"", "/"})
    public TodoDto createTodo(@RequestBody TodoCreateDto todo){
        return todoService.save(todo);
    }

}
