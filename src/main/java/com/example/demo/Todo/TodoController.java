package com.example.demo.Todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todos")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok().body(todoService.getTodos());
    }

    @PostMapping
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id){
        todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public Todo toggleTodo(@PathVariable String id){
        return todoService.toggleTodo(id);
    }

}
