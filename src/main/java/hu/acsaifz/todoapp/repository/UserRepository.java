package hu.acsaifz.todoapp.repository;

import hu.acsaifz.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
