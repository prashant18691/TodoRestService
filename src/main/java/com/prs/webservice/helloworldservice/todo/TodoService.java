package com.prs.webservice.helloworldservice.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(String username){
        return todoRepository.findByUsername(username);
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if(todo==null)
            return null;
        todoRepository.deleteById(id);
        return todo;
    }

    public Todo findById(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(!todo.isPresent())
            return null;
        return todo.get();
    }

    public Todo saveToDo(Todo todo){
        return todoRepository.save(todo);
    }
}
