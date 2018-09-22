package com.app.music.dao.models.music;

/**
 * Playlist Songs
 */
public class PlaylistChild {
  private long playlistId;
  private long songId;
  private long albumId;

  public long getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(long playlistId) {
    this.playlistId = playlistId;
  }

  public long getSongId() {
    return songId;
  }

  public void setSongId(long songId) {
    this.songId = songId;
  }

  public long getAlbumId() {
    return albumId;
  }

  public void setAlbumId(long albumId) {
    this.albumId = albumId;
  }
}
