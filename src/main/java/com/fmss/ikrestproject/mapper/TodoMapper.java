package com.fmss.ikrestproject.mapper;

import com.fmss.ikrestproject.client.dto.request.TodoRequestDto;
import com.fmss.ikrestproject.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public Todo toEntity(TodoRequestDto todoRequestDto){
        final  var todo = new Todo();
        todo.setComment(todoRequestDto.getComment());
        todo.setDescription(todoRequestDto.getDescription());
        return todo;
    }
}
