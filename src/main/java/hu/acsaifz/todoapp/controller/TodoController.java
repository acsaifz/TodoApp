package hu.acsaifz.todoapp.controller;

import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.model.dto.TodoUpdateDto;
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

    @GetMapping(value={"/{id}"})
    public TodoDto getTodoById(@PathVariable long id){
        return todoService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    public TodoDto createTodo(@RequestBody TodoCreateDto todo){
        return todoService.save(todo);
    }

    @PutMapping(value = {"/{id}"})
    public TodoDto updateTodo(@PathVariable long id, @RequestBody TodoUpdateDto todoUpdate){
        return todoService.updateDescriptionById(id, todoUpdate);
    }

    @PutMapping(value = "/{id}/complete")
    public TodoDto completeTodo(@PathVariable long id){
        return todoService.completeTodo(id);
    }
}
