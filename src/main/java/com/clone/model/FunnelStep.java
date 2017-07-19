package com.clone.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FunnelStep {

  private PageViewLinks pageViewLinks;
  private List<StepData> data;

}
