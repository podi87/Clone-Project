package com.clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class EventToDatabase {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String path;
  String type;
  int count = 1;

  public EventToDatabase(String path, String type) {
    this.path = path;
    this.type = type;
  }

  public EventToDatabase(String path, String type, int count) {
    this.path = path;
    this.type = type;
    this.count = count;
  }
}
