package hu.acsaifz.todoapp.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {
    private long id;
    private String description;
    private LocalDateTime dateOfCreation;
    private boolean completed;
}
