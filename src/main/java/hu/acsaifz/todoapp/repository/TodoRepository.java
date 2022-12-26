package hu.acsaifz.todoapp.repository;

import hu.acsaifz.todoapp.model.Todo;
import org.springframework.data.repository.ListCrudRepository;

public interface TodoRepository extends ListCrudRepository<Todo,Long> {

}
