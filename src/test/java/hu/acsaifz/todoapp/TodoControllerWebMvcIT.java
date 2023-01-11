package hu.acsaifz.todoapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.acsaifz.todoapp.controller.TodoController;
import hu.acsaifz.todoapp.model.User;
import hu.acsaifz.todoapp.model.dto.TodoCreateDto;
import hu.acsaifz.todoapp.model.dto.TodoDto;
import hu.acsaifz.todoapp.model.dto.TodoUpdateDto;
import hu.acsaifz.todoapp.model.exceptions.TodoNotFoundException;
import hu.acsaifz.todoapp.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoController.class)
class TodoControllerWebMvcIT {

    @MockBean
    TodoService todoService;

    @Autowired
    MockMvc mockMvc;

   /*@Test
    void testListTodos() throws Exception {
        when(todoService.findAllByUser(new User()))
                .thenReturn(List.of(
                        new TodoDto(1L, "First task", LocalDateTime.of(2023,1,2,9,57),false),
                        new TodoDto(2L, "Second task", LocalDateTime.of(2023,1,2,10,4),false)
                ));

        mockMvc.perform(get("/api/todos"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description",equalTo("First task")))
                .andExpect(jsonPath("$[1].description",equalTo("Second task")));
    }

    @Test
    void testGetTodoById() throws Exception {
        when(todoService.findById(anyLong()))
                .thenReturn(new TodoDto(1L,"Example task", LocalDateTime.of(2023,1,2,9,57),false));

        mockMvc.perform(get("/api/todos/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("description", equalTo("Example task")));
    }

    @Test
    void testGetTodoByIdNotFound() throws Exception {
        when(todoService.findById(anyLong())).thenThrow(new TodoNotFoundException(1L));

        mockMvc.perform(get("/api/todos/{id}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("detail", equalTo("Todo not found with id: 1")));
    }

    @Test
    void testCreateTodo() throws Exception {
        when(todoService.save(any(TodoCreateDto.class), any(User.class)))
                .thenReturn(new TodoDto(1L,"Example task", LocalDateTime.now(),false));

        mockMvc.perform(post("/api/todos")
                    .content(asJsonString(new TodoCreateDto("Example task")))
                    .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("description", equalTo("Example task")));
    }

    @Test
    void testUpdateTodo() throws Exception {
        when(todoService.updateDescriptionById(anyLong(), any(TodoUpdateDto.class)))
                .thenReturn(new TodoDto(1L, "Updated task", LocalDateTime.of(2023,1,2,11,0),false));


        mockMvc.perform(put("/api/todos/{id}", 1)
                    .content(asJsonString(new TodoUpdateDto("Updated task")))
                    .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("description", equalTo("Updated task")));
    }

    @Test
    void testUpdateTodoNotFound() throws Exception {
        when(todoService.updateDescriptionById(anyLong(), any(TodoUpdateDto.class)))
                .thenThrow(new TodoNotFoundException(1L));

        mockMvc.perform(put("/api/todos/{id}", 1)
                    .content(asJsonString(new TodoUpdateDto("Updated task")))
                    .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("detail", equalTo("Todo not found with id: 1")));
    }

    @Test
    void testCompleteTodo() throws Exception {
        when(todoService.completeTodo(anyLong()))
                .thenReturn(new TodoDto(1L, "First todo", LocalDateTime.of(2023,1,2,9,57), true));

        mockMvc.perform(put("/api/todos/{id}/complete",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("completed",equalTo(true)));
    }

    @Test
    void testCompleteTodoNotFound() throws Exception {
        when(todoService.completeTodo(anyLong()))
                .thenThrow(new TodoNotFoundException(1L));

        mockMvc.perform(put("/api/todos/{id}/complete",1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("detail", equalTo("Todo not found with id: 1")));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

}
