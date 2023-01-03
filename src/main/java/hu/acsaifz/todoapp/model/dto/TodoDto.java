package hu.acsaifz.todoapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private long id;
    private String description;
    private LocalDateTime dateOfCreation;
    private boolean completed;
}
