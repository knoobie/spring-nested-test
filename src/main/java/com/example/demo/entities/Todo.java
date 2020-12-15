package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

  public static final String TABLE = "REQUEST";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Todo.TABLE + "_GENERATOR")
  @SequenceGenerator(name = Todo.TABLE + "_GENERATOR", sequenceName = Todo.TABLE + "_SEQ", allocationSize = 1)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "message", length = 10)
  private String message;

  public Todo(String message) {
    this();
    this.message = message;
  }
}
