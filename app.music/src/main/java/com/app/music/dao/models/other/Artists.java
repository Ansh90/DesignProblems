package com.app.music.dao.models.other;

public class Artists {
  private long artistId;
  private String name;
  private String totalSongs;
  private String totalAlbums;

  public long getArtistId() {
    return artistId;
  }

  public void setArtistId(long artistId) {
    this.artistId = artistId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTotalSongs() {
    return totalSongs;
  }

  public void setTotalSongs(String totalSongs) {
    this.totalSongs = totalSongs;
  }

  public String getTotalAlbums() {
    return totalAlbums;
  }

  public void setTotalAlbums(String totalAlbums) {
    this.totalAlbums = totalAlbums;
  }
}
