package com.example.demo.Todo;

import com.example.demo.User.User;
import com.example.demo.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final UserRepo userRepo;

    @Autowired
    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }





    public List<Todo> getTodos(){
        return todoRepo.findAll();
    }

    public Todo addTodo(Todo todo){

        Long user_id = todo.getUser().getId();
        User user = userRepo.findById(user_id).orElse(null);

        if (user != null){
            todo.setUser(user);
        return todoRepo.save(todo);
        }

        return null;
    }

    public  void deleteTodo(String id){
        Long todoId = Long.parseLong(id);
        todoRepo.deleteById(todoId);
    }

    public Todo toggleTodo(String id){
        Long todoId = Long.parseLong(id);
        Todo todo = todoRepo.findById(todoId).orElse(null);

        if (todo != null){
            todo.setCompleted(!todo.isCompleted());
            todoRepo.save(todo);
        }

        return todo;
    }

}
