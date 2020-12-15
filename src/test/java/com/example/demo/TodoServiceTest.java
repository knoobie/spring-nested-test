package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entities.Todo;
import com.example.demo.repositories.LogRepository;
import com.example.demo.repositories.TodoRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@Import({TodoService.class})
@ExtendWith(SpringExtension.class)
class TodoServiceTest {

  @Autowired
  private LogRepository logRepository;

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private TodoService service;

  @Nested
  class CreateTodo {

    @Test
    void checkThatErrorIsPersistedOnException() {
      service.createTodo(new Todo("way too long message > 10 characters"));
      assertThat(todoRepository.findAll()).isEmpty();
      assertThat(logRepository.findAll()).hasSize(1);
    }
  }
}