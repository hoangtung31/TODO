package com.ftel.foxpay.demojpa.service;

import com.ftel.foxpay.demojpa.model.Todo;
import com.ftel.foxpay.demojpa.model.TodoValidator;
import com.ftel.foxpay.demojpa.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoValidator todoValidator;

    public Todo addTodo(Todo todo) {
        if (todoValidator.isValid(todo)) {
            return todoRepository.save(todo);
        }
        return null;
    }

    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> todoRepository.findAll());
    }
}
