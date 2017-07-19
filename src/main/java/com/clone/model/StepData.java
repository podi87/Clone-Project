package com.clone.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StepData {

  private String type;
  private int id;

  public StepData(int id) {
    this.type = "steps";
    this.id = id;
  }
}
