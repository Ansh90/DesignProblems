package com.app.music.dao.models.music;

public class Song {

  private long songId;
  private String title;
  private double length;
  private long albumId;
  private boolean downloadable;
  private long genreId;
  private long resourceLink;

  public long getSongId() {
    return songId;
  }

  public void setSongId(long songId) {
    this.songId = songId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public long getAlbumId() {
    return albumId;
  }

  public void setAlbumId(long albumId) {
    this.albumId = albumId;
  }

  public boolean isDownloadable() {
    return downloadable;
  }

  public void setDownloadable(boolean downloadable) {
    this.downloadable = downloadable;
  }

  public long getGenreId() {
    return genreId;
  }

  public void setGenreId(long genreId) {
    this.genreId = genreId;
  }

  public long getResourceLink() {
    return resourceLink;
  }

  public void setResourceLink(long resourceLink) {
    this.resourceLink = resourceLink;
  }
}
