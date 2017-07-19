package com.clone.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FunnelFormat {
  private PageViewLinks pageViewLinks;
  private FunnelData data;
}
