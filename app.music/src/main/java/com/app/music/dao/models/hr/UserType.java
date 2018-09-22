package com.app.music.dao.models.hr;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserType implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userTypeId;

  /**
   * Test how camel casing changes to _ seperation
   */
  //@UniqueConstraint(columnNames = "user")
  private String userType;

  private String userTypeDesc;

  public long getUserTypeId() {
    return userTypeId;
  }

  public void setUserTypeId(long userTypeId) {
    this.userTypeId = userTypeId;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserTypeDesc() {
    return userTypeDesc;
  }

  public void setUserTypeDesc(String userTypeDesc) {
    this.userTypeDesc = userTypeDesc;
  }
}
