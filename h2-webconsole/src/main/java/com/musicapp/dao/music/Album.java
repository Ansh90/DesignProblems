package com.musicapp.dao.music;

import java.util.Date;
import java.util.List;

public class Album {

  private long albumId;
  private String name;
  private int totalTracks;
  private Date releaseDate;
  private long genreId;
  private String imageResource;
  private String AlbumResource;
  private boolean downloadable;

/*  private List<Song> songList;

  public List<Song> getSongList() {
    return songList;
  }

  public void setSongList(List<Song> songList) {
    this.songList = songList;
  }*/


  public long getAlbumId() {
    return albumId;
  }

  public void setAlbumId(long albumId) {
    this.albumId = albumId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTotalTracks() {
    return totalTracks;
  }

  public void setTotalTracks(int totalTracks) {
    this.totalTracks = totalTracks;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public long getGenreId() {
    return genreId;
  }

  public void setGenreId(long genreId) {
    this.genreId = genreId;
  }

  public String getImageResource() {
    return imageResource;
  }

  public void setImageResource(String imageResource) {
    this.imageResource = imageResource;
  }

  public String getAlbumResource() {
    return AlbumResource;
  }

  public void setAlbumResource(String albumResource) {
    AlbumResource = albumResource;
  }

  public boolean isDownloadable() {
    return downloadable;
  }

  public void setDownloadable(boolean downloadable) {
    this.downloadable = downloadable;
  }
}
