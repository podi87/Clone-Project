package com.clone.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

  private String status;
  private String database;


  public Status(String status, String database) {
    this.status = status;
    this.database = database;
  }

  public Status() {
  }
}
