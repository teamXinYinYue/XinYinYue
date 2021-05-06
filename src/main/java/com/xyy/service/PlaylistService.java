package com.xyy.service;

import com.xyy.po.Playlist;

import java.util.List;


public interface PlaylistService {
    int insertPlaylist(Playlist playlist);
    int deletePlaylist(String pname,Integer uid);
    int updatePlaylist(Playlist playlist);
    List<Playlist> findPlaylist(Integer u_id);

}
