package com.clone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageViewLinks {
  private String self;
  private String next;
  private String prev;
  private String last;
  private String related;
}
