package com.clone.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Steps {

  private Long id;
  private String type;
  private StepAttributes attributes;
}
