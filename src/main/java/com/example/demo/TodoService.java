package com.example.demo;

import com.example.demo.entities.Log;
import com.example.demo.entities.Todo;
import com.example.demo.repositories.LogRepository;
import com.example.demo.repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TodoService {

  private final TodoRepository todoRepository;
  private final LogRepository logRepository;

  public TodoService(TodoRepository todoRepository, LogRepository logRepository) {
    this.todoRepository = todoRepository;
    this.logRepository = logRepository;
  }

  public void createTodo(Todo todo) {
    try {
      todoRepository.save(todo);
    } catch (DataIntegrityViolationException e) {
      log.warn("Could not store todo ", e);
      logRepository.save(new Log(e.getMessage()));
    }
  }
}
