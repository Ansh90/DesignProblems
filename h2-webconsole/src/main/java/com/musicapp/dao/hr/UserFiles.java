package com.musicapp.dao.hr;

public class UserFiles {
  private long fileId;
  private long userId;
  private String fileTypeId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getFileId() {
    return fileId;
  }

  public void setFileId(long fileId) {
    this.fileId = fileId;
  }

  public String getFileTypeId() {
    return fileTypeId;
  }

  public void setFileTypeId(String fileTypeId) {
    this.fileTypeId = fileTypeId;
  }
}
