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
    public int insertPlaylist(Playlist playlist) {
        return this.playlistMapper.insertSelective(playlist);
    }

    @Override
    public int deletePlaylist(String pname,Integer uid) {
        return this.playlistMapper.deleteByPrimaryKey(
                pname
                ,uid);
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
