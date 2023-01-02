package hu.acsaifz.todoapp.model.exceptions;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(long id){
        super("Todo not found with id: " + id);
    }
}
