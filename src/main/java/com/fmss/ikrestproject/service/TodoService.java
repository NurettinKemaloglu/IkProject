package com.fmss.ikrestproject.service;

import com.fmss.ikrestproject.client.dto.request.TodoRequestDto;

public interface TodoService {
    void createTodo(TodoRequestDto todoRequestDto);

    void deleteTodo(Long id);
}
