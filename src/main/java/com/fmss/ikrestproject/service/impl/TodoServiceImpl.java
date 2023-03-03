package com.fmss.ikrestproject.service.impl;

import com.fmss.ikrestproject.client.dto.request.TodoRequestDto;
import com.fmss.ikrestproject.mapper.TodoMapper;
import com.fmss.ikrestproject.model.Todo;
import com.fmss.ikrestproject.repository.TodoRepository;
import com.fmss.ikrestproject.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private  final TodoMapper todoMapper;

    @Override
    public void createTodo(TodoRequestDto todoRequestDto) {
        Todo todo =  todoMapper.toEntity(todoRequestDto);
        todoRepository.save(todo);

    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
