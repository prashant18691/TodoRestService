package com.prs.webservice.helloworldservice.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.getAllTodos(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable int id){

        logger.info("username {}" , username);
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable int id){
        Todo todo = todoService.deleteById(id);
        if (todo!=null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Update Todo {}", todo);
        Todo todoUpdated = todoService.saveToDo(todo);
        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createToDo(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create Todo {}", todo);
        todo.setUsername(username);
        Todo toDoCreated = todoService.saveToDo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(toDoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
