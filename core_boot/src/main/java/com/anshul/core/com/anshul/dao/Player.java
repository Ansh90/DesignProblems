package com.anshul.core.com.anshul.dao;

import javax.persistence.*;

@Entity
@Table(name = "Player")
public class Player implements java.io.Serializable{

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "player_Sequence")
  @SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "num")
  private int num;

  @Column(name = "position")
  private String position;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id", nullable = false)
  private Team team;

  public Player() {
  }

// getters/setters
}