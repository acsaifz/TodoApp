package hu.acsaifz.todoapp.repository;

import hu.acsaifz.todoapp.model.Todo;
import hu.acsaifz.todoapp.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends ListCrudRepository<Todo,Long> {

    @Modifying
    @Transactional
    @Query(value = "update Todo t set t.description = :description where t.id = :id")
    void updateTodoDescriptionById(@Param("id")long id,@Param("description") String description);

    @Modifying
    @Transactional
    @Query(value = "update Todo t set t.completed = true where t.id = :id")
    void completeTodoById(long id);

    @Modifying
    @Transactional
    @Query(value = "delete from Todo t where t.id = :id")
    int deleteTodoById(long id);

    List<Todo> findAllByUser(User user);

    void deleteAllByUser_Id(long id);
}
