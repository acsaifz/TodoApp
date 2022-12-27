package hu.acsaifz.todoapp.repository;

import hu.acsaifz.todoapp.model.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepository extends ListCrudRepository<Todo,Long> {

    @Modifying
    @Transactional
    @Query(value = "update Todo t set t.description = :description where t.id = :id")
    void updateTodoDescriptionById(@Param("id")long id,@Param("description") String description);

}
