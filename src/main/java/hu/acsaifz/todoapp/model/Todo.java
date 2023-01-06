package hu.acsaifz.todoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private LocalDateTime dateOfCreation = LocalDateTime.now();
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Todo(String description){
        this.description = description;
    }
}
