package com.clone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "funnels")
public class Funnel {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;
  @OneToMany(mappedBy = "funnel", cascade = CascadeType.ALL)
  private List<FunnelEvent> events;
}