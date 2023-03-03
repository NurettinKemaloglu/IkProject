package com.fmss.ikrestproject.controller;

import com.fmss.ikrestproject.client.dto.request.TodoRequestDto;
import com.fmss.ikrestproject.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/todo")
@AllArgsConstructor
public class TodoController {
    private  final TodoService todoService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createTodo(@RequestBody TodoRequestDto todoRequestDto){
        this.todoService.createTodo(todoRequestDto);
    }
    @DeleteMapping("/{id}")
    public  void  deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}
