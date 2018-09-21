package com.musicapp.dao.other;

public class FileType {
  private long fileTypeId;
  private String name;
  private String description;

  public long getFileTypeId() {
    return fileTypeId;
  }

  public void setFileTypeId(long fileTypeId) {
    this.fileTypeId = fileTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
