package com.xyy.service;

import com.xyy.po.Playlist;

import java.util.List;


public interface PlaylistService {
    int insertPlaylist(List<Playlist> playlists);
    int deletePlaylist(List<Playlist> playlists);
    int updatePlaylist(Playlist playlist);
    List<Playlist> findPlaylist(Integer u_id);

}
