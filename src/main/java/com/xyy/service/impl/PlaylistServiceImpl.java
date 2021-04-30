package com.xyy.service.impl;

import com.xyy.dao.PlaylistMapper;
import com.xyy.po.Playlist;
import com.xyy.po.PlaylistExample;
import com.xyy.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistMapper playlistMapper;

    @Override
    public int insertPlaylist(List<Playlist> playlists) {
        for (Playlist playlist : playlists){
            if(this.playlistMapper.insert(playlist)==0){
                throw new RuntimeException("未添加成功");
            }
        }
        return 1;
    }

    @Override
    public int deletePlaylist(List<Playlist> playlists) {
        for (Playlist playlist : playlists){
            if(this.playlistMapper.deleteByPrimaryKey(
                    playlist.getP_name()
                    ,playlist.getU_id()
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updatePlaylist(Playlist playlist) {
        PlaylistExample example = new PlaylistExample();
        example.createCriteria()
                .andU_idEqualTo(playlist.getU_id())
                .andP_nameEqualTo(playlist.getP_name());
        return this.playlistMapper.updateByExample(playlist,example);
    }

    @Override
    public List<Playlist> findPlaylist(Integer u_id) {
        PlaylistExample example = new PlaylistExample();
        example.createCriteria().andU_idEqualTo(u_id);
        return this.playlistMapper.selectByExample(example);
    }
}
