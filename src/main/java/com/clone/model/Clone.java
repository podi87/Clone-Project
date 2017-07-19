package com.clone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Clone {

  @Id
  boolean status;

  public Clone(boolean status) {
    this.status = status;
  }
}
