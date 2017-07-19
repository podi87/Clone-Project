package com.clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class StepLinks extends Links {

  private String related;

  public StepLinks(String self, String related) {
    super(self);
    this.related = related;
  }
}
