package com.musicapp.dao.hr;

public class UserType {
  private long userTypeId;
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
