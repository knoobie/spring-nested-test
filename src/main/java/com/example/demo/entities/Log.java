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
public class Log {

  public static final String TABLE = "REQUEST";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Log.TABLE + "_GENERATOR")
  @SequenceGenerator(name = Log.TABLE + "_GENERATOR", sequenceName = Log.TABLE + "_SEQ", allocationSize = 1)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "message", length = 500)
  private String message;

  public Log(String message) {
    this();
    this.message = message;
  }
}
