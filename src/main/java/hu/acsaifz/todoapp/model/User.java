package hu.acsaifz.todoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private int age;
    @CreationTimestamp
    private LocalDateTime registrationDate;
    private String password;
    private boolean enabled = true;
    @OneToMany(mappedBy = "user")
    private List<Todo> todos = new ArrayList<>();

    public Todo addTodo(Todo todo){
        todos.add(todo);
        todo.setUser(this);
        return todo;
    }
}
