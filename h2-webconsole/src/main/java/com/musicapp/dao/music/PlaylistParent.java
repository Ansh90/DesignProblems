package com.musicapp.dao.music;

import com.musicapp.dao.hr.User;

import java.util.List;

/**
 * User will have multiple playlists which can be managed with
 * playListid + userId composite key where userId is FK again.
 */
public class PlaylistParent {
  private long playlistId;
  private long userId;
  private String name;

//  private List<Song> songs;

  public long getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(long playlistId) {
    this.playlistId = playlistId;
  }

//  public List<Song> getSongs() {
//    return songs;
//  }
//
//  public void setSongs(List<Song> songs) {
//    this.songs = songs;
//  }

  private boolean favoriteFlag;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isFavoriteFlag() {
    return favoriteFlag;
  }

  public void setFavoriteFlag(boolean favoriteFlag) {
    this.favoriteFlag = favoriteFlag;
  }
}