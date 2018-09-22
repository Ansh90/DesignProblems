package com.app.music.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {


  @Autowired
  private SessionFactory sessionFactory;


  public void create() {

    Session session = sessionFactory.openSession();
    System.out.println("Session created");

  }
}
